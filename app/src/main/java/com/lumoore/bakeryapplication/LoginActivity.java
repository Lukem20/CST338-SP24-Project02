package com.lumoore.bakeryapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.PrimaryKey;

import com.lumoore.bakeryapplication.adminActivities.AdminActivity;
import com.lumoore.bakeryapplication.database.BakeryOrderRepository;
import com.lumoore.bakeryapplication.databinding.ActivityLoginBinding;
import com.lumoore.bakeryapplication.userActivities.UserActivity;

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

    public static Intent LoginIntentFactory(Context context) {
        return new Intent(context, LoginActivity.class);
    }

    public void loginUser(View view) {
        if (isValidFieldValue()) {
            // TODO - Check if the value in 'username' exists in the database.
            //  If it is already in database, check if the password matches that entry.
             if (true) { // IF USER IS ADMIN
                    Intent intent = AdminActivity.AdminIntentFactory(getApplicationContext());
                    startActivity(intent);
             } else {
                    Intent intent = UserActivity.UserActivityIntentFactory(getApplicationContext());
                    startActivity(intent);
            }
        }
    }

    public void createAccount(View view) {
        Intent intent = CreateAccount.CreateAccountIntentFactory(getApplicationContext());
        startActivity(intent);
    }

    /**
     *  Checks if the values that were entered and stored in Username & Password
     *  text fields are valid values
     * @return true if valid, false if not
     */
    private boolean isValidFieldValue() {
        return !username.isEmpty() && !password.isEmpty();
    }

    /**
     * Stores the values entered in the Username & Password text field
     */
    private void getEnteredLoginInformation() {
        username = binding.userEdit.getText().toString();
        password = binding.passEdit.getText().toString();
    }
}