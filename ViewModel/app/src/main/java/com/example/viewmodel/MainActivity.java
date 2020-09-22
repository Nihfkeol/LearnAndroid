package com.example.viewmodel;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MyViewModel myViewModel;
    private TextView mTextView;
    private Button mButton;
    private Button mButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.textView);
        mButton = findViewById(R.id.button);
        mButton2 = findViewById(R.id.button2);
        myViewModel = new ViewModelProvider(this).get(MyViewModel.class);
        mTextView.setText(String.valueOf(myViewModel.count));
        mButton.setOnClickListener(this);
        mButton2.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button:
                    myViewModel.count++;
                break;
            case R.id.button2:
                    myViewModel.count += 2;
                break;
        }
        mTextView.setText(String.valueOf(myViewModel.count));
    }
}