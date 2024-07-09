package com.example.rtoexam;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SettingsHelpActivity extends AppCompatActivity {
    Toolbar shtoolbar;
    Button removeAdsButton;
    TextView process_driving_licence, rto_offices, disclaimer, privacy_policy, terms_conditions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_help);
        shtoolbar = findViewById(R.id.shtoolbar);
        setSupportActionBar(shtoolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        removeAdsButton = findViewById(R.id.remove_ads_button);
        removeAdsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoDialog("Remove Ads","By removing ads, you'll enjoy an uninterrupted experience. Please note that it may involve a one-time or recurring fee.");
            }
        });

        process_driving_licence = findViewById(R.id.process_driving_licence);
        process_driving_licence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), ProcessDLActivity.class);
                startActivity(intent);
            }
        });

        rto_offices = findViewById(R.id.rto_offices);
        rto_offices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), RTOOfficesActivity.class);
                startActivity(intent);
            }
        });

        disclaimer = findViewById(R.id.disclaimer);
        disclaimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoDialog("Disclaimer","This test is only for public awareness. Though all efforts have been made to ensure the accuracy of the content, the same should not be construed as a statement of law or used for any legal purposes. This application accepts no responsibility in relation to the accuracy, completeness, usefulness or otherwise, of the contents. Users are advised to verify/check any information with the Transport Department.");
            }
        });

        privacy_policy = findViewById(R.id.privacy_policy);
        privacy_policy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), PrivacyPolicyActivity.class);
                startActivity(intent);
            }
        });

        terms_conditions = findViewById(R.id.terms_conditions);
        terms_conditions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), TermsConditionsActivity.class);
                startActivity(intent);
            }
        });
    }

    private void showInfoDialog(String title, String message) {
        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(android.text.Html.fromHtml(message))
                .setPositiveButton("OK", null)
                .show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}