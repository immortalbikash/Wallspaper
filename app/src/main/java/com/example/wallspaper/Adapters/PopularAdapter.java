package com.example.wallspaper.Adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.wallspaper.DashboardActivity;
import com.example.wallspaper.Details;
import com.example.wallspaper.Model.DataClass;
import com.example.wallspaper.Model.PopularModel;
import com.example.wallspaper.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.viewHolder> {

    ArrayList<DataClass> list;
    Context context;


    public PopularAdapter(ArrayList<DataClass> list,Context context){
        this.list =list;
        this.context = context;
    }

    @NonNull
    @Override
    public PopularAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.popular_recyclerview, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularAdapter.viewHolder holder, int position) {
//        Toast.makeText(context, list.size(), Toast.LENGTH_SHORT).show();
        Glide.with(context).load(list.get(position).getImageUrl()).into(holder.image);
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Details.class);
                intent.putExtra("image", list.get(position).getImageUrl());
//                Toast.makeText(context, list.get(position).getImageUrl(), Toast.LENGTH_SHORT).show();
                context.startActivity(intent);
            }
        });

        holder.image.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("Do you want to delete?")
                                .setCancelable(true)
                                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                String key = list.get(position).getKey();
                                                FirebaseDatabase.getInstance().getReference("Images").child(key).removeValue();
                                                Toast.makeText(context, "Image deleted", Toast.LENGTH_SHORT).show();
                                                ((DashboardActivity) context).recreate();
                                            }
                                        })
                                                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        dialog.cancel();
                                                    }
                                                });
                builder.setTitle("Delete");
                builder.show();
                return  true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.ivPopular);
        }
    }
}
