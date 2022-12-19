package com.revhalisi.appchurch.biblePart;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.revhalisi.appchurch.R;

public class BookChaptersContent extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.books_content_layout);

        TextView textView = findViewById(R.id.txtView2);

        String Chapter_content = getIntent().getStringExtra("Articles");
        textView.setText(Chapter_content);
    }
}
