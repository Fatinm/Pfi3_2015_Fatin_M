package k3.assignment4final;


import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link android.app.Fragment} subclass.
 */
public class FragmentDialog extends DialogFragment implements View.OnClickListener{



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialog, container, false);
               v.setOnClickListener(this);

        return v;
    }




    @Override
    public void onClick(View v) {
        FragmentDialog.this.dismiss();

    }

    public void addToBackStack(Object o) {
    }
}
