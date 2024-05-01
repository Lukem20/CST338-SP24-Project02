package com.lumoore.bakeryapplication.userActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.lumoore.bakeryapplication.databinding.ActivityDrinksMenuBinding;

public class DrinksMenuActivity extends AppCompatActivity {
    private ActivityDrinksMenuBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDrinksMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = UserActivity.UserActivityIntentFactory(getApplicationContext(), 0);
                startActivity(intent);
            }
        });
    }

    public static Intent DrinksMenuIntentFactory(Context context) {
        return new Intent(context, DrinksMenuActivity.class);
    }
}