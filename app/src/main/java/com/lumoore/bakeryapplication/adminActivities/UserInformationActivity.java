package com.lumoore.bakeryapplication.adminActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.lumoore.bakeryapplication.databinding.ActivityUserInformationBinding;

public class UserInformationActivity extends AppCompatActivity {

    private ActivityUserInformationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserInformationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = AdminActivity.AdminIntentFactory(getApplicationContext());
                startActivity(intent);
            }
        });

    }

    public static Intent UserInformationIntentFactory(Context context) {
        return new Intent(context, UserInformationActivity.class);
    }

}