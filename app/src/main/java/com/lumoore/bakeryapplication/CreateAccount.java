package com.lumoore.bakeryapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.room.PrimaryKey;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.lumoore.bakeryapplication.database.BakeryOrderRepository;
import com.lumoore.bakeryapplication.database.entities.User;
import com.lumoore.bakeryapplication.databinding.ActivityCreateAccountBinding;
import com.lumoore.bakeryapplication.userActivities.UserActivity;

import java.util.concurrent.atomic.AtomicBoolean;

public class CreateAccount extends AppCompatActivity {
    @PrimaryKey
    String username = "";
    String password = "";
    private ActivityCreateAccountBinding binding;
    private BakeryOrderRepository repository;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCreateAccountBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        repository = BakeryOrderRepository.getRepository(getApplication());

        binding.createAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getEnteredLoginInformation();
                if (verifyUsername() && verifyPassword()) {
                    Intent intent = UserActivity.UserActivityIntentFactory(getApplicationContext(), 0);
                    startActivity(intent);
                }
            }
        });

        binding.goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO createUserRecord();
                Intent intent = LoginActivity.LoginIntentFactory(getApplicationContext());
                startActivity(intent);
            }
        });
    }

    private void getEnteredLoginInformation() {
        username = binding.userEdit.getText().toString();
        password = binding.passEdit.getText().toString();
    }

    private boolean verifyUsername() {
        if (!isValidFieldValue()) {
            toastMaker("Please enter Username");
            return false;
        }

        AtomicBoolean userExists = new AtomicBoolean(false);

        LiveData<User> userObserver = repository.getUserbyUserName(username);
        userObserver.observe(this, user -> {
            if (user != null) {
                toastMaker(String.format("User %s already exists", username));
                binding.userEdit.setSelection(0);
                userExists.set(true);
            } else {
                userExists.set(false);
            }
        });

        return !userExists.get();
    }

    private boolean verifyPassword() {
        if (isValidFieldValue()) {
            String confirmPassword = binding.confirmPasswordEdit.getText().toString();
            if (password.equals(confirmPassword)) {
                return true;
            } else {
                toastMaker("Please check password.");
                return false;
            }
        } else {
            toastMaker("Please enter valid username & password");
            return false;
        }
    }

    private boolean isValidFieldValue() {
        return !username.isEmpty() && !password.isEmpty();
    }


    public static Intent CreateAccountIntentFactory(Context context) {
        return new Intent(context, CreateAccount.class);
    }

    public void toastMaker (String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}