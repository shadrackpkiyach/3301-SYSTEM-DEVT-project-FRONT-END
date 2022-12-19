package com.revhalisi.appchurch.biblePart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.app.*;
import com.revhalisi.appchurch.R;
public  class Proverbs extends Activity {
       public static ListView listView2;

 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_chapter_layout);

        final String[] proverbs_chapter= getResources().getStringArray(R.array.proverbs_chapters);
        final  String[] content = getResources().getStringArray(R.array.proverbs_chapter_verses);

         listView2 = (ListView) findViewById(R.id.list2);
         ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(Proverbs.this,R.layout.entry,R.id.txtView1,proverbs_chapter);
        listView2.setAdapter(myAdapter);

        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
             String proverbs_chapters_content = content[position];

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("Articles", proverbs_chapters_content);
                    startActivity(intent);
            }
        });
    }
}

