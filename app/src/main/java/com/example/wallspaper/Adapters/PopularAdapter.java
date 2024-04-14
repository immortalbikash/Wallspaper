package com.example.wallspaper.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wallspaper.DashboardActivity;
import com.example.wallspaper.Details;
import com.example.wallspaper.Model.PopularModel;
import com.example.wallspaper.R;

import java.util.ArrayList;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.viewHolder> {

    ArrayList<PopularModel> list;
    Context context;

    public PopularAdapter(ArrayList<PopularModel> list,Context context){
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
        PopularModel model = list.get(position);
        holder.image.setImageResource(model.getPic());

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Details.class);
                intent.putExtra("image", model.getPic());
                context.startActivity(intent);
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
