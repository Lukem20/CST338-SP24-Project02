package com.lumoore.bakeryapplication.userActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.lumoore.bakeryapplication.R;
import com.lumoore.bakeryapplication.databinding.ActivityUserCartBinding;

public class UserCartActivity extends AppCompatActivity {
    private ActivityUserCartBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserCartBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_user_cart);


    }

    public static Intent UserCartIntentFactory(Context context) {
        return new Intent(context, UserCartActivity.class);
    }
}