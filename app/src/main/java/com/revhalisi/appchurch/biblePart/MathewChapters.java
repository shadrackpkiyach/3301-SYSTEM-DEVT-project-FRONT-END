package com.revhalisi.appchurch.biblePart;
import android.app.*;
import android.content.*;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.revhalisi.appchurch.R;

public class MathewChapters extends Activity
{
	public static ListView listView2;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.book_chapter_layout);
		final String[] mathew_chapters = getResources().getStringArray(R.array.mathew_chapters);
      final  String[] content = getResources().getStringArray(R.array.mathew_chapter_content);
		
		listView2 =(ListView)findViewById(R.id.list2);
		ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.entry,R.id.txtView1,mathew_chapters);
        listView2.setAdapter(myAdapter);

        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					String mathew_chapters_content = content[position];

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("Articles", mathew_chapters_content);
                    startActivity(intent);
				}
			});
	}
//	@Override
//	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
//	{
//		// TODO: Implement this method
//
//		View view = inflater.inflate(R.layout.book_chapter_layout,container,false);
//		
//		final String[] mathew_chapters = getResources().getStringArray(R.array.mathew_chapters);
//        final  String[] content = getResources().getStringArray(R.array.mathew_chapter_content);
//
//		listView2 =(ListView) view.findViewById(R.id.list2);
//		ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.entry_list,R.id.txtView1,mathew_chapters);
//        listView2.setAdapter(myAdapter);
//
//        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//				@Override
//				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//					String mathew_chapters_content = content[position];
//
//                    Intent intent = new Intent(getApplicationContext(), BookChaptersContent.class);
//                    intent.putExtra("Articles", mathew_chapters_content);
//                    startActivity(intent);
//				}
//			});
//		return view;
//	}
	
}
