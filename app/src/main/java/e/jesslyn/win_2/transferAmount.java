package e.jesslyn.win_2;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.ethanco.lib.PasswordDialog;
import com.ethanco.lib.PasswordInput;
import com.ethanco.lib.abs.ICheckPasswordFilter;
import com.ethanco.lib.abs.OnPositiveButtonListener;

/**
 * Created by Jesslyn on 1/17/2018.
 */

public class transferAmount extends AppCompatActivity {
    private static final String TAG = "transferAmount";

    private Context mContext;

    private ImageView back;
    private ImageView backDialog;
    private ImageView settings;
    private Button transfer;
    private EditText transAmount;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_transfer_amount);
        initWidgets();
        init();
    }

    private void initWidgets(){
        back = (ImageView) findViewById(R.id.back_button_transamount);
        settings = (ImageView)findViewById(R.id.settings);
        transfer = (Button) findViewById(R.id.buttonTransfer);
        transfer.setVisibility(View.GONE);
        transfer.setClickable(false);
        transAmount = (EditText) findViewById(R.id.text_amount);
        transAmount.setTransformationMethod(null);
        backDialog = (ImageView) findViewById(R.id.back_button_dialog_pin);
        mContext = this;
    }

    private void init(){
        transfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(transAmount.equals("")){
                    Toast.makeText(mContext, "Please Fill in Transfer Amount", Toast.LENGTH_SHORT).show();
                }else{
                    Log.d(TAG, "onClick: CLICKED");

//                    PinDialog pinDialog = new PinDialog(transferAmount.this);

                    AlertDialog.Builder pinAuth = new AlertDialog.Builder(transferAmount.this);
                    View mView = getLayoutInflater().inflate(R.layout.dialog_pin_confirmation,null);
                    final PasswordInput passwordInput = (PasswordInput) mView.findViewById(R.id.passwordInput_first);
                    Button transferDialog = (Button) mView.findViewById(R.id.transfer_button);
                    ImageView backDialog = (ImageView) mView.findViewById(R.id.back_button_dialog_pin);
                    pinAuth.setCancelable(false);
                    pinAuth.setView(mView);
                    backDialog.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(transferAmount.this, transferAmount.class);
                            startActivity(intent);
                        }
                    });

                    transferDialog.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(transferAmount.this,TransferSuccess.class);
                            startActivity(intent);
                            String pass = passwordInput.getText().toString();
                            Log.d(TAG, "onClick: *****************************" + pass);
                            finish();
                        }
                    });

                    // Show the AlertDialog.
                    pinAuth.show();

                    Log.d(TAG, "onClick: testing");
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Onclick : back to MenuUtama");
                Intent intent = new Intent(transferAmount.this,  PilihBank.class);
                startActivity(intent);
            }
        });


        transAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!transAmount.getText().toString().trim().equals("")){
                    transfer.setVisibility(View.VISIBLE);
                    transfer.setClickable(true);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (transAmount.getText().toString().trim().equals("")) {
                    transfer.setVisibility(View.GONE);
                }
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(transferAmount.this, SettingsActivity.class);
                startActivity(intent);
            }
        });
    }


}
