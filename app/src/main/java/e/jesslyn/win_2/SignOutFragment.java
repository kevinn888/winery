package e.jesslyn.win_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Jesslyn on 1/24/2018.
 */

public class SignOutFragment extends Fragment {

    private static final String TAG = "SignOutFragment";
    private TextView signout_text;
    private Button signout_button;
    private ImageView back_signout;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_signout, container,false);
        signout_text = (TextView) view.findViewById(R.id.signout_text);
        signout_button = (Button) view.findViewById(R.id.signout_button);
        back_signout = (ImageView) view.findViewById(R.id.back_button_signout);

        signout_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: SIGNOUT clicked");
                Intent intent = new Intent(getActivity(), MainActivity.class);
            }
        });

        back_signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });

        return view;

    }
}
