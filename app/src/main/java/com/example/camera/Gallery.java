package com.example.camera;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;

import com.example.camera.adapter.GalleryViewAdapter;

import org.wysaid.common.Common;
import org.wysaid.nativePort.CGENativeLibrary;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class Gallery extends AppCompatActivity {

    private static final int PERMISSION_REQUEST_CODE = 200;
    private ArrayList<String> imagePaths;
    private RecyclerView imagesRV;
    private GalleryViewAdapter imageRVAdapter;
    String path;

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        Intent intent = getIntent();
        path = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        imagePaths = new ArrayList<>();
        imagesRV = findViewById(R.id.idRVImages);
        try {
            getImagePath();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        // calling a method to
        // prepare our recycler view.
        prepareRecyclerView();

    }

    private void prepareRecyclerView() {

        imageRVAdapter = new GalleryViewAdapter(Gallery.this, imagePaths);

        GridLayoutManager manager = new GridLayoutManager(Gallery.this, 3);
        imagesRV.setLayoutManager(manager);
        imagesRV.setAdapter(imageRVAdapter);
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    private void getImagePath() throws URISyntaxException {
        // in this method we are adding all our image paths
        // in our arraylist which we have created.
        // on below line we are checking if the device is having an sd card or not.
        boolean isSDPresent = android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED);

        if (isSDPresent) {

            // if the sd card is present we are creating a new list in
            // which we are getting our images data with their ids.
            final String[] columns = {MediaStore.Images.Media.DATA, MediaStore.Images.Media._ID};

            // on below line we are creating a new
            // string to order our images by string.
            final String orderBy = MediaStore.Images.Media._ID;

            File direct = new File(path);
            File listFile[] = direct.listFiles();
            for(int i=0; i < listFile.length; i++) {
                imagePaths.add(listFile[i].getAbsolutePath());
            }


            // this method will stores all the images
            // from the gallery in Cursor
            Cursor cursor = getContentResolver().query(MediaStore.Video.Media.getContentUri(MediaStore.VOLUME_EXTERNAL), null, MediaStore.Images.Media.DATA, null, null);

            // below line is to get total number of images
            int count = cursor.getCount();

            // on below line we are running a loop to add
            // the image file path in our array list.
//            for (int i = 0; i < listFile.length; i++) {
//
//                // on below line we are moving our cursor position
//                cursor.moveToPosition(i);
//
//                // on below line we are getting image file path
//                int dataColumnIndex = cursor.getColumnIndex(MediaStore.Images.Media.DATA);
//
//                // after that we are getting the image file path
//                // and adding that path in our array list.
//                imagePaths.add(cursor.getString(dataColumnIndex));
//            }
            imageRVAdapter = new GalleryViewAdapter(this, imagePaths);
            imageRVAdapter.notifyDataSetChanged();
            // after adding the data to our
            // array list we are closing our cursor.
            cursor.close();
        }
    }



}