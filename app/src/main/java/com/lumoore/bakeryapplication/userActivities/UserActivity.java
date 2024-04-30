package com.lumoore.bakeryapplication.userActivities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.lumoore.bakeryapplication.LoginActivity;
import com.lumoore.bakeryapplication.databinding.ActivityUserPageBinding;

public class UserActivity extends AppCompatActivity {
    private static final String USER_ACTIVITY_USER_ID = "com.lumoore.bakeryapplication.userActivities.USER_ACTIVITY_USER_ID";
    private ActivityUserPageBinding binding;
    int loggedInUserID = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        logInUser();

        if(loggedInUserID == -1) {
            Intent intent = LoginActivity.LoginIntentFactory(getApplicationContext());
            startActivity(intent);
        }

        binding.FoodMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = FoodMenuActivity.FoodMenuIntentFactory(getApplicationContext());
                startActivity(intent);
            }
        });

        binding.DrinksMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = DrinksMenuActivity.DrinksMenuIntentFactory(getApplicationContext());
                startActivity(intent);
            }
        });

        binding.ViewCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = UserCartActivity.UserCartIntentFactory(getApplicationContext());
                startActivity(intent);
            }
        });

        binding.CheckoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = CheckoutActivity.CheckoutIntentFactory(getApplicationContext());
                startActivity(intent);
            }
        });

        binding.logoutUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = LoginActivity.LoginIntentFactory(getApplicationContext());
                startActivity(intent);
            }
        });
    }

    private void logInUser() {
        // TODO - Create login method.
        loggedInUserID = getIntent().getIntExtra(USER_ACTIVITY_USER_ID, -1);
    }

    public static Intent UserActivityIntentFactory(Context context, int userID) {
        Intent intent = new Intent(context, UserActivity.class);
        intent.putExtra(USER_ACTIVITY_USER_ID, userID);
        return intent;
    }

//    private void logout() {
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.remove("isAdmin");
//        editor.apply();
//        Intent intent = new Intent(this, MainActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        startActivity(intent);
//        finish();
//    }
}