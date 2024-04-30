package com.lumoore.bakeryapplication.userActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.lumoore.bakeryapplication.R;
import com.lumoore.bakeryapplication.databinding.ActivityFoodMenuBinding;

public class FoodMenuActivity extends AppCompatActivity {
    private ActivityFoodMenuBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFoodMenuBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_food_menu);


    }

    public static Intent FoodMenuIntentFactory(Context context) {
        return new Intent(context, FoodMenuActivity.class);
    }
}