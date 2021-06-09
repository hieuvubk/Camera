package com.example.camera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.File;

public class FilmMenu extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    // Unique tag required for the intent extra
    public static final String EXTRA_MESSAGE
            = "com.example.android.twoactivities.extra.MESSAGE";
    public static final int TEXT_REQUEST = 1;

    private TextView fuji_c200Count;
    private TextView kodak_colorplus200Count;
    private TextView kodak_proimage100Count;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_menu);

        fuji_c200Count = findViewById(R.id.fuji_c200_count);
        kodak_colorplus200Count = findViewById(R.id.kodak_colorplus200_count);
        kodak_proimage100Count = findViewById(R.id.kodak_proimage100_count);

        fuji_c200Count.setText(countImage("fuji_c200") + " / 24");
        kodak_colorplus200Count.setText(countImage("kodak_colorplus200") + " / 24");
        kodak_proimage100Count.setText(countImage("kodak_proimage100") + " / 24");
    }

    public void choose_kodak_proimage100(View view) {

        Log.d(LOG_TAG, "Choose " + getString(R.string.kodak_proimage100_name) );
        Intent intent = new Intent(this, MainActivity.class);
        String message = getString(R.string.kodak_proimage100_name);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    public void choose_kodak_colorplus200(View view) {
        Log.d(LOG_TAG, "Choose " + getString(R.string.kodak_colorplus200_name) );
        Intent intent = new Intent(this, MainActivity.class);
        String message = getString(R.string.kodak_colorplus200_name);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    public void choose_fuji_c200(View view) {
        Log.d(LOG_TAG, "Choose " + getString(R.string.fuji_c200_name) );
        Intent intent = new Intent(this, MainActivity.class);
        String message = getString(R.string.fuji_c200_name);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    public int countImage(String filmName) {
        Context context = getApplicationContext();
        File dir = context.getDir(filmName, Context.MODE_PRIVATE);
        if(!dir.exists()) {
            dir.mkdir();
            return 0;
        }
        else {
            return dir.listFiles().length;
        }
    }
}