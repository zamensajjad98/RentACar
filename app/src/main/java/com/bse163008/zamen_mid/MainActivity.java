package com.bse163008.zamen_mid;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    FrameLayout frame_car;
    ListView simpleListView;
    Button closeButton;
    AlertDialog.Builder builder;
    SharedPreferences sharedpreferences;


    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    public static final String rent = "rentKey";
    public static final String img = "imgKey";
    public static final String totalamount="amountKey";


    String[] carName = {"mercedes","porsche","vits", "bmw", "foxi", "honda", "foxicarry","ferrari","pruis","chevrolet"};//car names array
    int[] Rent={50,64,70,40,90,33,66,88,99,100};
    int[] carImages = {R.drawable.mercedes,R.drawable.porsche,R.drawable.vits, R.drawable.bmw, R.drawable.foxi, R.drawable.honda,
            R.drawable.foxicarry,R.drawable.ferrari,R.drawable.pruis,R.drawable.chevrolet};//car images array
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simpleListView=(ListView)findViewById(R.id.simpleListView);

        frame_car=findViewById(R.id.frame_car);
        frame_car.setVisibility(View.INVISIBLE);


        ArrayList<HashMap<String,String>> arrayList=new ArrayList<>();
        for (int i=0;i<carName.length;i++)
        {
            HashMap<String,String> hashMap=new HashMap<>();//create a hashmap to store the data in key value pair
            hashMap.put("name",carName[i]);
            hashMap.put("image",carImages[i]+"");
            arrayList.add(hashMap);//add the hashmap into arrayList
        }
        String[] from={"name","image"};//string array
        int[] to={R.id.textView,R.id.imageView};//int array of views id's
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,arrayList,R.layout.list_view_items,from,to);//Create object and set the parameters for simpleAdapter
        simpleListView.setAdapter(simpleAdapter);//sets the adapter for listView

        //perform listView item click event
        simpleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {



                ImageView img= (ImageView) findViewById(R.id.imageView2);
                TextView text=(TextView) findViewById(R.id.carname);

                if(carName[i]=="mercedes")
                {
                    img.setImageResource(R.drawable.mercedes);
                    text.setText("mercedes");


                }else if(carName[i]=="porsche")
                {
                    img.setImageResource(R.drawable.porsche);
                    text.setText("porsche");

                }else if(carName[i]=="vits")
                {
                    img.setImageResource(R.drawable.vits);
                    text.setText("vits");
                } else if(carName[i]=="bmw")
                {
                    img.setImageResource(R.drawable.bmw);
                    text.setText("bmw");
                }else if(carName[i]=="foxi")
                {
                    img.setImageResource(R.drawable.foxi);
                    text.setText("foxi");
                }else if(carName[i]=="honda")
                {
                    img.setImageResource(R.drawable.honda);
                    text.setText("honda");
                }else if(carName[i]=="foxicarry")
                {
                    img.setImageResource(R.drawable.foxicarry);
                    text.setText("foxicarry");
                }else if(carName[i]=="ferrari")
                {
                    img.setImageResource(R.drawable.ferrari);
                    text.setText("ferrari");
                }else if(carName[i]=="pruis")
                {
                    img.setImageResource(R.drawable.pruis);
                    text.setText("pruis");

                }else if(carName[i]=="chevrolet")
                {
                    img.setImageResource(R.drawable.chevrolet);
                    text.setText("chevrolet");
                }
                else {

                    }

                simpleListView.setVisibility(View.INVISIBLE);
                frame_car.setVisibility(View.VISIBLE);
            }
        });

        closeButton = (Button) findViewById(R.id.button);
        builder = new AlertDialog.Builder(this);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Uncomment the below code to Set the message and title from the strings.xml file
                builder.setMessage(R.string.dialog_message) .setTitle(R.string.dialog_title);

                //Setting message manually and performing action on button click
                builder.setMessage("are you sure to confirm your order?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finish();
                                Toast.makeText(getApplicationContext(),"confirmed ",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //  Action for 'NO' Button
                                dialog.cancel();
                                Toast.makeText(getApplicationContext(),"not confirmed",Toast.LENGTH_SHORT).show();
                            }
                        });
                //Creating dialog box
                AlertDialog alert = builder.create();
                //Setting the title manually
                alert.setTitle("AlertDialogExample");
                alert.show();
            }
        });

        sharedpreferences = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);
        Intent intent=new Intent(this,Main2Activity.class);
        SharedPreferences.Editor editor = sharedpreferences.edit();


        EditText editText=(EditText) findViewById(R.id.inputday);
        String days=editText.getText().toString();

        editor.putString(Name, full_name);
        editor.putString(rent, email);
        editor.putString(img, age);
        editor.putString(totalamount, address);
        editor.apply();
        Toast.makeText(MainActivity.this,"Thanks",Toast.LENGTH_LONG).show();
        startActivity(intent);
    }
}

