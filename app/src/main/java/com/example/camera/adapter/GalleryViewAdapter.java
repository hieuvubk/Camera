package com.example.camera.adapter;

import android.content.Context;
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
        if (imgFile.exists()) {
            Picasso.get().load(imgFile).placeholder(R.drawable.ic_launcher_background).into(holder.imageIV);
        }

    }

    @Override
    public int getItemCount() {
        return imagePathArrayList.size();
    }
    public static class GalleryViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageIV;
        public GalleryViewHolder(@NonNull View itemView) {
            super(itemView);
            imageIV = itemView.findViewById(R.id.idIVImage);
        }

    }
}
