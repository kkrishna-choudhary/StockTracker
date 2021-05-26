package com.example.stocktracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertActivity extends AppCompatActivity {
    EditText nameInput,modelInput,quantityInput,tobesoldatInput,purchased_fromInput,purchased_rateInput;
    Button insertdetailsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);


        nameInput=findViewById(R.id.name);
        modelInput=findViewById(R.id.model);
        quantityInput=findViewById(R.id.quantity);
        tobesoldatInput=findViewById(R.id.to_be_sold_at);
        purchased_fromInput=findViewById(R.id.purchased_from);
        purchased_rateInput=findViewById(R.id.purchased_rate);
        insertdetailsBtn=findViewById(R.id.insertdetails);

        insertdetailsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserDbHelper user=new UserDbHelper(InsertActivity.this);

                SQLiteDatabase db=user.getWritableDatabase();

                user.insertData(nameInput.getText().toString(),modelInput.getText().toString(),quantityInput.getText().toString(),tobesoldatInput.getText().toString(),purchased_fromInput.getText().toString(),purchased_rateInput.getText().toString(),db);

                Toast.makeText(InsertActivity.this,"Insertion successful",Toast.LENGTH_LONG).show();
                Intent i= new Intent(InsertActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}
