package com.example.bai_tap_06;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> arrCourse;
    ListView lvmonhoc;
    EditText editText;
    int vitri = -1;
    Button btadd,btCapNhat,btdel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvmonhoc = (ListView) findViewById(R.id.Course);
        arrCourse = new ArrayList<>();
        arrCourse.add("1811505310333");
        arrCourse.add("18T3");
        arrCourse.add("HTML");
        arrCourse.add("XML");
        arrCourse.add("ANDROID");
        arrCourse.add("JAVA SCRIPT");
        final ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,arrCourse);
        lvmonhoc.setAdapter(arrayAdapter);
        editText = (EditText) findViewById(R.id.plaintext);
        btadd = (Button) findViewById(R.id.btadd);
        btCapNhat = (Button) findViewById(R.id.btedit);
        btdel = (Button) findViewById(R.id.btdel);
        btadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String monhoc = editText.getText().toString();
                arrCourse.add(monhoc);
                arrayAdapter.notifyDataSetChanged();
            }
        });
        lvmonhoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                editText.setText(arrCourse.get(position));
                vitri = position;
            }
        });
        btCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrCourse.set(vitri,editText.getText().toString());
                arrayAdapter.notifyDataSetChanged();
            }
        });
        btdel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrCourse.remove(vitri);
                arrayAdapter.notifyDataSetChanged();
            }
        });
        lvmonhoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                arrCourse.remove(position);
                arrayAdapter.notifyDataSetChanged();
                return false;
            }
        });
    }
}