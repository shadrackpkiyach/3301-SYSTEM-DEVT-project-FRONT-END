package com.revhalisi.appchurch.biblePart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.app.*;
import android.widget.*;
import com.revhalisi.appchurch.R;
public class Second_Peter extends Activity {
public static ListView listView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_chapter_layout);

        final String[] second_peter_chapter = getResources().getStringArray(R.array.seoond_peter_chapter);
        final  String[] content = getResources().getStringArray(R.array.second_peter_content);

        listView2 = (ListView) findViewById(R.id.list2);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(Second_Peter.this,R.layout.entry,R.id.txtView1,second_peter_chapter);
        listView2.setAdapter(myAdapter);

        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String second_peter_chapters_content = content[position];

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("Articles", second_peter_chapters_content);
                startActivity(intent);

            }
        });

    }
}
