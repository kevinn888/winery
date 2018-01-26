package e.jesslyn.win_2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.ethanco.lib.PasswordInput;
import com.ethanco.lib.abs.ICheckPasswordFilter;

import static android.content.ContentValues.TAG;

/**
 * Created by kevin nathaniel on 1/18/2018.
 */

public class PinDialog extends View{

    public PinDialog(final Context context) {
        super(context);
//        AlertDialog.Builder pinAuth = new AlertDialog.Builder(getContext());
//        pinAuth.setView(R.layout.dialog_pin_confirmation);
//        PasswordInput passwordInput = (PasswordInput) findViewById(R.id.passwordInput_first);
//        Button transfer = (Button) findViewById(R.id.transfer_button);
//        ImageView backDialog = (ImageView) findViewById(R.id.back_button_dialog_pin);
//        pinAuth.setCancelable(false);
//        final Context finalContext = context;

//        backDialog.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(context,transferAmount.class);
//                finalContext.startActivity(intent);
//            }
//        });

//       transfer.setOnClickListener(new OnClickListener() {
//           @Override
//           public void onClick(View view) {
//               Intent intent = new Intent(context,TransferSuccess.class);
//               finalContext.startActivity(intent);
//           }
//       });

//        pinAuth.show();

        Log.d(TAG, "onClick: testing");
    }

    public class CountCheckFilter implements ICheckPasswordFilter {
        @Override
        public boolean onCheckPassword(Context context, CharSequence password) {
            if (password.length() != 4) {
                Toast.makeText(context, "Please complete your password", Toast.LENGTH_SHORT).show();
                return false;
            }
            return true;
        }
    }



}
