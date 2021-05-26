package com.example.stocktracker;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ViewActivity extends AppCompatActivity {
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        result=findViewById(R.id.result);



        UserDbHelper user= new UserDbHelper(ViewActivity.this);
        SQLiteDatabase db=user.getReadableDatabase();

        Cursor c=user.viewData(db);
        if(c.getCount()>0){
            StringBuffer sb=new StringBuffer();
            c.moveToFirst();

            do {
                sb.append("Name: " + c.getString(0)+"\n");
                sb.append("Model: " + c.getString(1) +"\n");
                sb.append("Quantity: " + c.getString(2) + "\n");
                sb.append("SellPrice: " + c.getString(3) +"\n");
                sb.append("PurchasedFrom: " + c.getString(4) +"\n");
                sb.append("CostPrice: " + c.getString(5) +"\n -----------------    ----------------- \n");

            }while (c.moveToNext());
            result.setText(sb.toString());
        }else{
            result.setText("No Data Found");
        }
    }
}
