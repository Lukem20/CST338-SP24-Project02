package com.lumoore.bakeryapplication.adminActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.lumoore.bakeryapplication.R;
import com.lumoore.bakeryapplication.databinding.ActivityEditDrinksMenuBinding;

public class EditDrinksMenuActivity extends AppCompatActivity {
    private ActivityEditDrinksMenuBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEditDrinksMenuBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_edit_drinks_menu);

        binding.goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = EditMenuActivity.EditMenuIntentFactory(getApplicationContext());
                startActivity(intent);
            }
        });

    }
}