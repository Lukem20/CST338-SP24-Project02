package com.lumoore.bakeryapplication.userActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.lumoore.bakeryapplication.databinding.ActivityFoodMenuChoiceBinding;

public class FoodMenuActivity extends AppCompatActivity {
    private ActivityFoodMenuChoiceBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFoodMenuChoiceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = UserActivity.UserActivityIntentFactory(getApplicationContext(), 0);
                startActivity(intent);
            }
        });
    }

    public static Intent FoodMenuIntentFactory(Context context) {
        return new Intent(context, FoodMenuActivity.class);
    }
}