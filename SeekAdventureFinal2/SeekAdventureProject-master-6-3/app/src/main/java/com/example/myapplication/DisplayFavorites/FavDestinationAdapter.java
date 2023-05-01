package com.example.myapplication.DisplayFavorites;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import com.example.myapplication.R;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FavDestinationAdapter extends RecyclerView.Adapter<FavDestinationAdapter.ViewHolder> {

    private ArrayList<FavDestinationItem> favDestinationItems;
    private Context context;
    private FavDB favDB;

    public FavDestinationAdapter(ArrayList<FavDestinationItem> destinationItems, Context context) {
        this.favDestinationItems = favDestinationItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        favDB = new FavDB(context);
        // create table on first
        SharedPreferences prefs = context.getSharedPreferences("prefs", Context.MODE_PRIVATE);
        boolean firstStart = prefs.getBoolean("firstStart", true);
        if (!firstStart) {
            createTableOnFirstStart();
        }

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_row,
                parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavDestinationAdapter.ViewHolder holder, int position) {
        final FavDestinationItem favDestinationItem = favDestinationItems.get(position);

        readCursorData(favDestinationItem, holder);
        holder.imageView.setImageResource(favDestinationItem.getImageResource());
        holder.dName.setText(favDestinationItem.getTitle());
    }

    @Override
    public int getItemCount() {
        return favDestinationItems.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView dName;
        Button favBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image);
            dName = itemView.findViewById(R.id.destinationName);
            favBtn = itemView.findViewById(R.id.favBtn);

            // add to fav btn
            favBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    FavDestinationItem favDestinationItem = favDestinationItems.get(position);

                    if (favDestinationItem.getFavStatus().equals("0")) {
                        favDestinationItem.setFavStatus("1");
                        favDB.insertIntoTheDatabase(favDestinationItem.getTitle(), favDestinationItem.getImageResource(),
                                favDestinationItem.getKey_id(), favDestinationItem.getFavStatus());
                        favBtn.setBackgroundResource(R.drawable.ic_baseline_favorite_24);
                    } else {
                        favDestinationItem.setFavStatus("0");
                        favDB.remove_fav(favDestinationItem.getKey_id());
                        favBtn.setBackgroundResource(R.drawable.ic_baseline_favorite_shadow_24dp);
                    }
                }
            });
        }
    }

    private void createTableOnFirstStart() {
        favDB.insertEmpty();

        SharedPreferences prefs = context.getSharedPreferences("prefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("firstStart", false);
        editor.apply();
    }

    private void readCursorData(FavDestinationItem favDestinationItem, ViewHolder viewHolder) {
        Cursor cursor = favDB.read_all_data(favDestinationItem.getKey_id());
        SQLiteDatabase db = favDB.getReadableDatabase();
        try {
             while(cursor.moveToNext()) {
                 String item_fav_status = cursor.getString(cursor.getColumnIndex(FavDB.FAVORITE_STATUS));
                 favDestinationItem.setFavStatus(item_fav_status);

                 // check fav status
                 if (item_fav_status != null && item_fav_status.equals("1")) {
                     viewHolder.favBtn.setBackgroundResource(R.drawable.ic_baseline_favorite_24);
                 } else if (item_fav_status != null && item_fav_status.equals("0")) {
                     viewHolder.favBtn.setBackgroundResource(R.drawable.ic_baseline_favorite_shadow_24dp);
                 }
             }
        } finally {
            if (cursor != null && cursor.isClosed()) {
                cursor.close();
                db.close();
            }
        }
    }

}


