package e.jesslyn.win_2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Jesslyn on 1/17/2018.
 */

public class TransferSuccess extends AppCompatActivity {
    private static final String TAG = "transferAmount";
    private Context mContext;

    private ImageView back;
    private ImageView settings;
    private Button close;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_transfer_success);
        initWidgets();
        init();
    }

    private void initWidgets(){
        back = (ImageView) findViewById(R.id.back_button_success);
        settings = (ImageView) findViewById(R.id.settings);
        close = (Button) findViewById(R.id.closeButton);
        mContext = this;
    }

    private void init(){
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Onclick : back to transfer amount");
                Intent intent = new Intent(TransferSuccess.this,  transferAmount.class);
                startActivity(intent);
                finish();
            }
        });

       close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Log.d(TAG, "onClick: CLICKED");
                    Intent intent = new Intent(TransferSuccess.this, MenuUtama.class);
                    startActivity(intent);
                    finish();
            }
        });
    }


}
