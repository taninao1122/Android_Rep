package com.example.tanin.report3_program;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
   private ArrayList<String> list = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3= findViewById(R.id.button3);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   list.add("VIew");
                Intent intent1 = new Intent(getApplication(),VIewMemoList.class);
                intent1.putStringArrayListExtra("List",list);
                int requestCode1 = 1000;
                startActivityForResult(intent1,requestCode1);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //    list.add("Add");
                Intent intent2 = new Intent(getApplication(),AddMemoList.class);
                intent2.putStringArrayListExtra("List",list);
                int requestCode2 = 2000;
                startActivityForResult(intent2,requestCode2);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getApplication(),VIewMemoList.class);
                intent3.putStringArrayListExtra("List",list);
                int requestCode1 = 1000;
                startActivityForResult(intent3,requestCode1);

            }
        });



    }

    public void onActivityResult( int requestCode, int resultCode, Intent intent )
    {
        if(requestCode == 1000)
        {
            if( resultCode == Activity.RESULT_OK ){

                // 返却されてきたintentから値を取り出す
                list = intent.getStringArrayListExtra( "ViewList" );

            }
        }
        // startActivityForResult()の際に指定した識別コードとの比較
        else if(requestCode == 2000 ){

            // 返却結果ステータスとの比較
            if( resultCode == Activity.RESULT_OK ){

                // 返却されてきたintentから値を取り出す
                list = intent.getStringArrayListExtra( "addList" );

            }
        }
    }

}
