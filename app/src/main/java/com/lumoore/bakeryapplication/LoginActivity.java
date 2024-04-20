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
                loginUser();
            }

//            @Override
//            public boolean onClick(View v) {
//                Intent intent = new User_Menu(getApplicationContext());
//                startActivity(intent);
//                return false;
//            }
        });

        binding.createAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "Create Account button", Toast.LENGTH_SHORT).show();
                getEnteredLoginInformation();
                createUser();
            }
        });
    }

    private void loginUser() {

    }

    private void createUser() {

    }

    private void getEnteredLoginInformation() {
        username = binding.userEdit.getText().toString();
        password = binding.passEdit.getText().toString();
    }
}

