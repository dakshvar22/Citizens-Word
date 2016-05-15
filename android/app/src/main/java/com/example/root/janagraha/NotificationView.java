package com.example.root.janagraha;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class NotificationView extends Activity{


    String questions;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification);
        Button b1;
//        System.out.println(savedInstanceState.getString("questions"));
        String tag_json_obj = "json_obj_req";
        final String TAG="hello";
//        String chk = "lat="+savedInstanceState.getString("lat")+"&long="+savedInstanceState.getString("long");
//        System.out.println(chk);
        String chk="";
        String url = "http://janacivic.mybluemix.net/getQuestions?"+chk;

        String questions[] = {"The park has sufficient lighting","The park has enough green cover","The park is clean","The park has a footpath"};
        TextView tv1,tv2,tv3,tv4;
        tv1 = (TextView)findViewById(R.id.textView);

        tv2 = (TextView)findViewById(R.id.textView2);

        tv3 = (TextView)findViewById(R.id.textView3);

        tv4 = (TextView)findViewById(R.id.textView4);
        tv1.setText(questions[0]);
        tv2.setText(questions[1]);
        tv3.setText(questions[2]);
        tv4.setText(questions[3]);
        b1=(Button)findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Thank you", Toast.LENGTH_LONG).show();
                finish();
                moveTaskToBack(true);
//                MainActivity.this.finish();
            }
        });

    }
}