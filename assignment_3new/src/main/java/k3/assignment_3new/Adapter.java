package k3.assignment_3new;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import k3.assignment_3new.skaneAPI.Journey;

import java.lang.Object;import java.lang.Override;import java.lang.String;import java.util.ArrayList;


public class Adapter extends BaseExpandableListAdapter {

    private ArrayList<Journey> j;
    private Context c;
    private String arrival;
    private String anyDeviation;

    public Adapter (Context c, ArrayList<Journey> j){
        this.j = j;
        this.c = c;
    }

    @Override
    public int getGroupCount(){
        return j.size();
    }

    @Override
    public int getChildrenCount(int groupPosition){
        return 1;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        LayoutInflater li = (LayoutInflater) this.c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = li.inflate(R.layout.list_collapsed, null);

        ImageView arrTime = (ImageView) convertView.findViewById(R.id.travelMinutes);
        if (j.get(groupPosition).getDepTimeDeviation() == "") {
            arrival = " ";
            anyDeviation = "";

        } else {
            anyDeviation = "Deviation: " + j.get(groupPosition).getDepTimeDeviation()+ " min \n\n";
        }


        TextView depTime = (TextView) convertView.findViewById(R.id.depTimeDev);


        String departure = j.get(groupPosition).getTimeToDeparture().toString() + " minutes";
        depTime.setText(departure);


        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        LayoutInflater li = (LayoutInflater) this.c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = li.inflate(R.layout.list_expanded,null);

        TextView arrTime = (TextView) convertView.findViewById(R.id.arrTime);
        String arrival = "Duration: " + j.get(groupPosition).getTravelMinutes().toString() + " min\n" + anyDeviation;
        arrTime.setText(arrival);

        TextView depTime = (TextView) convertView.findViewById(R.id.depTime);
        String departure = j.get(groupPosition).getLineOnFirstJourney().toString();
        depTime.setText(departure);

        return convertView;
    }


    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

}