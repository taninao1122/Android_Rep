package com.example.tanin.report3_program;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> list = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClickButton1(View view){
    //    list.add("VIew");
        Intent intent1 = new Intent(this,VIewMemoList.class);
        intent1.putStringArrayListExtra("List",list);
        int requestCode1 = 1000;
        startActivityForResult(intent1,requestCode1);
    }

    public void onClickButton2(View view){
     //   list.add("Add");
        Intent intent2 = new Intent(this,AddMemoList.class);
        intent2.putStringArrayListExtra("List",list);
        int requestCode1 = 2000;
        startActivityForResult(intent2,requestCode1);
    }

    public void onClickButton3(View view){
     //   list.add("VIew");
        Intent intent3 = new Intent(this,VIewMemoList.class);
        intent3.putStringArrayListExtra("List",list);
        int requestCode1 = 1000;
        startActivityForResult(intent3,requestCode1);

    }
    public void onActivityResult( int requestCode, int resultCode, Intent intent )
    {
        // startActivityForResult()の際に指定した識別コードとの比較
        if( requestCode == 1000 || requestCode == 2000 ){

            // 返却結果ステータスとの比較
            if( resultCode == Activity.RESULT_OK ){

                // 返却されてきたintentから値を取り出す
                list = intent.getStringArrayListExtra( "List" );
            }
        }
    }
}
