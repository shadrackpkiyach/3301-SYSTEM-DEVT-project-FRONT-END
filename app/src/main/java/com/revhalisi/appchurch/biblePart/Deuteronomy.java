package com.revhalisi.appchurch.biblePart;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import com.revhalisi.appchurch.R;

public  class Deuteronomy extends Activity {
       public static ListView listView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_chapter_layout);

        final String[] deuteronomy_chapters = getResources().getStringArray(R.array.deuteronomy_chapters);
        final  String[] content = getResources().getStringArray(R.array.deuteronomy_chapter_verses);

         listView2 = (ListView) findViewById(R.id.list2);
         ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(Deuteronomy.this,R.layout.entry,R.id.txtView1,deuteronomy_chapters);
        listView2.setAdapter(myAdapter);

        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
             String deuteronomy_chapters_content = content[position];

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("Articles", deuteronomy_chapters_content);
                    startActivity(intent);
            }
        });
    }
}


