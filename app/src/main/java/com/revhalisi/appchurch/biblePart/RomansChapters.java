package com.revhalisi.appchurch.biblePart;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import com.revhalisi.appchurch.R;
public class RomansChapters extends Activity {
public static ListView listView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_chapter_layout);

        final String[] romans_chapters = getResources().getStringArray(R.array.romans_chapters);
        final  String[] content = getResources().getStringArray(R.array.romans_chapter_contents);

        listView2 = (ListView) findViewById(R.id.list2);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(RomansChapters.this,R.layout.entry,R.id.txtView1,romans_chapters);
        listView2.setAdapter(myAdapter);

        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String romans_chapters_content = content[position];

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("Articles", romans_chapters_content);
                startActivity(intent);

            }
        });

    }
}
