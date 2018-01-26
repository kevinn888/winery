package e.jesslyn.win_2.decode;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;


public class DecodeManager {

    public void showPermissionDeniedDialog(Context context) {
        new AlertDialog.Builder(context).setTitle(e.jesslyn.win_2.R.string.qr_code_notification)
                .setMessage(e.jesslyn.win_2.R.string.qr_code_camera_not_open)
                .setPositiveButton(e.jesslyn.win_2.R.string.qr_code_positive_button_know, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();
    }

    public void showResultDialog(Activity activity, String resultString, DialogInterface.OnClickListener listener) {
        new AlertDialog.Builder(activity).setTitle(e.jesslyn.win_2.R.string.qr_code_notification).setMessage(resultString)
                .setPositiveButton(e.jesslyn.win_2.R.string.qr_code_positive_button_confirm, listener).show();
    }

    public void showCouldNotReadQrCodeFromScanner(Context context, final OnRefreshCameraListener listener) {
        new AlertDialog.Builder(context).setTitle(e.jesslyn.win_2.R.string.qr_code_notification)
                .setMessage(e.jesslyn.win_2.R.string.qr_code_could_not_read_qr_code_from_scanner)
                .setPositiveButton(e.jesslyn.win_2.R.string.qc_code_close, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        if (listener != null) {
                            listener.refresh();
                        }
                    }
                }).show();
    }

    public void showCouldNotReadQrCodeFromPicture(Context context) {
        new AlertDialog.Builder(context).setTitle(e.jesslyn.win_2.R.string.qr_code_notification)
                .setMessage(e.jesslyn.win_2.R.string.qr_code_could_not_read_qr_code_from_picture)
                .setPositiveButton(e.jesslyn.win_2.R.string.qc_code_close, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();
    }

    public interface OnRefreshCameraListener {
        void refresh();
    }

}
