package com.revhalisi.appchurch.biblePart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.app.*;
import android.widget.*;import com.revhalisi.appchurch.R;
public class JohnChapters extends Activity {
public static ListView listView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_chapter_layout);

        final String[] john_chapters = getResources().getStringArray(R.array.john_chapters);
        final  String[] content = getResources().getStringArray(R.array.john_chapters_content);

        listView2 = (ListView) findViewById(R.id.list2);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(JohnChapters.this,R.layout.entry,R.id.txtView1,john_chapters);
        listView2.setAdapter(myAdapter);

        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String john_chapters_content = content[position];

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("Articles", john_chapters_content);
                startActivity(intent);

            }
        });

    }
}
