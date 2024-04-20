package com.lumoore.bakeryapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class User_Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_user_menu);


        boolean isAdmin;

        if (isAdmin) {
            adminButton.setVisibility(View.VISIBLE);
        }

        Button logoutButton = findViewById(R.id.logout_button);
        logoutButton.setOnClickListener(v -> logout());
    }

    private void logout() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("isAdmin");
        editor.apply();

        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();

    }
}