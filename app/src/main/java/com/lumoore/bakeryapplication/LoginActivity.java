package com.lumoore.bakeryapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.PrimaryKey;

import com.lumoore.bakeryapplication.database.BakeryOrderRepository;
import com.lumoore.bakeryapplication.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    @PrimaryKey
    String username = "";
    String password = "";
    private ActivityLoginBinding binding;
    private BakeryOrderRepository repository;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // =-=-= Get access to DB =-=-=
        repository = BakeryOrderRepository.getRepository(getApplication());

        binding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "Login button", Toast.LENGTH_SHORT).show();
                getEnteredLoginInformation();
                loginUser(v);
            }
        });

        binding.createAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "Create Account button", Toast.LENGTH_SHORT).show();
                getEnteredLoginInformation();
                createAccount(v);
            }
        });
    }

    public void loginUser(View view) {
        if (isValidFieldValue()) {
            // Check if the value in 'username' exists in the database
            // If it is already in database, check if the password matches that entry.
        }
    }

    public void createAccount(View view) {
        if (isValidFieldValue()) {
            // Check if the value in 'username' exists in the database
            // If it is already in database, try again.
            // Else add new entry to database with 'username' & 'password'
        }
    }

    private boolean isValidFieldValue() {
        if (!username.isEmpty() && !password.isEmpty()) {
            return true;
        }
        return false;
    }

    private void getEnteredLoginInformation() {
        username = binding.userEdit.getText().toString();
        password = binding.passEdit.getText().toString();
    }
}

