package com.lumoore.bakeryapplication.userActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.lumoore.bakeryapplication.databinding.ActivityUserCartBinding;

public class UserCartActivity extends AppCompatActivity {
    private ActivityUserCartBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = UserActivity.UserActivityIntentFactory(getApplicationContext());
                startActivity(intent);
            }
        });
    }

    public static Intent UserCartIntentFactory(Context context) {
        return new Intent(context, UserCartActivity.class);
    }
}