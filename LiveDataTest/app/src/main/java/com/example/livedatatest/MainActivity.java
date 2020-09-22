package com.example.livedatatest;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    private ViewModelWithLiveData viewModelWithLiveData;
    private TextView mTextView;
    private ImageButton mImageButtonLike;
    private ImageButton mImageButtonDisLike;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.textView);
        mImageButtonLike = findViewById(R.id.imageButton);
        mImageButtonDisLike = findViewById(R.id.imageButton2);

        viewModelWithLiveData = new ViewModelProvider(this).get(ViewModelWithLiveData.class);
        viewModelWithLiveData.getLiveData().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                mTextView.setText(String.valueOf(integer));
            }
        });

        mImageButtonLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModelWithLiveData.addLikeNumber(1);
            }
        });
        mImageButtonDisLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModelWithLiveData.addLikeNumber(-1);
            }
        });
    }
}