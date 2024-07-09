package com.example.rtoexam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.widget.TextView;

public class PrivacyPolicyActivity extends AppCompatActivity {
    Toolbar pptoolbar;
    TextView privacy_policy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_policy);
        pptoolbar = findViewById(R.id.pptoolbar);
        setSupportActionBar(pptoolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        privacy_policy=findViewById(R.id.privacy_policy);
        String privacyPolicy = "<b>Last updated: Jul 23, 2021</b><br><br>" +
                "Techsoft Private Limited built the RTO Exam app as an Ad Supported app. This SERVICE is provided by Techsoft Private Limited at no cost and is intended for use as is.<br><br>" +
                "This page is used to inform app visitors regarding our policies with the collection, use, and disclosure of Personal Information if anyone decided to use our Service.<br><br>" +
                "If you choose to use our Service, then you agree to the collection and use of information in relation to this policy. The Personal Information that we collect is used for providing and improving the Service. We will not use or share your information with anyone except as described in this Privacy Policy.<br><br>" +
                "The terms used in this Privacy Policy have the same meanings as in our Terms and Conditions, which is accessible at RTO Exam unless otherwise defined in this Privacy Policy.<br><br>" +
                "<b>Information Collection and Use</b><br><br>" +
                "For a better experience, while using our Service, we may require you to provide us with certain personally identifiable information, including but not limited to Email, First Name, Last Name, State, City, Language and Phone Number. The information that we request is will be retained by us and used as described in this privacy policy.<br><br>" +
                "The app does use third party services that may collect information used to identify you.<br><br>" +
                "Link to privacy policy of third party service providers used by the app<br><br>" +
                "AdMob<br>" +
                "Firebase Analytics<br><br>" +
                "<b>Log Data</b><br><br>" +
                "We want to inform you that whenever you use our Service, in a case of an error in the app we collect data and information (through third party products) on your phone called Log Data. This Log Data may include information such as your device Internet Protocol (\"IP\") address, device name, operating system version, the configuration of the app when utilizing our Service, the time and date of your use of the Service, and other statistics.<br><br>" +
                "<b>Cookies</b><br><br>" +
                "Cookies are files with small amount of data that is commonly used an anonymous unique identifier. These are sent to your browser from the website that you visit and are stored on your device internal memory.<br><br>" +
                "This Service does not use these “cookies” explicitly. However, the app may use third party code and libraries that use “cookies” to collection information and to improve their services. You have the option to either accept or refuse these cookies and know when a cookie is being sent to your device. If you choose to refuse our cookies, you may not be able to use some portions of this Service.<br><br>" +
                "<b>Service Providers</b><br><br>" +
                "We may employ third-party companies and individuals due to the following reasons:<br><br>" +
                "• To facilitate our Service;<br>" +
                "• To provide the Service on our behalf;<br>" +
                "• To perform Service-related services; or<br>" +
                "• To assist us in analyzing how our Service is used.<br><br>" +
                "We want to inform users of this Service that these third parties have access to your Personal Information. The reason is to perform the tasks assigned to them on our behalf. However, they are obligated not to disclose or use the information for any other purpose.<br><br>" +
                "<b>Security</b><br><br>" +
                "We value your trust in providing us your Personal Information, thus we are striving to use commercially acceptable means of protecting it. But remember that no method of transmission over the internet, or method of electronic storage is 100% secure and reliable, and we cannot guarantee its absolute security.<br><br>" +
                "<b>Links to Other Sites</b><br><br>" +
                "This Service may contain links to other sites. If you click on a third-party link, you will be directed to that site. Note that these external sites are not operated by us. Therefore, we strongly advise you to review the Privacy Policy of these websites. We have no control over and assume no responsibility for the content, privacy policies, or practices of any third-party sites or services.<br><br>" +
                "<b>Changes to This Privacy Policy</b><br><br>" +
                "We may update our Privacy Policy from time to time. Thus, you are advised to review this page periodically for any changes. We will notify you of any changes by posting the new Privacy Policy on this page. These changes are effective immediately after they are posted on this page.<br><br>" +
                "<b>Disclaimer</b><br><br>" +
                "This test is only for public awareness. This app is not affiliated with any government body or any RTO authority of India. Though all efforts have been made to ensure the accuracy of the of the content, the same should be construed as a statement of law or used for any legal purposes. This application accepts no responsibility in relation to the accuracy, completeness, usefulness or otherwise. Users are advised to verify/check any information with the Transport Department.<br><br>" +
                "<b>Contact Us</b><br><br>" +
                "If you have any questions or suggestions about our Privacy Policy, do not hesitate to contact us at contact@rtoexam.com.";

        privacy_policy.setText(Html.fromHtml(privacyPolicy));
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