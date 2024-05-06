package com.lumoore.bakeryapplication.userActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import com.lumoore.bakeryapplication.databinding.ActivityBreadMenuBinding;

import java.util.HashMap;
import java.util.Objects;

public class BreadMenuActivity extends AppCompatActivity {
    private ActivityBreadMenuBinding binding;
    private HashMap<String, Integer> breadItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        SeekBar csb = binding.CiabattaSeekBar;
        csb.setProgress(0);
        csb.incrementProgressBy(1);
        csb.setMax(10);
        binding.CiabattaSeekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        String item = binding.CiabattaTextView.getText().toString();
                        breadItems.put(item, progress);
                    }
                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {}
                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {}
                }
        );

        SeekBar ssb = binding.SourdoughSeekBar;
        ssb.setProgress(0);
        ssb.incrementProgressBy(1);
        ssb.setMax(10);
        binding.SourdoughSeekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        String item = binding.SourdoughTextView.getText().toString();
                        breadItems.put(item, progress);
                    }
                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {}
                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {}
                }
        );

        SeekBar dcsb = binding.DutchCrunchSeekBar;
        dcsb.setProgress(0);
        dcsb.incrementProgressBy(1);
        dcsb.setMax(10);
        binding.DutchCrunchSeekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        String item = binding.DutchCrunchTextView.getText().toString();
                        breadItems.put(item, progress);
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

    public static Intent BreadMenuIntentFactory(Context context) {
        return new Intent(context, BreadMenuActivity.class);
    }

    /* Below Auto Generated */
    public HashMap<String, Integer> getBreadItems() {
        return breadItems;
    }
    public void setBreadItems(HashMap<String, Integer> breadItems) {
        this.breadItems = breadItems;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BreadMenuActivity that = (BreadMenuActivity) o;
        return Objects.equals(breadItems, that.breadItems);
    }
    @Override
    public int hashCode() {
        return Objects.hash(breadItems);
    }
}