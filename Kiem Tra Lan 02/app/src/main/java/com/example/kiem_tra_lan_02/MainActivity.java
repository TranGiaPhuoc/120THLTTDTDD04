package com.example.kiem_tra_lan_02 ;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity ;

import android.content.Context;
import android.os.Bundle ;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    GridView GV;
    int IMAGES[] = {R.drawable.avatar, R.drawable.facebook, R.drawable.instagram, R.drawable.twitter, R.drawable.youtube};
    String TITLE[] = {"TRAN GIA PHUOC", "Facebook", "Instagram", "Twitter", "WhatsApp" , "Youtube"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GV = findViewById(R.id.GV);

        MyAdapter ARRAY_ADAPTER = new MyAdapter(MainActivity.this, IMAGES, TITLE);
        GV.setAdapter(ARRAY_ADAPTER);
    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String Title[];
        int Images[];

        MyAdapter(Context c, int[] imgs, String[] title) {
            super(c, R.layout.grid_item, R.id.textView1, title);
            this.context = c;
            this.Title = title;
            this.Images = imgs;
        }


        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View row = layoutInflater.inflate(R.layout.grid_item, parent, false);

            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textView1);

            images.setImageResource(Images[position]);
            myTitle.setText(Title[position]);

            return row;
        }
    }
}