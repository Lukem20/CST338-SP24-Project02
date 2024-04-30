package com.lumoore.bakeryapplication.userActivities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.lumoore.bakeryapplication.R;
import com.lumoore.bakeryapplication.databinding.ActivityUserMenuBinding;
import com.lumoore.bakeryapplication.databinding.ActivityUserPageBinding;

public class UserActivity extends AppCompatActivity {
    private ActivityUserPageBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserPageBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_user_page);
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