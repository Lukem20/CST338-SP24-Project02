package com.lumoore.bakeryapplication.userActivities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.lumoore.bakeryapplication.LoginActivity;
import com.lumoore.bakeryapplication.R;
import com.lumoore.bakeryapplication.databinding.ActivityUserPageBinding;

public class UserActivity extends AppCompatActivity {
    private ActivityUserPageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserPageBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_user_page);

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

    public static Intent UserActivityIntentFactory(Context context) {
        return new Intent(context, UserActivity.class);
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