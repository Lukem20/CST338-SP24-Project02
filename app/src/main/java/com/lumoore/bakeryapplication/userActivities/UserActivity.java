package com.lumoore.bakeryapplication.userActivities;

import android.app.MediaRouteButton;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.lumoore.bakeryapplication.LoginActivity;
import com.lumoore.bakeryapplication.adminActivities.AdminActivity;
import com.lumoore.bakeryapplication.database.BakeryOrderRepository;
import com.lumoore.bakeryapplication.databinding.ActivityUserPageBinding;

public class UserActivity extends AppCompatActivity {
    private static final String USER_ACTIVITY_USER_ID = "com.lumoore.bakeryapplication.userActivities.USER_ACTIVITY_USER_ID";
    public static final int LOGGED_OUT = -1;
    public static final String SHARED_PREFERENCE_USERID_KEY = "com.lumoore.bakeryapplication.SHARED_PREFERENCE_USERID_KEY";
    public static final String SHARED_PREFERENCE_USERID_VALUE = "com.lumoore.bakeryapplication.SHARED_PREFERENCE_USERID_VALUE";

    private ActivityUserPageBinding binding;
    private BakeryOrderRepository repository;
    int loggedInUserID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        logInUser();

        if(loggedInUserID == -1) {
            logoutUser();
        }

        repository = BakeryOrderRepository.getRepository(getApplication());

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

        binding.bAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = AdminActivity.AdminIntentFactory(getApplicationContext());
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
        // Check shared preference for logged in user
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(SHARED_PREFERENCE_USERID_KEY, Context.MODE_PRIVATE);
        loggedInUserID = sharedPreferences.getInt(SHARED_PREFERENCE_USERID_VALUE, LOGGED_OUT);
        if (loggedInUserID != LOGGED_OUT) {
            return;
        }

        // Check intent for logged in user
        loggedInUserID = getIntent().getIntExtra(USER_ACTIVITY_USER_ID, LOGGED_OUT);
    }

    private void logoutUser() {
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(SHARED_PREFERENCE_USERID_KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(SHARED_PREFERENCE_USERID_KEY, LOGGED_OUT);
        editor.apply();

        getIntent().putExtra(USER_ACTIVITY_USER_ID, LOGGED_OUT);

        startActivity(LoginActivity.LoginIntentFactory(getApplicationContext()));
    }

      if (isAdmin) {
        bAdmin.setVisibility(View.VISIBLE);
    } else {
        MediaRouteButton bAdmin;
        bAdmin.setVisibility(View.GONE);
    }

    public static Intent UserActivityIntentFactory(Context context, int userID) {
        Intent intent = new Intent(context, UserActivity.class);
        intent.putExtra(USER_ACTIVITY_USER_ID, userID);
        return intent;
    }

//    private void logout() {
//        editor.remove("isAdmin");
//        editor.apply();
//        Intent intent = new Intent(this, MainActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        startActivity(intent);
//        finish();
//    }

}