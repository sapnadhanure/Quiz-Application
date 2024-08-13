package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.quiz.databinding.ActivitySpinnerBinding;

public class SpinnerActivity extends AppCompatActivity {
    ActivitySpinnerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivitySpinnerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}