package e.jesslyn.win_2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jesslyn on 1/26/2018.
 */

public class VoucherFragment extends Fragment {

    private static final String TAG = "VoucherActivity";

    private TextView voucherText;
    private GridView voucherGrid;
    private Context mContext;
    private ImageView back;
    private ImageView settings;
    private int NUM_GRID_COLUMNS = 2;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_voucher, container,false);
        Log.d(TAG, "onCreateView:  Started");
        mContext = getActivity();

        voucherText = (TextView) view.findViewById(R.id.voucher_text);
        voucherGrid = (GridView) view.findViewById(R.id.gridview_voucher);
        back = (ImageView) view.findViewById(R.id.back_button_voucher);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, MenuUtama.class);
                startActivity(intent);
            }
        });

        settings = (ImageView) view.findViewById(R.id.settings);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, SettingsActivity.class);
                startActivity(intent);
            }
        });

        return view;

    }

    private void setupGrid(){

        //database photo voucher"


        //setup image grid
        int gridWidth = getResources().getDisplayMetrics().widthPixels;
        int imageWidth = gridWidth/NUM_GRID_COLUMNS;
        voucherGrid.setColumnWidth(imageWidth);
        ArrayList<String> imgUrl = new ArrayList<>();

        //looping ambil data voucher


        //gridview adapter



    }


}
