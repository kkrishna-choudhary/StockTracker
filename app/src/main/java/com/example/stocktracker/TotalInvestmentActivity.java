package com.example.stocktracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class TotalInvestmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_investment);

        Toast.makeText(TotalInvestmentActivity.this,"You entered in TotalInvestment Activity",Toast.LENGTH_SHORT).show();
    }
}
