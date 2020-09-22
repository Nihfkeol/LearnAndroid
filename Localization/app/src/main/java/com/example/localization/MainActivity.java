package com.example.localization;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView2;
    private TextView mTextView;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView2 = findViewById(R.id.textView2);
        mTextView = findViewById(R.id.textView);
        mButton = findViewById(R.id.button);

        mButton.setOnClickListener((view) -> {
            mTextView.setText(R.string.Message);
        });
    }
}