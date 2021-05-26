package com.example.stocktracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {
    EditText et1,et2,et3,et4,et5,et6;
    Button updateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        Toast.makeText(UpdateActivity.this,"You entered in Update Activity",Toast.LENGTH_SHORT).show();

        et1=findViewById(R.id.update_by_name);
        et2=findViewById(R.id.updatemodel);
        et3=findViewById(R.id.updatequantity);
        et4=findViewById(R.id.updateto_be_sold_at);
        et5=findViewById(R.id.updatepurchased_from);
        et6=findViewById(R.id.updatepurchased_rate);
        updateBtn=findViewById(R.id.updatedetails);

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserDbHelper user=new UserDbHelper(UpdateActivity.this);
                SQLiteDatabase db=user.getWritableDatabase();

                int num_rows=user.updateData(et1.getText().toString(),et2.getText().toString(),et3.getText().toString(),et4.getText().toString(),et5.getText().toString(),et6.getText().toString(),db);

                if (num_rows==0) {
                    Toast.makeText(UpdateActivity.this,"row not updated",Toast.LENGTH_LONG).show();

                }else {

                    Toast.makeText(UpdateActivity.this, "Row updated", Toast.LENGTH_LONG).show();
                    Intent i=new Intent(UpdateActivity.this,MainActivity.class);
                    startActivity(i);
                }
            }
        });
    }
}
