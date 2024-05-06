package com.lumoore.bakeryapplication.userActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import com.lumoore.bakeryapplication.R;
import com.lumoore.bakeryapplication.databinding.ActivityTeaMenuBinding;

import java.util.HashMap;
import java.util.Objects;

public class TeaMenuActivity extends AppCompatActivity {
    private ActivityTeaMenuBinding binding;
    private HashMap<String, Integer> teaItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        binding.goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = DrinksMenuActivity.DrinksMenuIntentFactory(getApplicationContext());
                startActivity(intent);
            }
        });

        binding.ChaiSeekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        String items = binding.ChaiTextView.getText().toString();
                        teaItems.put(items, progress);
                    }
                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {}
                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {}
                }
        );

        binding.ThaiTeaSeekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        String items = binding.ThaiTeaTextView.getText().toString();
                        teaItems.put(items, progress);
                    }
                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {}
                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {}
                }
        );

        binding.JasmineTeaSeekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        String items = binding.JasmineTextView.getText().toString();
                        teaItems.put(items, progress);
                    }
                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {}
                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {}
                }
        );
    }

    public static Intent TeaMenuIntentFactory(Context context) {
        return new Intent(context, TeaMenuActivity.class);
    }

    /* Below Auto Generated */
    public HashMap<String, Integer> getTeaItems() {
        return teaItems;
    }
    public void setTeaItems(HashMap<String, Integer> teamItems) {
        this.teaItems = teamItems;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeaMenuActivity that = (TeaMenuActivity) o;
        return Objects.equals(teaItems, that.teaItems);
    }
    @Override
    public int hashCode() {
        return Objects.hash(teaItems);
    }
}