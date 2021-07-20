package com.example.camera.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.camera.R;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;


public class GalleryViewAdapter extends RecyclerView.Adapter<GalleryViewAdapter.GalleryViewHolder> {

    private final Context context;
    private final ArrayList<String> imagePathArrayList;

    public GalleryViewAdapter(Context context, ArrayList<String> imagePathArrayList) {
        this.context = context;
        this.imagePathArrayList = imagePathArrayList;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public GalleryViewAdapter.GalleryViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_layout, parent, false);
        return new GalleryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull GalleryViewAdapter.GalleryViewHolder holder, int position) {

        File imgFile = new File(imagePathArrayList.get(position));
//        holder.itemView.setBackgroundResource(R.drawable.gallery);

        // on below line we are checking if tje file exists or not.
        if (imgFile.exists()) {

            // if the file exists then we are displaying that file in our image view using picasso library.
            Picasso.get().load(imgFile).placeholder(R.drawable.ic_launcher_background).into(holder.imageIV);

            // on below line we are adding click listener to our item of recycler view.
//            holder.itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    // inside on click listner we are creating a new intent
//                    Intent i = new Intent(context, ImageDetailActivity.class);
//
//                    // on below line we are passing the image path to our new activity.
//                    i.putExtra("imgPath", imagePathArrayList.get(position));
//
//                    // at last we are starting our activity.
//                    context.startActivity(i);
//                }
//            });
        }

    }

    @Override
    public int getItemCount() {
        return imagePathArrayList.size();
    }

    public static class GalleryViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our views.
        private final ImageView imageIV;

        public GalleryViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our views with their ids.
            imageIV = itemView.findViewById(R.id.idIVImage);
        }

    }
}
