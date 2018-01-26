package e.jesslyn.win_2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

/**
 * Created by Jesslyn on 1/17/2018.
 */

public class PilihBank extends AppCompatActivity{
    private static final String TAG = "PilihBank";
    private Context mContext;
    private ImageView back;
    private ImageView settings;
    private Spinner banks;
    private Button confirm;


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_center_transfer);
        initWidgets();
        init();
    }

    private void init(){
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Onclick : back to MenuUtama");
                Intent intent = new Intent(PilihBank.this,  MenuUtama.class);
                startActivity(intent);
            }
        });

        banks.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Object item = adapterView.getItemAtPosition(i);
                Log.d(TAG, "**************************onItemSelected: " + item.toString());
                if(!item.toString().equals("")){
                    confirm.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent2 = new Intent(PilihBank.this, transferAmount.class );
            startActivity(intent2);
            Log.d(TAG, "onClick: **************Clicked");
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PilihBank.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

    }

    private void initWidgets(){
        banks = (Spinner) findViewById(R.id.spinnerbank);
        back = (ImageView) findViewById(R.id.back_button_trans);
        settings = (ImageView) findViewById(R.id.settings);
        confirm = (Button) findViewById(R.id.buttonConfirm);
        confirm.setVisibility(View.GONE);
    }


}
