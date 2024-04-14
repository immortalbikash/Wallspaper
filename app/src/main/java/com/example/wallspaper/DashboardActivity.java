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
import com.example.wallspaper.Model.PopularModel;

import java.util.ArrayList;

public class DashboardActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private Button latest, popular, trending;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dashboard);

        latest = findViewById(R.id.btnLatest);
        latest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, LatestActivity.class);
                startActivity(intent);
            }
        });

        trending = findViewById(R.id.btnTrending);
        trending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, TrendingActivity.class);
                startActivity(intent);
            }
        });

        recyclerView = findViewById(R.id.rvRecycler);

        ArrayList<PopularModel> list = new ArrayList<>();
        list.add(new PopularModel(R.drawable.i1));
        list.add(new PopularModel(R.drawable.i2));
        list.add(new PopularModel(R.drawable.dark));
        list.add(new PopularModel(R.drawable.doughnut));
        list.add(new PopularModel(R.drawable.food1));
        list.add(new PopularModel(R.drawable.food2));
        list.add(new PopularModel(R.drawable.food3));

        PopularAdapter adapter = new PopularAdapter(list, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}