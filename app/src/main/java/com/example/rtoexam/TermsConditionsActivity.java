package com.example.rtoexam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.widget.TextView;

public class TermsConditionsActivity extends AppCompatActivity {
    Toolbar tctoolbar;
    TextView terms_conditions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_conditions);
        tctoolbar = findViewById(R.id.tctoolbar);
        setSupportActionBar(tctoolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        terms_conditions=findViewById(R.id.terms_conditions);
        String termsConditions = "<b>Last updated: May 11, 2021</b><br><br>" +
                "By installing the RTO Exam App, you agree to be bound by this Agreement and understand that there is no tolerance for objectionable content. If you do not agree with the terms and conditions of this Agreement, you are not entitled to use the RTO Exam App.<br><br>" +
                "In order to ensure RTO Exam provides the best experience possible for everyone, we strongly enforce a no tolerance policy for objectionable content. If you see inappropriate content, please contact us at contact@rtoexam.com.<br><br>" +
                "<b>Privacy Policy</b><br><br>" +
                "RTO Exam may collect and use information about your usage of the RTO Exam App, including certain types of information from and about your device. RTO Exam may use this information, as long as it is in a form that does not personally identify you, to measure the use and performance of the RTO Exam App. Visit Our Privacy Policy for more information.<br><br>" +
                "<b>Limited License</b><br><br>" +
                "RTO Exam grants you a limited, non-exclusive, non-transferable, revocable license to use the RTO Exam App for your personal, non-commercial purposes.<br><br>" +
                "<b>Age Restrictions</b><br><br>" +
                "By using the RTO Exam App, you represent and warrant that (a) you are 13 years of age or older and you agree to be bound by this Agreement; (b) if you are under 13 years of age, you have obtained verifiable consent from a parent or legal guardian; and (c) your use of the RTO Exam App does not violate any applicable law or regulation. Your access to the RTO Exam App may be terminated without warning if RTO Exam believes, in its sole discretion, that you are under the age of 13 years and have not obtained verifiable consent from a parent or legal guardian. If you are a parent or legal guardian and you provide your consent to your child's use of the RTO Exam App, you agree to be bound by this Agreement in respect to your child's use of the RTO Exam App.<br><br>" +
                "<b>Objectionable Content Policy</b><br><br>" +
                "Content may not be submitted to RTO Exam, who will moderate all content and ultimately decide whether or not to post a submission to the extent such content includes, is in conjunction with, or alongside any, Objectionable Content. Objectionable Content includes, but is not limited to: (i) sexually explicit materials; (ii) obscene, defamatory, libelous, slanderous, violent and/or unlawful content or profanity; (iii) content that infringes upon the rights of any third party, including copyright, trademark, privacy, publicity or other personal or proprietary right, or that is deceptive or fraudulent; (iv) content that promotes the use or sale of illegal or regulated substances, tobacco products, ammunition and/or firearms; and (v) gambling, including without limitation, any online casino, sports books, bingo or poker.<br><br>" +
                "<b>Warranty</b><br><br>" +
                "RTO Exam disclaims all warranties about the RTO Exam App to the fullest extent permitted by law. To the extent any warranty exists under law that cannot be disclaimed, RTO Exam, shall be solely responsible for such warranty.<br><br>" +
                "<b>Maintenance and Support</b><br><br>" +
                "RTO Exam does provide minimal maintenance or support for it but not to the extent that any maintenance or support is required by applicable law, RTO Exam, shall be obligated to furnish any such maintenance or support.<br><br>" +
                "<b>Product Claims</b><br><br>" +
                "RTO Exam, is responsible for addressing any claims by you relating to the RTO Exam App or use of it, including, but not limited to: (i) any product liability claim; (ii) any claim that the RTO Exam App fails to conform to any applicable legal or regulatory requirement; and (iii) any claim arising under consumer protection or similar legislation. Nothing in this Agreement shall be deemed an admission that you may have such claims.<br><br>" +
                "<b>Third Party Intellectual Property Claims</b><br><br>" +
                "RTO Exam shall not be obligated to indemnify or defend you with respect to any third party claim arising out or relating to the RTO Exam App. To the extent RTO Exam is required to provide indemnification by applicable law, RTO Exam, shall be solely responsible for the investigation, defense, settlement and discharge of any claim that the RTO Exam App or your use of it infringes any third party intellectual property right.<br><br>" +
                "<b>Changes to This Terms and Conditions</b><br><br>" +
                "We may update our Terms and Conditions from time to time. Thus, you are advised to review this page periodically for any changes. We will notify you of any changes by posting the new Terms and Conditions on this page. These changes are effective immediately after they are posted on this page.<br><br>" +
                "<b>Contact Us</b><br><br>" +
                "If you have any questions or suggestions about our Terms and Conditions, do not hesitate to contact us at contact@rtoexam.com";
        terms_conditions.setText(Html.fromHtml(termsConditions));
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