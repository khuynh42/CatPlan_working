package com.example.matri.catplan;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;



/**
 * Created by matri on 11/10/2017.
 */

public class SignUp extends Activity{

    dbHelper helper = new dbHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
    }

    public void onSignUpClick(View view)
    {
        if(view.getId() == R.id.buttonRegister)
        {
            EditText username = (EditText) findViewById(R.id.EditUser);
            EditText password = (EditText) findViewById(R.id.editPass);
            EditText repass = (EditText) findViewById(R.id.editRePass);

            String namestr = username.getText().toString();
            String passstr = password.getText().toString();
            String pass2str = repass.getText().toString();

            if(!passstr.equals(pass2str))
            {
                Toast pass = Toast.makeText(SignUp.this , "Password don't match!", Toast.LENGTH_SHORT);
                pass.show();
            }
            else
            {
                User u = new User();
                u.setUsername(namestr);
                u.setPassword(passstr);
                helper.insertUser(u);
            }
        }

    }
}
