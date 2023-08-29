package com.example.apnarestaurantmanagementapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ManagerPanel extends AppCompatActivity {
Button btnMgrPOSAdd1,btnMgrExpDetails1,btnMgrWorkerSignup1;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_panel);
        btnMgrWorkerSignup1=findViewById(R.id.btnMgrWorkerSignup);
        btnMgrPOSAdd1=findViewById(R.id.btnMgrPOSAdd);
        btnMgrExpDetails1=findViewById(R.id.btnMgrExpDetails);
        btnMgrWorkerSignup1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
//navigate to worker registration
                Intent intent = new Intent(ManagerPanel.this, WorkerRegistration.class);
                startActivity(intent);
            }
        });
        btnMgrPOSAdd1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(ManagerPanel.this, AddPOS.class);
                startActivity(intent);
            }
        });
        btnMgrExpDetails1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(ManagerPanel.this, ExpenseList.class);
                startActivity(intent);
            }
        });

    }
}