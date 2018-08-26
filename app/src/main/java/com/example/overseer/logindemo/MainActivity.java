package com.example.overseer.logindemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private EditText name;
    private EditText pwd;
    private TextView info;
    private Button login;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText)findViewById(R.id.etName);
        pwd = (EditText)findViewById(R.id.etPassword);
        info = (TextView)findViewById(R.id.tvInfo);
        login = (Button)findViewById(R.id.btnLogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(name.getText().toString(), pwd.getText().toString());
            }
        });
    }


    private void validate(String username, String password)
    {
        if(username.equalsIgnoreCase("john") && password.equals("admin"))
        {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class); // Intent is used to move from one activity to another.
            intent.putExtra("USERNAME", username.toLowerCase()); // Send data between activities
            intent.putExtra("PASSWORD", password);
            startActivity(intent);
            counter = 5;
        }
        else
        {
            counter--;

            info.setText("Attempts remaining: " + counter);
            if(counter == 0)
            {
                login.setEnabled(false);
            }
        }
    }

}
