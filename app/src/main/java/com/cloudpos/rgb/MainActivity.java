package com.cloudpos.rgb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.cloudpos.DeviceException;
import com.cloudpos.POSTerminal;
import com.cloudpos.printer.PrinterDevice;
//import com.cloudpos.sdk.printer.html.PrinterHtmlListener;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    public Context mContext;

    private int startIndex;
    private int width;
    private int height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_land);
        setTitle("" + new Date());
        mContext = this;
    }

    public void showRed(View v) {
        setContentView(R.layout.redbg);
    }

    public void showBlue(View v) {
        setContentView(R.layout.bluebg);
    }

    public void showGreen(View v) {
        setContentView(R.layout.greenbg);
    }

    public void goBack(View v) {
        setContentView(R.layout.activity_main_land);
    }
}
