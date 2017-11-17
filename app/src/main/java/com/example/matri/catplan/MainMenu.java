package com.example.matri.catplan;

/**
 * Created by matri on 11/16/2017.
 */

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;

public class MainMenu extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }


    public void onButtonClick(View view) {

        //Scheduler
        if (view.getId() == R.id.button3) {
            Intent i = new Intent(MainMenu.this, AddCourses.class);
            startActivity(i);
        }
        //View Catalog
        else if(view.getId() == R.id.button5) {
            Intent i = new Intent(MainMenu.this, Catalog.class);
            startActivity(i);
        }
        //View Favorites
        else if(view.getId() == R.id.button9) {
            Intent i = new Intent(MainMenu.this, Favourites.class);
            startActivity(i);
        }
        //Log Out
        else if (view.getId() == R.id.button10){
            Intent i = new Intent(MainMenu.this, LoginActivity.class);
            startActivity(i);
        }

        }


}

