package com.example.orientation;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button mButton;
    private TextView mTextView;

    private String TAG = "myLog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.textView);
        mButton = findViewById(R.id.button);
        mButton.setOnClickListener((view) -> {
            mTextView.setText(R.string.button);
        });
        if (savedInstanceState != null){
            String tvString = savedInstanceState.getString("TVString");
            mTextView.setText(tvString);
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("TVString", mTextView.getText().toString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");
    }
}