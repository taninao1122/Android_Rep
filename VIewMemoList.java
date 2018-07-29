package com.example.tanin.report3_program;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class VIewMemoList extends AppCompatActivity{
     private ArrayList<String> viewlist = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_memo_list);
        final ArrayList<String> viewlist = getIntent().getStringArrayListExtra("List");
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,viewlist);
        final ListView listView = (ListView)findViewById(R.id.listView1);
        listView.setAdapter(adapter);

        Button backButton2 = (Button) findViewById(R.id.back_button2);
        Button deleteButton = (Button)findViewById(R.id.button5);
        backButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putStringArrayListExtra("ViewList", viewlist);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(viewlist.size() != 0) {
                     viewlist.remove(1);
                     listView.setAdapter(adapter);
                }
            }
        });
    }
}