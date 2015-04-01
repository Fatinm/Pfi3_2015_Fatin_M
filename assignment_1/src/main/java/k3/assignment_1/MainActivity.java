package k3.assignment_1;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;



public class MainActivity extends ActionBarActivity {
    Random random = new Random();
    int i = 0;
    private Button mButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Part 4 of the assignment - LogCat
        Log.i("App 1 - Assignment 1","App started");
        setContentView(R.layout.activity_main);

        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(onClick());
    }

    private View.OnClickListener onClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("App 1 - Assignment 1", "Button pressed");
                String[] qQuotes = getResources().getStringArray(R.array.quotes_array);
                TextView tv1 = (TextView) findViewById(R.id.textView);

                i = random.nextInt(5);
                tv1.setText(qQuotes[i]);
            }
        };
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

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        Log.i("App 1 - Assignment 1:", "App has been paused");
        super.onPause();

    }

    @Override
    protected void onDestroy(){
        Log.i("App 1 - Assignment 1:", "App has been closed");
        super.onDestroy();
    }

    @Override
    protected void onResume(){
        Log.i("App 1 - Assignment 1:", "App has resumed");
        super.onResume();
    }
}
