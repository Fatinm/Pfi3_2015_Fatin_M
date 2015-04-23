package k3.assignment4final;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class FragmentInfo extends Fragment  {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_info, container, false);
        Planet p = (Planet) getArguments().getSerializable("planet");

        TextView tv_title = (TextView) v.findViewById(R.id.tv_dialog_title);
        ImageView iv = (ImageView) v.findViewById(R.id.iv_dialog);
        TextView tv_temp = (TextView) v.findViewById(R.id.tv_dialog_temp);
        TextView tv_description = (TextView) v.findViewById(R.id.tv_dialog_description);
        TextView tv_radius = (TextView) v.findViewById(R.id.tv_dialog_r);


        tv_title.setText(p.getTitle());
        tv_temp.setText("Temp: " + p.getTemp());
        tv_radius.setText("Radius: " + p.getRadius());
        tv_description.setText(p.getSummary());
        iv.setImageDrawable(p.getImage());

        return v;

    }


}
