package com.lumoore.bakeryapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.lumoore.bakeryapplication.databinding.ActivityUserInformationBinding;

public class UserInformationActivity extends AppCompatActivity {

    private ActivityUserInformationBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserInformationBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_user_information);


    }

    public static Intent UserInformationIntentFactory(Context context) {
        return new Intent(context, UserInformationActivity.class);
    }

}