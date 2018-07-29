package com.example.tanin.report3_program;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class AddMemoList extends AppCompatActivity {
    private ArrayList<String> addlist = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_memo_list);
        final ArrayList<String> addlist = getIntent().getStringArrayListExtra("List");

        if(addlist.size() == 0) {
              addlist.add("ここにメモが表示されます");
          }
         ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,addlist);
          ListView listView = (ListView)findViewById(R.id.listView1);
          listView.setAdapter(adapter);
         Button button5 = findViewById(R.id.button5);
         Button backButton = findViewById(R.id.back_button);

         button5.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 EditText editText = (EditText)findViewById(R.id.editText);
                 String text = editText.getText().toString();
                 addlist.add(text);
                 editText.getEditableText().clear();
             }
         });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putStringArrayListExtra("addList", addlist);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
