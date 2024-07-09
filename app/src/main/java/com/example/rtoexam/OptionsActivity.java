package com.example.rtoexam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class OptionsActivity extends AppCompatActivity {
    Toolbar toolbar;
    CardView qbcard,practicecard,examcard,settingscard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        qbcard=findViewById(R.id.qbcard);
        qbcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), QBActivity.class);
                startActivity(intent);
            }
        });

        practicecard=findViewById(R.id.practicecard);
        practicecard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), PracticeActivity.class);
                startActivity(intent);
            }
        });

        examcard=findViewById(R.id.examcard);
        examcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), ExamActivity.class);
                startActivity(intent);
            }
        });

        settingscard=findViewById(R.id.settingscard);
        settingscard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), SettingsHelpActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflator=getMenuInflater();
        inflator.inflate(R.menu.option_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if (id==R.id.settings) {
            Intent intent=new Intent(getApplicationContext(), SettingsHelpActivity.class);
            startActivity(intent);
            return true;
        }
        else if (id == R.id.help) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://parivahan.gov.in/parivahan/"));
            startActivity(browserIntent);
            return true;
        }
        else if (id == R.id.quit) {
            finishAffinity();
            return true;
        }
        else
            return true;
    }
}