package com.lumoore.bakeryapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.lumoore.bakeryapplication.databinding.ActivityOrderHistoryBinding;

public class OrderHistoryActivity extends AppCompatActivity {

    private ActivityOrderHistoryBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderHistoryBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_order_history);


    }

    public static Intent OrderHistoryIntentFactory(Context context) {
        return new Intent(context, OrderHistoryActivity.class);
    }
}