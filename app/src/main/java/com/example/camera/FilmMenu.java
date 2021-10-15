package com.example.camera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.camera.filters.Filter;

import org.json.JSONException;
import org.json.JSONObject;

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

        fuji_c200Count.setText(countImage(  "fuji_c200") + " / 24");
        kodak_colorplus200Count.setText(countImage("kodak_colorplus200") + " / 24");
        kodak_proimage100Count.setText(countImage("kodak_proimage100") + " / 24");
    }

    public void choose_kodak_proimage100(View view) throws JSONException {
        JSONObject data = new JSONObject();
        data.put("symbol", "kodak_proimage100");
        data.put("filter", Filter.KODAK_PROIMAGE);
        data.put("count", countImage("kodak_proimage100"));
        data.put("name", getString(R.string.kodak_proimage100_name));
        data.put("path", Environment.getExternalStorageDirectory() + "/" + Environment.DIRECTORY_PICTURES + "/kodak_proimage100/");
        data.put("lab", Environment.getExternalStorageDirectory() + "/kodak_proimage100_negative");

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(EXTRA_MESSAGE, data.toString());
        startActivityForResult(intent, TEXT_REQUEST);
    }

    public void choose_kodak_colorplus200(View view) throws JSONException {
        JSONObject data = new JSONObject();
        data.put("symbol", "kodak_colorplus200");
        data.put("filter", Filter.KODAK_COLORPLUS);
        data.put("count", countImage("kodak_colorplus200"));
        data.put("name", getString(R.string.kodak_colorplus200_name));
        data.put("path", Environment.getExternalStorageDirectory() + "/" + Environment.DIRECTORY_PICTURES + "/kodak_colorplus200/");
        data.put("lab", Environment.getExternalStorageDirectory() + "/kodak_colorplus200_negative");

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(EXTRA_MESSAGE, data.toString());
        startActivityForResult(intent, TEXT_REQUEST);
    }

    public void choose_fuji_c200(View view) throws JSONException {
        JSONObject data = new JSONObject();
        data.put("symbol", "fuji_c200");
        data.put("filter", Filter.FUJI_C200);
        data.put("count", countImage(  "fuji_c200"));
        data.put("name", getString(R.string.fuji_c200_name));
        data.put("path", Environment.getExternalStorageDirectory() + "/" + Environment.DIRECTORY_PICTURES + "/fuji_c200/");
        data.put("lab", Environment.getExternalStorageDirectory() + "/fuji_c200_negative");

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(EXTRA_MESSAGE, data.toString());
        startActivityForResult(intent, TEXT_REQUEST);
    }

    public int countImage(String filmName) {
        Context context = getApplicationContext();
//        File dir = context.getDir(filmName, Context.MODE_PRIVATE);
        File dir = new File(Environment.getExternalStorageDirectory() + "/" + filmName + "_negative");
        File dir2 = new File(Environment.getExternalStorageDirectory() + "/" + Environment.DIRECTORY_PICTURES + "/" + filmName);
        if(!dir2.exists()) {
            dir2.mkdir();
        }
        if(!dir.exists()) {
            dir.mkdir();
            return 0;
        }
        else {
            return dir.listFiles().length;
        }
    }
}