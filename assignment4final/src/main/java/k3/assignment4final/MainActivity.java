package k3.assignment4final;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.main_layout,new FragmentList());
        ft.commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if (id == R.id.action_spinner) {
            FragmentManager fm = getFragmentManager();
            FragmentDialog fd = new FragmentDialog();
            Bundle b = new Bundle();
            fd.setArguments(b);
            fd.addToBackStack(null);
            fd.show(fm,"Dialog");


            return false;
        }

        return super.onOptionsItemSelected(item);
    }
    public void onBackPressed(){
        if(getFragmentManager().getBackStackEntryCount() >0) {
            getFragmentManager().popBackStack();
        }else{
            super.onBackPressed();
        }
    }
}