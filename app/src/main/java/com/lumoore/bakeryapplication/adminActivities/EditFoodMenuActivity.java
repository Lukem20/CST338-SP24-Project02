package com.lumoore.bakeryapplication.adminActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.lumoore.bakeryapplication.R;
import com.lumoore.bakeryapplication.databinding.ActivityEditFoodMenuBinding;

public class EditFoodMenuActivity extends AppCompatActivity {
    private ActivityEditFoodMenuBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEditFoodMenuBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_edit_food_menu);

        binding.goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = EditMenuActivity.EditMenuIntentFactory(getApplicationContext());
                startActivity(intent);
            }
        });

    }
}