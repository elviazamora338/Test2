package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.Fragments.CreateJournalFragment;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private Context context;
    private List<DataClass> dataList;

    public MyAdapter(Context context, List <DataClass> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(context).load(dataList.get(position).getDataImage()).into(holder.recImage);
        holder.recTitle.setText(dataList.get(position).getDataTitle());
        holder.recDate.setText(dataList.get(position).getDataDate());
        holder.recMoments.setText(dataList.get(position).getDataMoments());
        holder.recFacts.setText(dataList.get(position).getDataFacts());
        holder.recActivities.setText(dataList.get(position).getDataActivities());
        holder.recLocation.setText(dataList.get(position).getDataLocation());

        holder.recCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("Image", dataList.get(holder.getAdapterPosition()).getDataImage());
                intent.putExtra("Title", dataList.get(holder.getAdapterPosition()).getDataTitle());
                intent.putExtra("Location", dataList.get(holder.getAdapterPosition()).getDataLocation());
                intent.putExtra("Date", dataList.get(holder.getAdapterPosition()).getDataDate());
                intent.putExtra("Moments", dataList.get(holder.getAdapterPosition()).getDataMoments());
                intent.putExtra("Facts", dataList.get(holder.getAdapterPosition()).getDataFacts());
                intent.putExtra("Activities", dataList.get(holder.getAdapterPosition()).getDataActivities());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {

        return dataList.size();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder{

    ImageView recImage;
    TextView recTitle, recDate, recLocation, recMoments, recFacts, recActivities;
    CardView recCard;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        recImage = itemView.findViewById(R.id.recImage);
        recCard = itemView.findViewById(R.id.recCard);
        recTitle = itemView.findViewById(R.id.recTitle);
        recDate = itemView.findViewById(R.id.recDate);
        recMoments = itemView.findViewById(R.id.recMoments);
        recFacts = itemView.findViewById(R.id.recFacts);
        recActivities = itemView.findViewById(R.id.recActivities);
        recLocation = itemView.findViewById(R.id.recLocation);

    }

}
