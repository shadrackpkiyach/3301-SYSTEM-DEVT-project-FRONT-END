package com.revhalisi.appchurch.biblePart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.app.*;
import com.revhalisi.appchurch.R;
public  class Genesis extends Activity {
       public static ListView listView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_chapter_layout);

        final String[] genesis_chapters = getResources().getStringArray(R.array.Genesis_chapters);
        final  String[] content = getResources().getStringArray(R.array.Genesis_chapter_verses);

         listView2 = (ListView) findViewById(R.id.list2);
         ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(Genesis.this,R.layout.entry,R.id.txtView1,genesis_chapters);
        listView2.setAdapter(myAdapter);

        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
             String genesis_chapters_content = content[position];

                    Intent intent = new Intent(getApplicationContext(), BookChaptersContent.class);
                    intent.putExtra("Articles", genesis_chapters_content);
                    startActivity(intent);
            }
        });
    }
}

