package com.pgolubev.homework1project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {

    private EditText editText;
    private SeekBar seekSize;
    private TextView textSizeValue;
    private RadioGroup radioColors;
    private CheckBox checkBold, checkItalic;
    private Button buttonShow;

    private float textSizeSp = 12f;
    private int textColor = Color.RED;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        editText = findViewById(R.id.editTextInput);
        seekSize = findViewById(R.id.seekTextSize);
        textSizeValue = findViewById(R.id.textSizeValue);
        radioColors = findViewById(R.id.radioColors);
        checkBold = findViewById(R.id.checkBold);
        checkItalic = findViewById(R.id.checkItalic);
        buttonShow = findViewById(R.id.buttonShow);

        //  с 12 эааэ дл 48
        seekSize.setMax(48 - 12);
        seekSize.setProgress(0);
        updateSizeLabel();

        seekSize.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar sb, int progress, boolean fromUser) {
                textSizeSp = 12 + progress;
                updateSizeLabel();
            }

            @Override
            public void onStartTrackingTouch(SeekBar sb) {}

            @Override
            public void onStopTrackingTouch(SeekBar sb) {}
        });

        radioColors.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.radioRed) {
                textColor = Color.RED;
            } else if (checkedId == R.id.radioBlue) {
                textColor = Color.BLUE;
            } else if (checkedId == R.id.radioGreen) {
                textColor = Color.GREEN;
            }
        });


        RadioButton radioRed = findViewById(R.id.radioRed);
        radioRed.setChecked(true);

        buttonShow.setOnClickListener(v -> {
            String text = editText.getText().toString();
            boolean bold = checkBold.isChecked();
            boolean italic = checkItalic.isChecked();

            Intent intent = new Intent(SettingsActivity.this, PreviewActivity.class);
            intent.putExtra("text", text);
            intent.putExtra("size", textSizeSp);
            intent.putExtra("color", textColor);
            intent.putExtra("bold", bold);
            intent.putExtra("italic", italic);
            startActivity(intent);
        });
    }

    private void updateSizeLabel() {
        textSizeValue.setText(String.valueOf((int) textSizeSp) + " sp");
    }
}