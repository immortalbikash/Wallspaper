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

import com.example.wallspaper.Adapters.PopularAdapter;
import com.example.wallspaper.Adapters.TrendingAdapter;
import com.example.wallspaper.Model.PopularModel;
import com.example.wallspaper.Model.TrendingModel;

import java.util.ArrayList;

public class TrendingActivity extends AppCompatActivity {

    private Button latest, popular, trending;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_trending);

        popular = findViewById(R.id.btnPopular);
        popular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TrendingActivity.this, DashboardActivity.class);
                startActivity(intent);
            }
        });

        latest = findViewById(R.id.btnLatest);
        latest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TrendingActivity.this, LatestActivity.class);
                startActivity(intent);
            }
        });

        recyclerView = findViewById(R.id.rvTRecycler);

        ArrayList<TrendingModel> list = new ArrayList<>();
        list.add(new TrendingModel(R.drawable.dark));
        list.add(new TrendingModel(R.drawable.food1));
        list.add(new TrendingModel(R.drawable.doughnut));
        list.add(new TrendingModel(R.drawable.i2));
        list.add(new TrendingModel(R.drawable.food3));

        TrendingAdapter adapter = new TrendingAdapter(list, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}