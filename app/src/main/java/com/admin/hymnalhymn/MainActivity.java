package com.admin.hymnalhymn;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.sql.SQLException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    private DatabaseHelper dbHelper;
    Adapter adapter;
    ArrayList<Item> arrayList=new ArrayList<Item>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DatabaseHelper(this);
        try{
            dbHelper.checkAndCopyDatabase();
            dbHelper.openDatabase();
        }catch (SQLException e){

        }
        try{
            Cursor cursor=dbHelper.QueryData("select * from tblHymn");
            if ( cursor !=null){
                if (cursor.moveToFirst()){
                    do {
                        Item item=new Item();
                        item.setId(cursor.getString(0));
                        item.setHymn(cursor.getString(1));
                        item.setContent(cursor.getString(2));
                        arrayList.add(item);
                    }while (cursor.moveToNext());
                }
            }
        }catch (SQLException e){ }

        adapter = new Adapter(this,R.layout.hymn_item, arrayList);
        listView = (ListView) findViewById(R.id.lvHymn);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
