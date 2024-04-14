package com.example.wallspaper.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wallspaper.Details;
import com.example.wallspaper.Model.LatestModel;
import com.example.wallspaper.Model.PopularModel;
import com.example.wallspaper.R;

import java.util.ArrayList;

public class LatestAdapter extends RecyclerView.Adapter<LatestAdapter.viewHolder> {

    ArrayList<LatestModel> list;
    Context context;

    public LatestAdapter(ArrayList<LatestModel> list,Context context){
        this.list =list;
        this.context = context;
    }
    @NonNull
    @Override
    public LatestAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.popular_recyclerview, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LatestAdapter.viewHolder holder, int position) {
        LatestModel model = list.get(position);
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

    public class viewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.ivPopular);
        }
    }
}
