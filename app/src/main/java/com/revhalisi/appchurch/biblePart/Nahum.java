package com.revhalisi.appchurch.biblePart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.app.*;
import com.revhalisi.appchurch.R;
public  class Nahum extends Activity {
       public static ListView listView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_chapter_layout);

        final String[] nahum_chapter = getResources().getStringArray(R.array.nahum_chapters);
        final  String[] content = getResources().getStringArray(R.array.nahum_chapter_verses);

         listView2 = (ListView) findViewById(R.id.list2);
         ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(Nahum.this,R.layout.entry,R.id.txtView1,nahum_chapter);
        listView2.setAdapter(myAdapter);

        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
             String nahum_chapters_content = content[position];

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("Articles", nahum_chapters_content);
                    startActivity(intent);
            }
        });
    }
}

