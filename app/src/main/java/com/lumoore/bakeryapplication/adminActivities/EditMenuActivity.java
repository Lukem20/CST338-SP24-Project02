package com.lumoore.bakeryapplication.adminActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.lumoore.bakeryapplication.R;
import com.lumoore.bakeryapplication.databinding.ActivityEditMenuBinding;

public class EditMenuActivity extends AppCompatActivity {

    private ActivityEditMenuBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEditMenuBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_edit_menu);

        binding.FoodMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        binding.DrinksMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        binding.goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = AdminActivity.AdminIntentFactory(getApplicationContext());
                startActivity(intent);
            }
        });
    }

    public static Intent EditMenuIntentFactory(Context context) {
        return new Intent(context, EditMenuActivity.class);
    }

}