package com.example.stocktracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteActivity extends AppCompatActivity {
    EditText et1;
    Button deletebynameBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        et1=findViewById(R.id.deleteName);
        deletebynameBtn=findViewById(R.id.deletebyname);

        deletebynameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserDbHelper user=new UserDbHelper(DeleteActivity.this);
                SQLiteDatabase db=user.getWritableDatabase();

                int num_rows=user.deleteData(et1.getText().toString(),db);

                if (num_rows==0){
                    Toast.makeText(DeleteActivity.this,"Not deleted",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(DeleteActivity.this,"deleted",Toast.LENGTH_LONG).show();
                    Intent i=new Intent(DeleteActivity.this,MainActivity.class);
                    startActivity(i);
                }

            }
        });
    }
}
