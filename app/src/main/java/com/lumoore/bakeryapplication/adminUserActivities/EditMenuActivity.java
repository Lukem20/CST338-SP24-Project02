package com.lumoore.bakeryapplication.adminUserActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.lumoore.bakeryapplication.R;
import com.lumoore.bakeryapplication.databinding.ActivityEditMenuBinding;

public class EditMenuActivity extends AppCompatActivity {

    private ActivityEditMenuBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEditMenuBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_edit_menu);


    }

    public static Intent EditMenuIntentFactory(Context context) {
        return new Intent(context, EditMenuActivity.class);
    }

}