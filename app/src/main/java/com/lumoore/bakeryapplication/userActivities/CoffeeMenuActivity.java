package com.lumoore.bakeryapplication.userActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import com.lumoore.bakeryapplication.databinding.ActivityCoffeeMenuBinding;

import java.util.HashMap;
import java.util.Objects;

public class CoffeeMenuActivity extends AppCompatActivity {
    private ActivityCoffeeMenuBinding binding;
    private HashMap<String, Integer> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        SeekBar dcsb = binding.DripCoffeeSeekBar;
        dcsb.setProgress(0);
        dcsb.incrementProgressBy(1);
        dcsb.setMax(10);
        binding.DripCoffeeSeekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        String item = binding.DripCoffeeTextView.getText().toString();
                        items.put(item, progress);
                    }
                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {}
                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {}
                }
        );

        SeekBar latteSeekBar = binding.LatteSeekBar;
        latteSeekBar.setProgress(0);
        latteSeekBar.incrementProgressBy(1);
        latteSeekBar.setMax(10);
        binding.LatteSeekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        String item = binding.LatteTextView.getText().toString();
                        items.put(item, progress);
                    }
                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {}
                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {}
                }
        );

        SeekBar cappuccinoSeekBar = binding.CappuccinoSeekBar;
        cappuccinoSeekBar.setProgress(0);
        cappuccinoSeekBar.incrementProgressBy(1);
        cappuccinoSeekBar.setMax(10);
        binding.CappuccinoSeekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        String item = binding.CappuccinoTextView.getText().toString();
                        items.put(item, progress);
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
                Intent intent = DrinksMenuActivity.DrinksMenuIntentFactory(getApplicationContext());
                startActivity(intent);
            }
        });
    }

    public static Intent CoffeeMenuIntentFactory(Context context) {
        return new Intent(context, CoffeeMenuActivity.class);
    }

    /* Below Auto Generated */
    public HashMap<String, Integer> getItems() {
        return items;
    }
    public void setItems(HashMap<String, Integer> items) {
        this.items = items;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoffeeMenuActivity that = (CoffeeMenuActivity) o;
        return Objects.equals(items, that.items);
    }
    @Override
    public int hashCode() {
        return Objects.hash(items);
    }
}