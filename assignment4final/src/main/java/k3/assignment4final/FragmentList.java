package k3.assignment4final;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;


/**
 * A simple {@link android.app.Fragment} subclass.
 */
public class FragmentList extends Fragment {
   public static ArrayList<Planet> planets = new ArrayList<Planet>();

    //This method comes first so lets create the books here
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        planets.clear();
        Drawable d = getResources().getDrawable(R.drawable.mercury);
        String s = getResources().getString(R.string.mercury_summary);
        String t = getResources().getString(R.string.mercury_temp);
        String r = getResources().getString(R.string.mercury_radius);
        planets.add(new Planet("Mercury",r,t,d,s));

        d = getResources().getDrawable(R.drawable.venus);
        s = getResources().getString(R.string.venus_summary);
        t = getResources().getString(R.string.venus_temp);
        r = getResources().getString(R.string.venus_radius);
        planets.add(new Planet("Venus",r,t,d,s));

        d = getResources().getDrawable(R.drawable.earth);
        s = getResources().getString(R.string.earth_summary);
        t = getResources().getString(R.string.earth_temp);
        r = getResources().getString(R.string.earth_radius);
        planets.add(new Planet("Earth",r,t,d,s));

        d = getResources().getDrawable(R.drawable.mars);
        s = getResources().getString(R.string.mars_summary);
        t = getResources().getString(R.string.mars_temp);
        r = getResources().getString(R.string.mars_radius);

        planets.add(new Planet("Mars",r,t,d,s));

        d = getResources().getDrawable(R.drawable.jupiter);
        s = getResources().getString(R.string.jupiter_summary);
        t = getResources().getString(R.string.jupiter_temp);
        r = getResources().getString(R.string.jupiter_radius);
        planets.add(new Planet("Jupiter",r,t,d,s));

        d = getResources().getDrawable(R.drawable.saturn);
        s = getResources().getString(R.string.saturn_summary);
        t = getResources().getString(R.string.saturn_temp);
        r = getResources().getString(R.string.saturn_radius);

        planets.add(new Planet("Saturn",r,t,d,s));

        d = getResources().getDrawable(R.drawable.uranus);
        s = getResources().getString(R.string.uranus_summary);
        t = getResources().getString(R.string.uranus_temp);
        r = getResources().getString(R.string.uranus_radius);
        planets.add(new Planet("Uranus",r,t,d,s));

        d = getResources().getDrawable(R.drawable.neptune);
        s = getResources().getString(R.string.neptune_summary);
        t = getResources().getString(R.string.neptune_temp);
        r = getResources().getString(R.string.neptune_radius);

        planets.add(new Planet("Neptune",r,t,d,s));


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.grid, container, false);
        Log.i("FragmentWithList","NumberOfBooks: " + planets.size());
        MyListAdapter la = new MyListAdapter(getActivity(),planets);
        GridView lv = (GridView) v.findViewById(R.id.gridView);
        lv.setAdapter(la);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("FragmentWithList", "Clicked on position: " + position);

                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();

                FragmentInfo fragmentInfo = new FragmentInfo();
                Bundle b = new Bundle();
                b.putSerializable("planet", planets.get(position));
                fragmentInfo.setArguments(b);

                ft.replace(R.id.grid_layout, fragmentInfo);

                ft.addToBackStack(null);
                ft.commit();
            }
        });
        return v;
    }


}
