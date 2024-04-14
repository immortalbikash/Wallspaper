package com.example.wallspaper;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wallspaper.Model.LatestModel;
import com.example.wallspaper.Model.PopularModel;

import java.util.ArrayList;

public class LatestdetailActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Button latest, popular, trending;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_latestdetail);

        recyclerView = findViewById(R.id.rvLRecycler);
        ArrayList<LatestModel> list = new ArrayList<>();
        list.add(new LatestModel(R.drawable.food3));
        list.add(new LatestModel(R.drawable.dark));
        list.add(new LatestModel(R.drawable.food1));
        list.add(new LatestModel(R.drawable.doughnut));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}