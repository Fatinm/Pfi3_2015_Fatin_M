package k3.assignment_2;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment implements View.OnClickListener {


    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_blank, container, false);
        View myButtonView = v.findViewById(R.id.search_btn);
        myButtonView.setOnClickListener(this);
        return v;
    }


    @Override
    public void onClick(View v) {
        MainActivity a = (MainActivity) getActivity();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Fragment2 bf = new Fragment2();
        ft.replace(R.id.start_layout,bf);
        ft.commit();
    }
}