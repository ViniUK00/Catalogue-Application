package com.example.catalogueapplication;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupRecyclerView();
    }

    private void setupRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        AnimalAdapter adapter = new AnimalAdapter(this);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener((imageResId, details, animal) -> openItemDetails(imageResId, details, animal));
    }

    private void openItemDetails(int imageResId, String details, String animal) {
        Intent intent = new Intent(this, ItemDetailsActivity.class);
        intent.putExtra("imageResId", imageResId)
                .putExtra("details", details).putExtra("animals",animal);
        startActivity(intent);
    }
}
