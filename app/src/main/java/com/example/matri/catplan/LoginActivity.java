package com.example.matri.catplan;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;


public class LoginActivity extends AppCompatActivity {

    dbHelper helper = new dbHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onButtonClick(View view) {

        if (view.getId() == R.id.login_SignIn) {
            EditText a = (EditText) findViewById((R.id.editTextUser));
            String user = a.getText().toString();
            EditText b = (EditText) findViewById(R.id.editTextPass);
            String pass = b.getText().toString();

            String password = helper.searchPass(user);
            if (pass.equals(password)) {
                Intent i = new Intent(LoginActivity.this, MainMenu.class);
                i.putExtra("Username", user);
                startActivity(i);
            } else {
                Toast temp = Toast.makeText(LoginActivity.this, "Username and password are incorrect", Toast.LENGTH_SHORT);
                temp.show();
            }
        }
        if (view.getId() == R.id.login_Register) {
            Intent i = new Intent(LoginActivity.this, SignUp.class);
            startActivity(i);
        }

    }


}

