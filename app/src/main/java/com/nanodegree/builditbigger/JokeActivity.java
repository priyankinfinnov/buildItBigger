package com.nanodegree.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.nanodegree.joketeller.JokeTellerActivity;
import com.nanodegree.joketeller.JokeTellerFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class JokeActivity extends AppCompatActivity implements JokeInterface {

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_joke, menu);
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
    public void renderJoke(String joke) {
        Intent i = new Intent(this, JokeTellerActivity.class);
        i.putExtra(JokeTellerFragment.KEY_JOKE, joke);
        startActivity(i);
    }

    @Override
    public void displayFailedMessage() {
        Toast.makeText(getApplicationContext(),getResources().getString(R.string.err_unable_to_get_joke),Toast.LENGTH_LONG).show();
    }



}
