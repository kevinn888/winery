package e.jesslyn.win_2;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Jesslyn on 1/16/2018.
 */

public class MenuUtama extends AppCompatActivity {
    private static final String TAG = "MenuUtama";
    private Context mContext;
    private static final int REQUEST_CODE_QR_SCAN = 101;

    private ImageView back;
    private ImageView settings;
    private ImageView topup;
    private ImageView transfer;
    private ImageView voucher;
    private ImageView scan;
    private long lastTouchDown;
    private static int CLICK_ACTION_THRESHHOLD = 200;


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_center_balance);
        mContext = MenuUtama.this;
        ActivityCompat.requestPermissions(MenuUtama.this, new String[]{Manifest.permission.CAMERA,Manifest.permission.READ_EXTERNAL_STORAGE},101);
        initWidgets();
        init();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(resultCode != Activity.RESULT_OK)
        {
            Log.d(TAG,"COULD NOT GET A GOOD RESULT.");
            if(data==null)
                return;
            //Getting the passed result
            String result = data.getStringExtra("e.jesslyn.win_2.error_decoding_image");
            if( result!=null)
            {
                AlertDialog alertDialog = new AlertDialog.Builder(MenuUtama.this).create();
                alertDialog.setTitle("Scan Error");
                alertDialog.setMessage("QR Code could not be scanned");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
            }
            return;

        }
        if(requestCode == REQUEST_CODE_QR_SCAN)
        {
            if(data==null)
                return;
            //Getting the passed result
            String result = data.getStringExtra("e.jesslyn.win_2.got_qr_scan_relult");
            Log.d(TAG,"Have scan result in your app activity :"+ result);
            AlertDialog alertDialog = new AlertDialog.Builder(MenuUtama.this).create();
            alertDialog.setTitle("Scan result");
            alertDialog.setMessage(result);
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();

        }
    }


    private void init() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Onclick : back to MainActivity");
                Intent intent = new Intent(MenuUtama.this, MainActivity.class);
                startActivity(intent);
            }
        });


        transfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transfer.setImageResource(R.mipmap.ic_transfer_click);
                Intent intent2 = new Intent(MenuUtama.this, PilihBank.class);
                startActivity(intent2);
            }
        });

        transfer.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        lastTouchDown = System.currentTimeMillis();
                        transfer.setImageResource(R.mipmap.ic_transfer_click);
                        break;
                    case MotionEvent.ACTION_UP:
                        transfer.setImageResource(R.mipmap.ic_transfer);
                        if (System.currentTimeMillis() - lastTouchDown < CLICK_ACTION_THRESHHOLD) {
                            Log.w("App", "You clicked!");
                            transfer.setImageResource(R.mipmap.ic_transfer);
                            Intent intent2 = new Intent(MenuUtama.this, PilihBank.class);
                            startActivity(intent2);
                        }
                        break;
                }
                return true;
            }
        });

        scan.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //transfer.setImageResource(R.mipmap.ic_transfer_click);
                int camera = ContextCompat.checkSelfPermission(MenuUtama.this,Manifest.permission.CAMERA);
                int exStorage = ContextCompat.checkSelfPermission(MenuUtama.this,Manifest.permission.READ_EXTERNAL_STORAGE);
                if(camera == PackageManager.PERMISSION_GRANTED
                        || exStorage == PackageManager.PERMISSION_GRANTED){
                    Intent i = new Intent(MenuUtama.this,QrCodeActivity.class);
                    startActivityForResult( i,REQUEST_CODE_QR_SCAN);
                }else{
                    ActivityCompat.requestPermissions(MenuUtama.this, new String[]{Manifest.permission.CAMERA,Manifest.permission.READ_EXTERNAL_STORAGE},101);
                }
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuUtama.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

    }

    private void initWidgets(){
        back = (ImageView) findViewById(R.id.back_button);
        settings = (ImageView) findViewById(R.id.settings);
        topup = (ImageView) findViewById(R.id.topup);
        transfer = (ImageView) findViewById(R.id.transfer);
        voucher = (ImageView) findViewById(R.id.voucher);
        scan = (ImageView) findViewById(R.id.scanqr);
    }


}
