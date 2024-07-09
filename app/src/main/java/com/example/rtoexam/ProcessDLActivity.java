package com.example.rtoexam;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ProcessDLActivity extends AppCompatActivity {
    Toolbar pdltoolbar;
    TextView learning_licence, permanent_licence, renewal_dl, duplicate_licence, validity_dl, international_dp, unfitness_dv, services_existing_licence, reg_vipno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process_dlactivity);
        pdltoolbar = findViewById(R.id.pdltoolbar);
        setSupportActionBar(pdltoolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        learning_licence = findViewById(R.id.learning_licence);
        learning_licence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoDialog("Learning Licence", "<b>Who can apply</b><br>" +
                        "Any person after completion of 18 years is eligible to apply for a Driving license (Learner/Permanent).<br>" +
                        "Any person after attaining the age of 16 yrs is eligible to apply for a license for a motorcycle without gear, engine capacity not exceeding 50cc with written consent of parent/guardian.<br>" +
                        "The eligible age to apply for a license to drive a transport vehicle in any public place is 20 yrs. No person shall be granted a learner’s license to drive a transport vehicle unless he has held a driving license to drive a light motor vehicle for at least one year.<br><br>" +
                        "<b>Documents Required</b><br>" +
                        "1. Application-cum-declaration as to physical fitness (Form No. 1)<br>" +
                        "2. Application for grant of Learner's License (Form No. 2)<br>" +
                        "3. Three copies of the applicant's recent passport size photograph<br>" +
                        "4. Proof of residence<br>" +
                        "5. Proof of Age<br>" +
                        "6. Proof of citizenship<br>" +
                        "7. Fees");
            }
        });

        permanent_licence = findViewById(R.id.permanent_licence);
        permanent_licence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoDialog("Permanent Licence","<b>Who can Apply?</b><br>" +
                        "The learner license holder should appear for the test of competence for obtaining the permanent licence after 30 days and within 6 months from issue of Learner License. Learner's License is valid for 6 months and cannot be renewed.<br><br>" +
                        "<b>Documents Required</b><br>" +
                        "1. Application for License to drive a vehicle - <br>" +
                        "2. Form No. 4<br>" +
                        "3. Learner’s License<br>" +
                        "4. Three copies of recent photographs<br>" +
                        "5. Proof of age and address<br>" +
                        "6. Driving school’s certificate in Form 5 for all transport vehicles<br>" +
                        "7. Fees<br>" +
                        "8. All valid documents of the vehicle on which the test is to be conducted.");
            }
        });

        renewal_dl = findViewById(R.id.renewal_dl);
        renewal_dl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoDialog("Renewal of DL","<b>Information</b><br>" +
                        "An applicant may apply for renewal of his driving license 30 days before its expiry to the Licensing Authority.<br>" +
                        " Apply Online for Renewal.<br><br>" +
                        "<b>Documents Required</b><br>" +
                        "1. Form 9<br>" +
                        "2. Driving licence<br>" +
                        "3. Application –cum-declaration as to physical fitness in Form 1<br>" +
                        "4. Medical Certificate in Form 1-A<br>" +
                        "5. Three copies of applicants recent photographs<br>" +
                        "6. The driving licence is renewed with effect from the date of its expiry when the application is made before its expiry or within thirty days grace period. The driving licence is renewed with effect from the date of renewal when the application is made after the grace period.");
            }
        });

        duplicate_licence = findViewById(R.id.duplicate_licence);
        duplicate_licence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoDialog("Duplicate Licence","<b>Who can Apply?</b><br>" +
                        "The Permanent License holder who's license is torn / defaced or lost should apply for Duplicate License.<br>" +
                        "Apply Online for Renewal.<br><br>" +
                        "<b>Documents Required</b><br>" +
                        "1. Form LLD<br>" +
                        "2. Driving licence<br>" +
                        "3. Old license if torn / defaced or police report if lost<br>" +
                        "4. Two copies of recent passport size photographs<br>" +
                        "5. Medical Certificate in Fees");
            }
        });

        validity_dl = findViewById(R.id.validity_dl);
        validity_dl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoDialog("Validity of DL","<b>Validity of Various Licenses</b><br>" +
                        "1. Learner's Licence: 6 Months<br>" +
                        "2. Transport Licence: 3 Years<br>" +
                        "3. License to drive vehicle carrying hazardous chemicals: 1 Year<br>" +
                        "4. After the age of 50 yrs: 5 Years<br>" +
                        "5. All other class of licence (Till the age of 50 years): 20 years or up to the age of 50 yrs whichever is earlier");
            }
        });

        international_dp = findViewById(R.id.international_dp);
        international_dp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoDialog("International Driving Permit","<b>Introduction</b><br>" +
                        "Congratulations for getting Visa to visit foreign country for study purpose, employment or even for tourist purpose. If you are interested to show your skills on foreign land you are required to obtain International driving permit. IDP is valid only in the country we have signed under UN conversion.<br>" +
                        "International driving permit is delivered to the applicant in person.<br><br>" +
                        "<b>Basic Requirement</b><br>" +
                        "1. Form 4A<br>" +
                        "2. Valid driving License along with certified copies<br>" +
                        "3. Passport along with certified copies<br>" +
                        "4. Visa along with certified copies<br>" +
                        "5. Medical Certificate in Form IA<br>" +
                        "6. Fees<br>" +
                        "Applicant should submit the application in whose jurisdiction he stays. It is advisable to applicant to get the necessary changes about the address on motor driving License before submitting the application for IDP.<br>" +
                        "The applicant is required to appear before licensing authority for grant of IDP.<br>" +
                        "Form of IDP (to be collected from Head Clerk MDL)");
            }
        });

        unfitness_dv = findViewById(R.id.unfitness_dv);
        unfitness_dv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoDialog("Unfitness to drive a vehicle","<b>Criteria</b><br>" +
                        "The motor driving licence can not be issued to a person/applicant who is suffering from:<br>" +
                        "1. Defects of vision which cannot be corrected by spectacles.<br>" +
                        "2. Colour or night blindness.<br>" +
                        "3. Hearing defects which cannot be corrected with the help of hearing aid.<br>" +
                        "4. Epilepsy.<br>" +
                        "5. Sudden attacks of loss of consciousness or giddiness.<br>" +
                        "6. Who has lost either hand or foot.<br>" +
                        "7. Suffer from any other disease or disability likely to cause danger to other road users. While driving is unfit to hold a driving licence.");
            }
        });

        services_existing_licence = findViewById(R.id.services_existing_licence);
        services_existing_licence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoDialog("Services on Existing Licence","<b>Change of Address</b><br>" +
                        "Change of address should be intimated within 30 days.<br><br>" +
                        "<b>Application Form</b><br>" +
                        "Plain paper application mentioning old as well as present address.<br><br>" +
                        "<b>Documents to be Submitted</b><br>" +
                        "1. Original driving license<br>" +
                        "2. Address proof<br>" +
                        "3. No objection certificate wherever applicable along with Fees.<br><br>" +
                        "<b>Where to Make Application</b><br>" +
                        "Application has to be made to the Licensing Authority which issued driving license. If present address of the applicant is in jurisdiction of other Licensing Authority, then NO Objection Certificate (NOC) has to be taken from the Licensing Authority which issued the Driving License and submit this NOC to the Licensing Authority where applicant is presently residing along with original Driving License and address proof.");
            }
        });

        reg_vipno = findViewById(R.id.reg_vipno);
        reg_vipno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoDialog("Registration for VIP Numbers","<b>Conditions</b><br>" +
                        "Under MMVR 1989 R54 the applications for new VIP Numbers will be accepted from 5th February 2002 onwards during office hours.<br>" +
                        "On grant of the VIP Numbers the applicant shall pay the prescribed fees on the same day or on the following day during cash hours from 10:00 A.M. to 2:30 P.M.<br>" +
                        "If a particular registration number is sought by more than one applicant, the registration mark shall be allotted by way of auction.<br>" +
                        "Reservation for such numbers will be in force and will be valid for 30 days only.<br>" +
                        "All applications on plain paper will be accepted at R.T.O. main office by the concerned clerk of Non-Transport Series.");
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