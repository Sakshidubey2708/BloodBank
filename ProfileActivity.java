package com.example.awizom.bloodbank.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.awizom.bloodbank.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private Button saveButton;
    private EditText userName,userEmail,userAddress,userDesignation;
    FirebaseFirestore db;
    DatabaseReference mDB;
    DatabaseReference mListItemRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_layout);
        intview();
    }

    private void intview() {
        userName = findViewById(R.id.Name);
        userEmail = findViewById(R.id.email);
        userAddress = findViewById(R.id.Address);
        userDesignation = findViewById(R.id.designation);
        saveButton = findViewById(R.id.saveBtn);

        saveButton.setOnClickListener(this);
        db = FirebaseFirestore.getInstance();
        mDB= FirebaseDatabase.getInstance().getReference();
        mListItemRef = mDB.child("Profile");
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.saveBtn:
            break;
        }
    }
}
