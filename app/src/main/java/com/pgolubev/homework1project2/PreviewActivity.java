package com.pgolubev.homework1project2;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class PreviewActivity extends AppCompatActivity {

    private TextView textPreview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);

        textPreview = findViewById(R.id.textPreview);

        String text = getIntent().getStringExtra("text");
        float size = getIntent().getFloatExtra("size", 12f);
        int color = getIntent().getIntExtra("color", 0xFFFF0000);
        boolean bold = getIntent().getBooleanExtra("bold", false);
        boolean italic = getIntent().getBooleanExtra("italic", false);

        textPreview.setText(text);
        textPreview.setTextSize(size);
        textPreview.setTextColor(color);

        int style = Typeface.NORMAL;
        if (bold && italic) {
            style = Typeface.BOLD_ITALIC;
        } else if (bold) {
            style = Typeface.BOLD;
        } else if (italic) {
            style = Typeface.ITALIC;
        }

        textPreview.setTypeface(null, style);
    }
}