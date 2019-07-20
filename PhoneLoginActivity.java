package com.example.awizom.bloodbank.activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.awizom.bloodbank.R;
import com.google.firebase.auth.FirebaseAuth;

public class PhoneLoginActivity extends AppCompatActivity {


    private static final String GOOGLE_TOS_URL =
            "https://www.google.com/policies/terms/";
    private static final int RC_SIGN_IN = 100;

    EditText mobileNumberId;
    Button submit;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phone_login_layout);
        intview();
    }

    private void intview() {
        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Login");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityOptions options = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.slide_in, R.anim.slide_out);
                onBackPressed();
            }
        });
        toolbar.setSubtitleTextAppearance(getApplicationContext(), R.style.styleA);
        toolbar.setTitleTextAppearance(getApplicationContext(), R.style.styleA);
        toolbar.setTitleTextColor(Color.WHITE);

        mobileNumberId = findViewById(R.id.mobileNumber);
        submit = findViewById(R.id.save);
        auth = FirebaseAuth.getInstance();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUserAccount();
            }
        });

    }

    private void loginUserAccount() {

        String mobile = mobileNumberId.getText().toString().trim();

        if(mobile.isEmpty() || mobile.length() < 10){
            mobileNumberId.setError("Enter a valid mobile");
            mobileNumberId.requestFocus();
            return;
        }

        Intent intent = new Intent(PhoneLoginActivity.this, VerificationPhoneCodeActivity.class);
        intent.putExtra("mobile", mobile);
        startActivity(intent);

    }
}
