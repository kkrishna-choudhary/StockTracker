package com.example.stocktracker;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button viewbtn,searchbtn,deletebtn,updatebtn,insertbtn,totalinvestmentbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewbtn =(Button) findViewById(R.id.view);
        searchbtn =(Button) findViewById(R.id.search);
        deletebtn =(Button) findViewById(R.id.delete);
        updatebtn =(Button) findViewById(R.id.update);
        insertbtn =(Button) findViewById(R.id.insert);
        totalinvestmentbtn =(Button) findViewById(R.id.totalinvest);

        viewbtn.setOnClickListener(this);
        searchbtn.setOnClickListener(this);
        deletebtn.setOnClickListener(this);
        updatebtn.setOnClickListener(this);
        insertbtn.setOnClickListener(this);
        totalinvestmentbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.view:
                Intent i=new Intent(MainActivity.this,ViewActivity.class);
                startActivity(i);

                break;
            case R.id.search:
                Intent j=new Intent(MainActivity.this,SearchActivity.class);
                startActivity(j);

                break;
            case R.id.delete:
                Intent k=new Intent(MainActivity.this,DeleteActivity.class);
                startActivity(k);

                break;
            case R.id.update:
                Intent l=new Intent(MainActivity.this,UpdateActivity.class);
                startActivity(l);

                break;
            case R.id.insert:
                Intent m=new Intent(MainActivity.this,InsertActivity.class);
                startActivity(m);

                break;
            case R.id.totalinvest:
                Intent n=new Intent(MainActivity.this,TotalInvestmentActivity.class);
                startActivity(n);

                break;
        }
    }


}
