package com.revhalisi.appchurch.biblePart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.app.*;
import android.widget.*;
import com.revhalisi.appchurch.R;
public class Collosians extends Activity
{

	private ListView listView2;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_chapter_layout);

        final String[]collosians_chapters = getResources().getStringArray(R.array.colosians_chapter);
        final  String[] content = getResources().getStringArray(R.array.colosians_chapters_content);

        listView2 = (ListView) findViewById(R.id.list2);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(Collosians.this, R.layout.entry, R.id.txtView1, collosians_chapters);
        listView2.setAdapter(myAdapter);

        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String collosian_chapters_content = content[position];

                Intent intent = new Intent(getApplicationContext(), BookChaptersContent.class);
                intent.putExtra("Articles", collosian_chapters_content);
                startActivity(intent);

            }
        });

    }

}
