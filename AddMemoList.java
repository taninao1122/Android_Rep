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
  //  ArrayList<String> list = getIntent().getStringArrayListExtra("List");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_memo_list);
        ArrayList<String> list = getIntent().getStringArrayListExtra("List");
     //  ListView listView = new ListView(this);
     //   ArrayAdapter<String> arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,list);

        if(list.size() == 0) {
              list.add("ここにメモが表示されます");
          }
         ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
          ListView listView = (ListView)findViewById(R.id.listView1);
          listView.setAdapter(adapter);
         Button button5 = findViewById(R.id.button5);

    }

    public void onClickButton4(View view){

       ArrayList<String> list = getIntent().getStringArrayListExtra("List");
        EditText editText = (EditText)findViewById(R.id.editText);
     //   SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        String text = editText.getText().toString();
        list.add(text);
        editText.getEditableText().clear();
    }

    public void onClickBackButton(View view){
        ArrayList<String> list = getIntent().getStringArrayListExtra("List");
        Intent intent = new Intent();
        intent.putStringArrayListExtra("List", list);
        setResult(RESULT_OK, intent);
        finish();
    }


}
