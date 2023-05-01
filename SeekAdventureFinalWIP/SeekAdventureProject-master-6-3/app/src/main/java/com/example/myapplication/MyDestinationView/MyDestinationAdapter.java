package com.example.myapplication.MyDestinationView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyDestinationAdapter extends RecyclerView.Adapter<MyDestinationAdapter.MyViewHolder>{

    private final DestinationRecyclerViewInterface destinationRecyclerViewInterface;
    Context context;
    ArrayList<DestinationItem> destinationItems;

    public MyDestinationAdapter(Context context, ArrayList<DestinationItem> destinationItems,
                                DestinationRecyclerViewInterface destinationRecyclerViewInterface) {
        this.context = context;
        this.destinationItems = destinationItems;
        this.destinationRecyclerViewInterface = destinationRecyclerViewInterface;
    }

    @NonNull
    @Override
    public MyDestinationAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // This is where you inflate the layout (Giving a look to our rows)
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent, false);
        return new MyDestinationAdapter.MyViewHolder(view, destinationRecyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull MyDestinationAdapter.MyViewHolder holder, int position) {
        // assigning values to the views we created in the recycler_view_row layout file
        // based on the position of the recycler view

        holder.tvName.setText(destinationItems.get(position).getDestinationName());
        holder.imageView.setImageResource(destinationItems.get(position).getDestinationImage());
    }

    @Override
    public int getItemCount() {
        // the recycler view just wants to know the numbers of items you want displayed
        return destinationItems.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // grabbing the views from our recycler_view_layout file
        // similar to the onCreate method
        CircleImageView imageView;
        TextView tvName;

        public MyViewHolder(@NonNull View itemView, DestinationRecyclerViewInterface destinationRecyclerViewInterface) {
            super(itemView);

            imageView = itemView.findViewById(R.id.destinationImage);
            tvName = itemView.findViewById(R.id.destinationName);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (destinationRecyclerViewInterface != null) {
                        int pos = getAdapterPosition();

                        if (pos != RecyclerView.NO_POSITION) {
                            destinationRecyclerViewInterface.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }
}
