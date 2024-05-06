package com.lumoore.bakeryapplication.userActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import com.lumoore.bakeryapplication.R;
import com.lumoore.bakeryapplication.databinding.ActivityPastryMenuBinding;

import java.util.HashMap;
import java.util.Objects;

public class PastryMenuActivity extends AppCompatActivity {
    private ActivityPastryMenuBinding binding;

    // Stores the user's order for this menu, key is the item and value is  the amount.
    private HashMap<String, Integer> pastryItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        binding.AlmondBearClawSeekBar.setOnSeekBarChangeListener(
            new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    String item = binding.AlmondBearClawTextView.getText().toString();
                    pastryItems.put(item, progress);
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

    public static Intent PastryMenuIntentFactory(Context context) {
        return new Intent(context, PastryMenuActivity.class);
    }

    /* Below Auto Generated */
    public HashMap<String, Integer> getPastryItems() {
        return pastryItems;
    }
    public void setPastryItems(HashMap<String, Integer> pastryItems) {
        this.pastryItems = pastryItems;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PastryMenuActivity that = (PastryMenuActivity) o;
        return Objects.equals(pastryItems, that.pastryItems);
    }
    @Override
    public int hashCode() {
        return Objects.hash(pastryItems);
    }
}