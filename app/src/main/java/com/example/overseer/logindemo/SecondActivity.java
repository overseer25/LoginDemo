package com.example.overseer.logindemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.sql.*;

public class SecondActivity extends AppCompatActivity {

    private TextView info;
    private String username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        username = getIntent().getStringExtra("USERNAME");
        password = getIntent().getStringExtra("PASSWORD");
        info = (TextView)findViewById(R.id.tvInfo);
        connectToDatabase();
    }

    private void connectToDatabase()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.0.61:3306/myschema?autoReconnect=true&useSSL=false", username, password);

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM patients");

            conn.close();

            info.setText("Successfully connected to database!");
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
            info.setText(username + " failed to connect to database :(");
        }
        catch(SQLException e)
        {
            e.printStackTrace();;
            info.setText(username + " failed to connect to database :(");
        }

    }
}
