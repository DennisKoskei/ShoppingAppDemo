package com.mobileshoppingappdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Button backButton = findViewById(R.id.backButton);
        TextView linkTextView = findViewById(R.id.activity_main_link);

        backButton.setOnClickListener(view -> finish());

        linkTextView.setMovementMethod(LinkMovementMethod.getInstance());

    }
}