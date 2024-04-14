package com.example.wallspaper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wallspaper.Adapters.LatestAdapter;
import com.example.wallspaper.Adapters.PopularAdapter;
import com.example.wallspaper.Model.LatestModel;
import com.example.wallspaper.Model.PopularModel;

import java.util.ArrayList;

public class LatestActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private Button latest, popular, trending;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_latest);

        popular = findViewById(R.id.btnPopular);
        popular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LatestActivity.this, DashboardActivity.class);
                startActivity(intent);
            }
        });

        trending = findViewById(R.id.btnTrending);
        trending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LatestActivity.this, TrendingActivity.class);
                startActivity(intent);
            }
        });


        recyclerView = findViewById(R.id.rvLRecycler);
        ArrayList<LatestModel> list = new ArrayList<>();
        list.add(new LatestModel(R.drawable.food3));
        list.add(new LatestModel(R.drawable.i2));
        list.add(new LatestModel(R.drawable.doughnut));
        list.add(new LatestModel(R.drawable.food1));

        LatestAdapter adapter = new LatestAdapter(list, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}