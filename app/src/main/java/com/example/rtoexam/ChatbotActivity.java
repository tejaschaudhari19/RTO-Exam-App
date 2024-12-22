package com.example.rtoexam;

import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.ai.client.generativeai.GenerativeModel;
import com.google.ai.client.generativeai.java.GenerativeModelFutures;
import com.google.ai.client.generativeai.type.Content;
import com.google.ai.client.generativeai.type.GenerateContentResponse;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

public class ChatbotActivity extends AppCompatActivity {

    private LinearLayout chatContainer;
    private EditText inputMessage;
    private ScrollView scrollView;
    private TextView responseText;
    private GenerativeModelFutures model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatbot_interface);

        chatContainer = findViewById(R.id.chat_container);
        inputMessage = findViewById(R.id.input_message);
        scrollView = findViewById(R.id.scroll_view);
        responseText = findViewById(R.id.response_text);

        GenerativeModel gm = new GenerativeModel("gemini-pro", "API_KEY_HERE");
        model = GenerativeModelFutures.from(gm);

        Button sendButton = findViewById(R.id.send_button);
        sendButton.setOnClickListener(this::onSendButtonClicked);

        inputMessage.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_SEND ||
                    (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN)) {
                onSendButtonClicked(v);
                return true;
            }
            return false;
        });
    }

    private void onSendButtonClicked(View view) {
        String userMessage = inputMessage.getText().toString().trim();
        if (userMessage.isEmpty()) {
            Toast.makeText(this, "Message cannot be empty", Toast.LENGTH_SHORT).show();
            return;
        }

        // Add context to the user's message
        String contextMessage = "You are an intelligent chatbot designed to assist with RTO-related queries. " +
                "The user is seeking information or help regarding various RTO processes like license applications, " +
                "vehicle registration, traffic rules, exams, and other RTO services. " +
                "Please respond with accurate and helpful information based on RTO guidelines.";

        String finalMessage = contextMessage + " User query: " + userMessage;

        addMessageToChat("You: " + userMessage);
        inputMessage.setText("");
        responseText.setVisibility(View.VISIBLE);

        Content content = new Content.Builder()
                .addText(finalMessage)
                .build();

        ListenableFuture<GenerateContentResponse> response = model.generateContent(content);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            Futures.addCallback(response, new FutureCallback<GenerateContentResponse>() {
                @Override
                public void onSuccess(GenerateContentResponse result) {
                    responseText.setVisibility(View.GONE);
                    String responseText = result.getText().replace("*", "");
                    addMessageToChat("Gemini: " + responseText);
                }

                @Override
                public void onFailure(Throwable t) {
                    responseText.setVisibility(View.GONE);
                    addMessageToChat("Error: " + t.getMessage());
                }
            }, getMainExecutor());
        }
    }

    private void addMessageToChat(String message) {
        TextView textView = new TextView(this);
        textView.setText(message);
        textView.setPadding(16, 16, 16, 16);
        chatContainer.addView(textView);
        scrollView.post(() -> scrollView.fullScroll(View.FOCUS_DOWN));
    }
}