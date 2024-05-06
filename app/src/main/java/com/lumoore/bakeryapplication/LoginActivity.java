package com.lumoore.bakeryapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.room.PrimaryKey;

import com.lumoore.bakeryapplication.adminActivities.AdminActivity;
import com.lumoore.bakeryapplication.database.BakeryOrderRepository;
import com.lumoore.bakeryapplication.database.entities.User;
import com.lumoore.bakeryapplication.databinding.ActivityLoginBinding;
import com.lumoore.bakeryapplication.userActivities.UserActivity;

public class LoginActivity extends AppCompatActivity {
    String username = "";
    String password = "";
    private ActivityLoginBinding binding;
    private BakeryOrderRepository repository;
    private User user = null;


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
                getEnteredLoginInformation();
                if (isValidFieldValue()) {
                    verifyUser();
                }
            }
        });

        binding.createAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getEnteredLoginInformation();
                    Intent intent = CreateAccount.CreateAccountIntentFactory(getApplicationContext());
                    startActivity(intent);
            }
        });
    }

    private void verifyUser() {
        String username = binding.userEdit.getText().toString();
        if (username.isEmpty()) {
            return;
        }

        LiveData<User> userObserver = repository.getUserbyUserName(username);
        userObserver.observe(this, user -> {
            if (user != null) {
                if (password.equals(user.getPassword())) {
                    loginUser(user);
                } else {
                    toastMaker("Invalid password");
                    binding.passEdit.setSelection(0);
                }
            } else {
                toastMaker(String.format("Invalid Username: %s" ,username));
                binding.userEdit.setSelection(0);
            }
        });
    }

    public void toastMaker (String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public static Intent LoginIntentFactory(Context context) {
        return new Intent(context, LoginActivity.class);
    }

    private void loginUser(User user) {
        if (user.isAdmin()) {
            Intent intent = AdminActivity.AdminIntentFactory(getApplicationContext());
            startActivity(intent);
        } else {
            SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(UserActivity.SHARED_PREFERENCE_USERID_KEY, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt(UserActivity.SHARED_PREFERENCE_USERID_KEY, UserActivity.LOGGED_OUT);
            editor.apply();

             Intent intent = UserActivity.UserActivityIntentFactory(getApplicationContext(), user.getId());
             startActivity(intent);
        }
    }


    /**
     *  Checks if the values that were entered and stored in Username & Password text fields are valid
     * @return true if valid, false if not
     */
    private boolean isValidFieldValue() {
        return !username.isEmpty() && !password.isEmpty();
    }

    private void getEnteredLoginInformation() {
        username = binding.userEdit.getText().toString();
        password = binding.passEdit.getText().toString();
    }
}