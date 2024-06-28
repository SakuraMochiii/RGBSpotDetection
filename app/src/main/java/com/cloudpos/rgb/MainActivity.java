package com.cloudpos.rgb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import com.chaquo.python.PyObject;
import com.chaquo.python.android.AndroidPlatform;
import com.chaquo.python.Python;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main_land);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        mContext = this;

        if (! Python.isStarted()) {
            Python.start(new AndroidPlatform(this));
        }
        try {
            Bitmap bitmap = BitmapFactory.decodeStream(mContext.getResources().getAssets().open("red_test.jpg"));
            detect(bitmap);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void dotsRed(View v) {drawDots(Color.RED);}
    public void dotsBlue(View v) {drawDots(Color.CYAN);}
    public void dotsGreen(View v) {drawDots(Color.GREEN);}

    public void drawDots(int color) {
        ConstraintLayout constraintLayout = new ConstraintLayout(this);

        constraintLayout.setBackgroundColor(color);

        Random rand = new Random();
        int max = rand.nextInt(10) + 1;
        int width = Resources.getSystem().getDisplayMetrics().widthPixels;
        int height = Resources.getSystem().getDisplayMetrics().heightPixels;
//        Log.d("num dots", String.valueOf(max));
        for (int i = 0; i < max; i++) {
            ImageView img = new ImageView(this);
            img.setImageResource(R.drawable.dot);
            img.setAdjustViewBounds(true);
            img.setLayoutParams(new ViewGroup.LayoutParams(10,10));
            img.setX(rand.nextInt(width - 50));
            img.setY(rand.nextInt(height - 400));
            constraintLayout.addView(img);
        }

//        Button home = new Button(this);
//        home.setText("return");
//        home.setY(height - 320);
//        home.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                setContentView(R.layout.activity_main_land);
//            }
//        });
//        constraintLayout.addView(home);
//
//        Button findDots = new Button(this);
//        findDots.setText("detect");
//        findDots.setX(200);
//        findDots.setY(height - 320);
//        findDots.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                SaveImage(screenShot(constraintLayout));
//                Log.d("NUM SPOTS DETECTED", detect("ss.jpg"));
//                //SAVE ERROR, NEED FIGURE OUT HOW TO EITHER INPUT BITMAP INTO IMWRITE/OPENCV OR SAVE BITMAP AS AN IMAGE
//            }
//        });
//        constraintLayout.addView(findDots);

        setContentView(constraintLayout);
    }
//    public Bitmap screenShot(View view) {
//        Bitmap bitmap = Bitmap.createBitmap(view.getWidth(),
//                view.getHeight() - 320, Bitmap.Config.ARGB_8888);
//        Canvas canvas = new Canvas(bitmap);
//        view.draw(canvas);
//        return bitmap;
//    }

//    private static void SaveImage(Bitmap finalBitmap) {
//
//        String root = Environment.getExternalStorageDirectory().getAbsolutePath();
//        File myDir = new File(root + "/output");
//        myDir.mkdirs();
//
//        String fname = "ss.jpg";
//        File file = new File (myDir, fname);
//        if (file.exists ()) file.delete ();
//        try {
//            FileOutputStream out = new FileOutputStream(file);
//            finalBitmap.compress(Bitmap.CompressFormat.JPEG, 90, out);
//            out.flush();
//            out.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public String detect(Bitmap bitmap) {
        Python py = Python.getInstance();
        PyObject spots = py.getModule("spotDetection");
        return spots.callAttr("detect", bitmap).toString();
    }
}
