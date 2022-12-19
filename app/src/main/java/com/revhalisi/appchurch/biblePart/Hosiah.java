package com.revhalisi.appchurch.biblePart;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import com.revhalisi.appchurch.R;
public  class Hosiah extends Activity {
       public static ListView listView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_chapter_layout);

        final String[] hosiah_chapter = getResources().getStringArray(R.array.hosiah_chapters);
        final  String[] content = getResources().getStringArray(R.array.hosiah_chapter_verses);

         listView2 = (ListView) findViewById(R.id.list2);
         ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(Hosiah.this,R.layout.entry,R.id.txtView1,hosiah_chapter);
        listView2.setAdapter(myAdapter);

        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
             String hosiah_chapters_content = content[position];

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("Articles", hosiah_chapters_content);
                    startActivity(intent);
            }
        });
    }
}

