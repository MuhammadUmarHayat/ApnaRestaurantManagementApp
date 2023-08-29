package com.example.apnarestaurantmanagementapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class AddPOS extends AppCompatActivity
{
    RecyclerView recyclerView;
    ArrayList<String> id,name,unit,sku,salePrice,qty;
    MyDatabase db;
   // InstituteAdapter adapter;
    ProductAdapter adapter;

    List<ImageModel> imageList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pos);
        recyclerView=findViewById(R.id.rcPOSDetails);
        db=new MyDatabase(this);
        id=new ArrayList<>();
                name=new ArrayList<>();
        unit=new ArrayList<>();
                sku=new ArrayList<>();
        salePrice=new ArrayList<>();
                qty=new ArrayList<>();
                imageList=new ArrayList<>();
                adapter=new ProductAdapter(this,id,name,unit,sku,salePrice,qty,imageList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayData();

    }

    private void displayData()
    {
        //  Cursor cursor = db.getTableData("institutes", "manager", manager);

        Cursor cursor = db.getAllData("products");
        if (cursor.getCount() == 0)
        {

        }
        else
        {
            while (cursor.moveToNext())
            {
                //String 1 name, String 2 medium, String 3 address, String 4 city, 5String link
                id.add(cursor.getString(0));
                name.add(cursor.getString(1));
                id.add(cursor.getString(0));
                name.add(cursor.getString(1));
                unit.add(cursor.getString(7));

                sku.add(cursor.getString(5));
                salePrice.add(cursor.getString(9));
                qty.add(cursor.getString(10));


                byte[] imageBytes = cursor.getBlob(11);
                Bitmap bitmap = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
                imageList.add(new ImageModel(bitmap));

            }
        }//else
    }
}
