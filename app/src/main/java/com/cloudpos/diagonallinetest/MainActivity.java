package com.cloudpos.diagonallinetest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Toast;

import com.cloudpos.DeviceException;
import com.cloudpos.POSTerminal;
import com.cloudpos.cashdrawer.CashDrawerDevice;
import com.cloudpos.diagonallinetest.R;
import com.cloudpos.printer.Format;
import com.cloudpos.printer.PrinterDevice;
import com.cloudpos.printer.PrinterHtmlListener;
//import com.cloudpos.sdk.printer.html.PrinterHtmlListener;
import com.orhanobut.logger.Logger;
import com.cloudpos.diagonallinetest.util.PrintTagForQ1;
import com.cloudpos.diagonallinetest.util.PrinterCommand;
import com.cloudpos.diagonallinetest.util.PurchaseBillForQ1Entity;

import java.io.IOException;
import java.util.Date;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    PrinterDevice device = null;

    public Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_land);
        setTitle("" + new Date());
        mContext = this;
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            Toast.makeText(MainActivity.this, (String) msg.obj, Toast.LENGTH_SHORT).show();

        }
    };

    public void initPrinter(View v) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                device = (PrinterDevice) POSTerminal.getInstance(mContext).getDevice("cloudpos.device.printer");
                try {
                    device.open();
                    handler.obtainMessage(1, "printer already opened").sendToTarget();
                } catch (Exception e) {
                    handler.obtainMessage(1, "printer open exception  ...").sendToTarget();
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void printerPrint(View v) {
        try {
            if (device == null) {
                Toast.makeText(MainActivity.this, "please open printer", Toast.LENGTH_SHORT).show();
                return;
            }
            device.printText(device.getDefaultParameters(), " -------------------------------------------------------" +
                    "In the spring of 2012, a group of payment industry veterans from payment, mobile communication,\n" +
                    "and security industries got together. Their expertise and accomplishments in the past 20+ years are\n\n\n\n\n\n");
            device.printText("\n");
            device.printText("\n");
            device.printText("\n");
            device.printText("In the spring of 2012, a group of payment industry veterans from payment, mobile communication,\n" +
                    "and security industries got together. Their expertise and accomplishments in the past 20+ years are。++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n\n\n\n");
            device.printText("\n");
            device.printText("\n");
            device.printText("\n");
            device.cutPaper();
        } catch (DeviceException e) {
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    public void printImg(View v) {
        try {
            if (device == null) {
                Toast.makeText(MainActivity.this, "please open printer", Toast.LENGTH_SHORT).show();
                return;
            }
//            PrintHelper photoPrinter = new PrintHelper((Context) device);
//            photoPrinter.setScaleMode(PrintHelper.SCALE_MODE_FIT);

            Bitmap bitmap = BitmapFactory.decodeStream(mContext.getResources().getAssets().open("diagonal lines.png"));
            device.printBitmap(bitmap);
            bitmap.recycle();
            device.printText("\n");
            device.printText("\n");
            device.printText("\n");
            device.printText("printBitmap end.");
            device.cutPaper();
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
        //   D3usbPrinter.writePort(new byte[]{29, 86, 0}, 3);
    }

    public void closePrinter(View view) {
        try {
            if (device == null) {
                Toast.makeText(MainActivity.this, "please open printer", Toast.LENGTH_SHORT).show();
                return;
            }
            device.close();
            device = null;
            Toast.makeText(MainActivity.this, "printer already closed", Toast.LENGTH_SHORT).show();
        } catch (DeviceException e) {
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    public String parsePrinterStatus2Description(int priterStatus) {
        switch (priterStatus) {
            case 0:
                return "0: normal";
            case 1:
                return "1: Data transmission error, please check connection or resend";
            case 2:
                return "2: Less paper";
            case 3:
                return "3: Missing paper";
            case 4:
                return "4: Error occurred";
            case 5:
                return "5: Open the cover";
            case 6:
                return "6: Offline";
            case 7:
                return "7: Feeding";
            case 8:
                return "8: Mechanical error";
            case 9:
                return "9: Automatically recoverable error";
            case 10:
                return "10: Unrecoverable error";
            case 11:
                return "11: Print head overheating";
            case 12:
                return "12: Cutter not reset";
            case 13:
                return "13: Black mark error";
            default:
                return "printer status code is not defined = " + priterStatus;
        }
    }
}
