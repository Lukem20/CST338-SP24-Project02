package com.lumoore.bakeryapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.PrimaryKey;

import com.lumoore.bakeryapplication.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    @PrimaryKey
    int ID;
    String usrnme = "";
    String psswrd = "";

    ActivityLoginBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "Login button", Toast.LENGTH_SHORT).show();
                getEnteredLoginInformation();
            }

            @Override
            public boolean onClick(View v) {
                Intent intent = new User_Menu(getApplicationContext());
                startActivity(intent);
                return false;
            }
        });
    }

    private void getEnteredLoginInformation() {
        usrnme = binding.userEdit.getText().toString();
        psswrd = binding.passEdit.getText().toString();
    }
}

