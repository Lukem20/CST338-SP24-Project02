package com.lumoore.bakeryapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.PrimaryKey;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.lumoore.bakeryapplication.databinding.ActivityCreateAccountBinding;
import com.lumoore.bakeryapplication.userActivities.UserActivity;

public class CreateAccount extends AppCompatActivity {
    @PrimaryKey
    String username = "";
    String password = "";
    private ActivityCreateAccountBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCreateAccountBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_create_account);

        binding.createAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getEnteredLoginInformation()) {
                    Intent intent = UserActivity.UserActivityIntentFactory(getApplicationContext());
                    startActivity(intent);
                }
            }
        });

        binding.goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = LoginActivity.LoginIntentFactory(getApplicationContext());
                startActivity(intent);
            }
        });
    }

    private boolean getEnteredLoginInformation() {
        username = binding.userEdit.getText().toString();
        password = binding.passEdit.getText().toString();

        if (isValidFieldValue()) {
            String confirmPassword = binding.confirmPasswordEdit.getText().toString();
            if (password.equals(confirmPassword)) {
                return true;
            } else {
                // TODO - Tell user to check password, update UI to be red
                Toast.makeText(CreateAccount.this, "Please check password.", Toast.LENGTH_SHORT).show();

            }
        } else {
            // TODO - Tell user to enter valid username + password, update UI to be red
            Toast.makeText(CreateAccount.this, "Please enter valid username + password", Toast.LENGTH_SHORT).show();

        }

        return false;
    }

    private boolean isValidFieldValue() {
        return !username.isEmpty() && !password.isEmpty();
    }


    public static Intent CreateAccountIntentFactory(Context context) {
        return new Intent(context, CreateAccount.class);
    }
}