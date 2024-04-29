package com.lumoore.bakeryapplication;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.lumoore.bakeryapplication.databinding.ActivityAdminPageBinding;

public class AdminActivity extends AppCompatActivity {

    private ActivityAdminPageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAdminPageBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_admin_page);

        binding.OrderHistoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        binding.UserInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        binding.EditMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void edit_menu(View view) {

    }

    public void display_user_info(View view) {

    }

    public void display_order_history(View view) {

    }
}