package com.hp.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn,btn2,btn3;
EditText e1,e2;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    btn=(Button)findViewById(R.id.button);
        btn2=(Button)findViewById(R.id.button2);
        btn3=(Button)findViewById(R.id.button3);
        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText2);

        pref=getSharedPreferences("jadu", Context.MODE_PRIVATE);
        editor=pref.edit();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=e1.getText().toString();
                String pass=e2.getText().toString();
                editor.putString("email_key",name);
                editor.putString("pass_key",pass);
                editor.commit();
                Toast.makeText(MainActivity.this, "Data saved", Toast.LENGTH_SHORT).show();
                e1.setText("");
                e2.setText("");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String key= pref.getString("email_key",null);
                String p=pref.getString("pass_key",null);
                Toast.makeText(MainActivity.this, "Email: "+key +" Password:" +p , Toast.LENGTH_SHORT).show();


            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //to remove a key use editor.clear(key name)
                editor.clear();
                editor.commit();
            }
        });



    }
}
