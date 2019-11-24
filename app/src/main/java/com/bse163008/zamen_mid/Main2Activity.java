package com.bse163008.zamen_mid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    SharedPreferences sharedpreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
    String quantity=sharedpreferences.getString("quantityKey","");
    String totalamount=sharedpreferences.getString("totalamountKey","");



    TextView textView=findViewById(R.id.textView5);
    // textView.setText(quantity);
    public  void helplineno(View view)
    {
        Intent intent=new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:0800808000"));
        startActivity(intent);
    }
    public void visit(View view)
    {
        Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
        startActivity(intent1);

    }



}
