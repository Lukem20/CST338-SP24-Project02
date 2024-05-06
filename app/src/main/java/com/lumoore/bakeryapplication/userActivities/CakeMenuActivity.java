package com.lumoore.bakeryapplication.userActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import com.lumoore.bakeryapplication.R;
import com.lumoore.bakeryapplication.databinding.ActivityCakeMenuBinding;

import java.util.HashMap;
import java.util.Objects;

public class CakeMenuActivity extends AppCompatActivity {
    private ActivityCakeMenuBinding binding;
    private HashMap<String, Integer> cakeItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cake_menu);

        SeekBar chocolateCakeSeekBar = binding.ChocolateCakeSeekBar;
        chocolateCakeSeekBar.setProgress(0);
        chocolateCakeSeekBar.incrementProgressBy(1);
        chocolateCakeSeekBar.setMax(10);
        chocolateCakeSeekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        String item = binding.ChocolateCakeTextView.getText().toString();
                        cakeItems.put(item, progress);
                    }
                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {}
                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {}
                }
        );

        SeekBar redVelvetCakeSeekBar = binding.RedVelvetCakeSeekBar;
        redVelvetCakeSeekBar.setProgress(0);
        redVelvetCakeSeekBar.incrementProgressBy(1);
        redVelvetCakeSeekBar.setMax(10);
        redVelvetCakeSeekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        String item = binding.RedVelvetCakeTextView.getText().toString();
                        cakeItems.put(item, progress);
                    }
                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {}
                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {}
                }
        );

        SeekBar carrotCakeSeekBar = binding.CarrotCakeSeekBar;
        carrotCakeSeekBar.setProgress(0);
        carrotCakeSeekBar.incrementProgressBy(1);
        carrotCakeSeekBar.setMax(10);
        carrotCakeSeekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        String item = binding.CarrotCakeTextView.getText().toString();
                        cakeItems.put(item, progress);
                    }
                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {}
                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {}
                }
        );

        binding.goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = FoodMenuActivity.FoodMenuIntentFactory(getApplicationContext());
                startActivity(intent);
            }
        });
    }

    public static Intent CakeMenuIntentFactory(Context context) {
        return new Intent(context, CakeMenuActivity.class);
    }

    /* Below Auto Generated */
    public HashMap<String, Integer> getCakeItems() {
        return cakeItems;
    }
    public void setCakeItems(HashMap<String, Integer> cakeItems) {
        this.cakeItems = cakeItems;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CakeMenuActivity that = (CakeMenuActivity) o;
        return Objects.equals(cakeItems, that.cakeItems);
    }
    @Override
    public int hashCode() {
        return Objects.hash(cakeItems);
    }
}