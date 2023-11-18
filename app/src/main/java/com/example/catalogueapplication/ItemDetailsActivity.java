package com.example.catalogueapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ItemDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);

        ImageView itemDetailImage = findViewById(R.id.itemDetailImage);
        TextView itemDetailText = findViewById(R.id.itemDetailText);
        TextView itemDetailTextName = findViewById(R.id.itemDetailTextName);

        // Get data from the intent
        int imageResId = getIntent().getIntExtra("imageResId", 0);
        String details = getIntent().getStringExtra("details");
        String animalName = getIntent().getStringExtra("animals");

        // Set data to views
        itemDetailImage.setImageResource(imageResId);
        itemDetailText.setText(details);
        itemDetailTextName.setText(animalName);

        // Set up the onClickListener for the "Back" button
        findViewById(R.id.backButton).setOnClickListener(v -> goBack());
    }

    // Function to handle the "Back" button click
    public void goBack() {
        // Finish the current activity and go back to the previous one
        finish();
    }
}
