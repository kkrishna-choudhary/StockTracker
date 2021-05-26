package com.example.stocktracker;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {

    EditText searchInput;
    Button searchBtn;
    TextView searchResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchInput=findViewById(R.id.searchTerm);
        searchBtn=findViewById(R.id.searchbynameBtn);
        searchResult=findViewById(R.id.searchResult);


        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserDbHelper user=new UserDbHelper(SearchActivity.this);
                SQLiteDatabase db=user.getReadableDatabase();

                Cursor c=user.searchData(searchInput.getText().toString(),db);

                if (c.getCount()==0){
                    searchResult.setText("No user Found");
                }else{
                    StringBuffer sb=new StringBuffer();
                    c.moveToFirst();

                    do {
                        sb.append("Name: " + c.getString(0) + "\n");
                        sb.append("Model: " +c.getString(1)+"\n");
                        sb.append("Quantity: "+c.getString(2)+"\n");
                        sb.append("SellPrice: " + c.getString(3) + "\n");
                        sb.append("PurchasedFrom: " + c.getString(4) + "\n");
                        sb.append("CostPrice: " + c.getString(5) + "\n");

                    }while (c.moveToNext());

                    searchResult.setText(sb.toString());
                }
            }
        });
    }
}
