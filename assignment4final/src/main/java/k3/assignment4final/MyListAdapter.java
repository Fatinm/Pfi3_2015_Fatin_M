package k3.assignment4final;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class MyListAdapter extends ArrayAdapter<Planet> {
    ArrayList<Planet> planetsList;
    Context c;

    public MyListAdapter(Context context, ArrayList<Planet> planetsList) {
        super(context, 0, planetsList);
        this.planetsList = planetsList;
        this.c = context;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.i("MyListAdapter", "Called for position: " + position);
        LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.list_item,null);
        Planet p = planetsList.get(position);
        TextView tv_title = (TextView) convertView.findViewById(R.id.tv_title);
        tv_title.setText(p.getTitle());
        ImageView iv = (ImageView) convertView.findViewById(R.id.iv_bookcover);
        iv.setImageDrawable(p.getImage());


        return convertView;
    }

    public void setAdapter(MyListAdapter myAdapter) {
    }
}
