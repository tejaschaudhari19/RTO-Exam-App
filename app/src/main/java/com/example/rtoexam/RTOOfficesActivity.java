package com.example.rtoexam;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class RTOOfficesActivity extends AppCompatActivity {
    Toolbar rotoolbar;
    TextView mh01, mh02, mh03, mh04, mh05, mh06, mh07, mh08, mh09, mh10, mh11, mh12, mh13, mh14, mh15, mh16, mh17, mh18, mh19, mh20, mh21, mh22, mh23, mh24, mh25, mh26, mh27, mh28, mh29, mh30, mh31, mh32, mh33, mh34, mh35, mh36;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rtooffices);
        rotoolbar = findViewById(R.id.rotoolbar);
        setSupportActionBar(rotoolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mh01 = findViewById(R.id.mh01);
        mh01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoDialog("MH01 - Mumbai (Central)", "<b>Address:</b> Old Bodyguard Lane, Tulsiwadi, Tardeo, Mumbai – 400034<br><b>Contact:</b> 1800 120 8040<br><b>Email:</b> rto.01-mh@gov.in");
            }
        });

        mh02 = findViewById(R.id.mh02);
        mh02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoDialog("MH02 - Mumbai (West)", "<b>Address:</b> CTS No 828, Ambivali Village, Andheri (W), Mumbai – 400053<br><b>Contact:</b> 022-26368502<br><b>Email:</b> rto.andheri-mh@gov.in");
            }
        });

        mh03 = findViewById(R.id.mh03);
        mh03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoDialog("MH03 - Mumbai (East)", "<b>Address:</b> Near T-Point, Mulund Check Naka, Eastern Express Highway, Mumbai – 400081<br><b>Contact:</b> 022-25639504<br><b>Email:</b> rto.mulund-mh@gov.in");
            }
        });

        mh04 = findViewById(R.id.mh04);
        mh04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoDialog("MH04 - Thane", "<b>Address:</b> RTO Compound, Wagle Estate, Thane (W) – 400604<br><b>Contact:</b> 022-25837227<br><b>Email:</b> rto.thane-mh@gov.in");
            }
        });

        mh05 = findViewById(R.id.mh05);
        mh05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoDialog("MH05 - Kalyan", "<b>Address:</b> Opp. Mohane Railway Station, Mohane Kalyan – 421102<br><b>Contact:</b> 0251-2612453<br><b>Email:</b> rto.kalyan-mh@gov.in");
            }
        });

        mh06 = findViewById(R.id.mh06);
        mh06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoDialog("MH06 - Raigad", "<b>Address:</b> Near Alibaug ST Stand, Alibaug, Raigad – 402201<br><b>Contact:</b> 02141-222233<br><b>Email:</b> rto.raigad-mh@gov.in");
            }
        });

        mh07 = findViewById(R.id.mh07);
        mh07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoDialog("MH07 - Sindhudurg", "<b>Address:</b> MIDC Industrial Area, Oras, Kudal, Sindhudurg – 416812<br><b>Contact:</b> 02362-228550<br><b>Email:</b> rto.sindhudurg-mh@gov.in");
            }
        });

        mh08 = findViewById(R.id.mh08);
        mh08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoDialog("MH08 - Ratnagiri", "<b>Address:</b> Near Bus Stand, Ratnagiri – 415612<br><b>Contact:</b> 02352-222366<br><b>Email:</b> rto.ratnagiri-mh@gov.in");
            }
        });

        mh09 = findViewById(R.id.mh09);
        mh09.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoDialog("MH09 - Kolhapur", "<b>Address:</b> Shahu Market Yard, Kolhapur – 416005<br><b>Contact:</b> 0231-2653334<br><b>Email:</b> rto.kolhapur-mh@gov.in");
            }
        });

        mh10 = findViewById(R.id.mh10);
        mh10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoDialog("MH10 - Sangli", "<b>Address:</b> Sangli – Miraj Road, Sangli – 416416<br><b>Contact:</b> 0233-2373713<br><b>Email:</b> rto.sangli-mh@gov.in");
            }
        });

        mh11 = findViewById(R.id.mh11);
        mh11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoDialog("MH11 - Satara", "<b>Address:</b> Satara – 415001<br><b>Contact:</b> 02162-234939<br><b>Email:</b> rto.satara-mh@gov.in");
            }
        });

        mh12 = findViewById(R.id.mh12);
        mh12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoDialog("MH12 - Pune", "<b>Address:</b> 39/A, Dr. Ambedkar Road, Near Sangam Bridge, Pune – 411001<br><b>Contact:</b> 020-26058080<br><b>Email:</b> rto.pune-mh@gov.in");
            }
        });

        mh13 = findViewById(R.id.mh13);
        mh13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoDialog("MH13 - Solapur", "<b>Address:</b> Opposite ST Stand, Solapur – 413001<br><b>Contact:</b> 0217-2315117<br><b>Email:</b> rto.solapur-mh@gov.in");
            }
        });

        mh14 = findViewById(R.id.mh14);
        mh14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoDialog("MH14 - Pimpri Chinchwad", "<b>Address:</b> Near Akurdi Railway Station, Akurdi, Pune – 411019<br><b>Contact:</b> 020-27651977<br><b>Email:</b> rto.pimprichinchwad-mh@gov.in");
            }
        });

        mh15 = findViewById(R.id.mh15);
        mh15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoDialog("MH15 - Nashik", "<b>Address:</b> Old Agra Road, Near ABB Circle, Nashik – 422002<br><b>Contact:</b> 0253-2460821<br><b>Email:</b> rto.nashik-mh@gov.in");
            }
        });

        mh16 = findViewById(R.id.mh16);
        mh16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoDialog("MH16 - Ahmednagar", "<b>Address:</b> Near Kotla Bajar, Ahmednagar – 414001<br><b>Contact:</b> 0241-2326008<br><b>Email:</b> rto.ahmednagar-mh@gov.in");
            }
        });

        mh17 = findViewById(R.id.mh17);
        mh17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoDialog("MH17 - Shrirampur", "<b>Address:</b> Shrirampur, Ahmednagar – 413709<br><b>Contact:</b> 02422-222888<br><b>Email:</b> rto.shrirampur-mh@gov.in");
            }
        });

        mh18 = findViewById(R.id.mh18);
        mh18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoDialog("MH18 - Dhule", "<b>Address:</b> Near Bus Stand, Dhule – 424001<br><b>Contact:</b> 02562-239888<br><b>Email:</b> rto.dhule-mh@gov.in");
            }
        });

        mh19 = findViewById(R.id.mh19);
        mh19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoDialog("MH19 - Jalgaon", "<b>Address:</b> Opp. Jalgaon Railway Station, Jalgaon – 425001<br><b>Contact:</b> 0257-2220388<br><b>Email:</b> rto.jalgaon-mh@gov.in");
            }
        });

        mh20 = findViewById(R.id.mh20);
        mh20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoDialog("MH20 - Aurangabad", "<b>Address:</b> Railway Station Road, Aurangabad – 431001<br><b>Contact:</b> 0240-2332210<br><b>Email:</b> rto.aurangabad-mh@gov.in");
            }
        });

        mh21 = findViewById(R.id.mh21);
        mh21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoDialog("MH21 - Jalna", "<b>Address:</b> Near Suryakant Hotel, Jalna – 431203<br><b>Contact:</b> 02482-222216<br><b>Email:</b> rto.jalna-mh@gov.in");
            }
        });

        mh22 = findViewById(R.id.mh22);
        mh22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoDialog("MH22 - Parbhani", "<b>Address:</b> Near Bus Stand, Parbhani – 431401<br><b>Contact:</b> 02452-222017<br><b>Email:</b> rto.parbhani-mh@gov.in");
            }
        });

        mh23 = findViewById(R.id.mh23);
        mh23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoDialog("MH23 - Beed", "<b>Address:</b> Near Bus Stand, Beed – 431122<br><b>Contact:</b> 02442-222017<br><b>Email:</b> rto.beed-mh@gov.in");
            }
        });

        mh24 = findViewById(R.id.mh24);
        mh24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoDialog("MH24 - Latur", "<b>Address:</b> Near Ausa Road, Latur – 413512<br><b>Contact:</b> 02382-222666<br><b>Email:</b> rto.latur-mh@gov.in");
            }
        });

        mh25 = findViewById(R.id.mh25);
        mh25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoDialog("MH25 - Osmanabad", "<b>Address:</b> Near Bus Stand, Osmanabad – 413501<br><b>Contact:</b> 02472-222110<br><b>Email:</b> rto.osmanabad-mh@gov.in");
            }
        });

        mh26 = findViewById(R.id.mh26);
        mh26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoDialog("MH26 - Nanded", "<b>Address:</b> Near ST Stand, Nanded – 431601<br><b>Contact:</b> 02462-222333<br><b>Email:</b> rto.nanded-mh@gov.in");
            }
        });

        mh27 = findViewById(R.id.mh27);
        mh27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoDialog("MH27 - Amravati", "<b>Address:</b> RTO Office, Amravati – 444604<br><b>Contact:</b> 0721-222555<br><b>Email:</b> rto.amravati-mh@gov.in");
            }
        });

        mh28 = findViewById(R.id.mh28);
        mh28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoDialog("MH28 - Buldhana", "<b>Address:</b> Near ST Stand, Buldhana – 443001<br><b>Contact:</b> 07262-222008<br><b>Email:</b> rto.buldhana-mh@gov.in");
            }
        });

        mh29 = findViewById(R.id.mh29);
        mh29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoDialog("MH29 - Yavatmal", "<b>Address:</b> Yavatmal – 445001<br><b>Contact:</b> 07232-222222<br><b>Email:</b> rto.yavatmal-mh@gov.in");
            }
        });

        mh30 = findViewById(R.id.mh30);
        mh30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoDialog("MH30 - Akola", "<b>Address:</b> Near Bus Stand, Akola – 444001<br><b>Contact:</b> 0724-222999<br><b>Email:</b> rto.akola-mh@gov.in");
            }
        });

        mh31 = findViewById(R.id.mh31);
        mh31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoDialog("MH31 - Nagpur", "<b>Address:</b> Near Old VCA Stadium, Civil Lines, Nagpur – 440001<br><b>Contact:</b> 0712-222333<br><b>Email:</b> rto.nagpur-mh@gov.in");
            }
        });

        mh32 = findViewById(R.id.mh32);
        mh32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoDialog("MH32 - Wardha", "<b>Address:</b> Near Bus Stand, Wardha – 442001<br><b>Contact:</b> 07152-222210<br><b>Email:</b> rto.wardha-mh@gov.in");
            }
        });

        mh33 = findViewById(R.id.mh33);
        mh33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoDialog("MH33 - Gadchiroli", "<b>Address:</b> Near ST Stand, Gadchiroli – 442605<br><b>Contact:</b> 07132-222777<br><b>Email:</b> rto.gadchiroli-mh@gov.in");
            }
        });

        mh34 = findViewById(R.id.mh34);
        mh34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoDialog("MH34 - Chandrapur", "<b>Address:</b> Near ST Stand, Chandrapur – 442401<br><b>Contact:</b> 07172-251002<br><b>Email:</b> rto.chandrapur-mh@gov.in");
            }
        });

        mh35 = findViewById(R.id.mh35);
        mh35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoDialog("MH35 - Gondia", "<b>Address:</b> Near Railway Station, Gondia – 441614<br><b>Contact:</b> 07182-236477<br><b>Email: rto.gondia-mh@gov.in");
            }
        });

        mh36 = findViewById(R.id.mh36);
        mh36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoDialog("MH36 - Bhandara", "<b>Address:</b> Near ST Stand, Bhandara – 441904<br><b>Contact:</b> 07184-265857<br><b>Email: rto.bhandara-mh@gov.in");
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