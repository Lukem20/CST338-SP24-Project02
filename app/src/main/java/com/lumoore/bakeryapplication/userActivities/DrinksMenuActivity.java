package com.lumoore.bakeryapplication.userActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.lumoore.bakeryapplication.R;
import com.lumoore.bakeryapplication.databinding.ActivityDrinksMenuBinding;

public class DrinksMenuActivity extends AppCompatActivity {
    private ActivityDrinksMenuBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDrinksMenuBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_drinks_menu);


    }

    public static Intent DrinksMenuIntentFactory(Context context) {
        return new Intent(context, DrinksMenuActivity.class);
    }
}