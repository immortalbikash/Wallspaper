package com.example.wallspaper;

import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

public class Details extends AppCompatActivity {

    private ImageView image;
    private Button set_wallspaper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_details);

        image = findViewById(R.id.ivDetails);
        set_wallspaper = findViewById(R.id.button);

        set_wallspaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WallpaperManager wallpaperManager = WallpaperManager.getInstance(getApplicationContext());
                try {
                    Bitmap bitmap = ((android.graphics.drawable.BitmapDrawable) image.getDrawable()).getBitmap();
                    wallpaperManager.setBitmap(bitmap);
                    Toast.makeText(Details.this, "Wallspaper set sucessfully!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Details.this, DashboardActivity.class);
                    startActivity(intent);
                }
                catch (Exception g){
                    g.printStackTrace();
                }

            }
        });

        Bundle bundle = getIntent().getExtras();
        String url = bundle.getString("image");
        Glide.with(this).load(url).into(image);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}