package com.revhalisi.appchurch.biblePart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.revhalisi.appchurch.HomeActivity;
import com.revhalisi.appchurch.ProfileActivity;
import com.revhalisi.appchurch.R;
import com.revhalisi.appchurch.calender.CalenderActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shedules);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        TextView textView =(TextView)findViewById(R.id.txtView2);
        bottomNavigationView.setSelectedItemId(R.id.schedules);

       // String Chapter_content = getIntent().getStringExtra("Articles");
       // textView.setText(Chapter_content);


        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.schedules:
                        return true;

                    case R.id.profile:
                        startActivity(
                                new Intent(getApplicationContext(), ProfileActivity.class)
                        );
                        overridePendingTransition(0, 0);
                        finish(); // do something here
                        return true;
                    case R.id.calender:
                        startActivity(
                                new Intent(getApplicationContext(), CalenderActivity.class)
                        );
                        overridePendingTransition(0, 0);
                        finish(); // do something here
                        return true;
                    case R.id.home:
                        startActivity(
                                new Intent(getApplicationContext(), HomeActivity.class)
                        );
                        overridePendingTransition(0, 0);
                        finish();// do something here
                        return true;
                    default:
                        return true;
                }
            }
        });

    }
    public void onClick(View v) {

        // TODO: Implement this method
        int id = v.getId();
        switch (id){
            //== NEW TESTAMENT==
            case R.id.btn_1:
                Button b1 = (Button) v.findViewById(R.id.btn_1);
                Intent intent = new Intent(getApplicationContext(), MathewChapters.class);
                startActivity(intent);
                break;

            case R.id.btn_2:
                Button b2 = (Button) v.findViewById(R.id.btn_2);
                Intent intent2 = new Intent(getApplicationContext(), MarkChapters.class);
                startActivity(intent2);
                break;
            case R.id.btn_3:
                Button b3 = (Button) v.findViewById(R.id.btn_3);
                Intent intent3 = new Intent(getApplicationContext(), LukeChapters.class);
                startActivity(intent3);
                break;

            case R.id.btn_4:
                Button b4 = (Button) v.findViewById(R.id.btn_4);
                Intent intent4 = new Intent(getApplicationContext(), JohnChapters.class);
                startActivity(intent4);
                break;
            case R.id.btn_5:
                Button b5 = (Button) v.findViewById(R.id.btn_5);
                Intent intent5 = new Intent(getApplicationContext(), ActsChapters.class);
                startActivity(intent5);
                break;
            case R.id.btn_6:
                Button b6 = (Button) v.findViewById(R.id.btn_6);
                Intent intent6 = new Intent(getApplicationContext(), RomansChapters.class);
                startActivity(intent6);
                break;
            case R.id.btn_7:
                Button b7 = (Button) v.findViewById(R.id.btn_7);
                Intent intent7 = new Intent(getApplicationContext(), Frst_CorrenthiansChapter.class);
                startActivity(intent7);
                break;
            case R.id.btn_8:
                Button b8 = (Button) v.findViewById(R.id.btn_8);
                Intent intent8 = new Intent(getApplicationContext(), Second_CorrenthiansChapter.class);
                startActivity(intent8);
                break;
            case R.id.btn_9:
                Button b9 = (Button) v.findViewById(R.id.btn_9);
                Intent intent9 = new Intent(getApplicationContext(), Galatians.class);
                startActivity(intent9);
                break;
            case R.id.btn_10:
                Button b10 = (Button) v.findViewById(R.id.btn_10);
                Intent intent10 = new Intent(getApplicationContext(), Ephesians.class);
                startActivity(intent10);
                break;
            case R.id.btn_11:
                Button b11 = (Button) v.findViewById(R.id.btn_11);
                Intent intent11 = new Intent(getApplicationContext(), Philippians.class);
                startActivity(intent11);
                break;
            case R.id.btn_12:
                Button b12 = (Button) v.findViewById(R.id.btn_12);
                Intent intent12 = new Intent(getApplicationContext(), Collosians.class);
                startActivity(intent12);
                break;
            case R.id.btn_13:
                Button b13 = (Button) v.findViewById(R.id.btn_13);
                Intent intent13 = new Intent(getApplicationContext(), First_thessalonian.class);
                startActivity(intent13);
                break;
            case R.id.btn_14:
                Button b14 = (Button) v.findViewById(R.id.btn_14);
                Intent intent14 = new Intent(getApplicationContext(), Second_thessalonian.class);
                startActivity(intent14);
                break;
            case R.id.btn_15:
                Button b15 = (Button) v.findViewById(R.id.btn_15);
                Intent intent15 = new Intent(getApplicationContext(), First_timothy.class);
                startActivity(intent15);
                break;
            case R.id.btn_16:
                Button b16 = (Button) v.findViewById(R.id.btn_16);
                Intent intent16 = new Intent(getApplicationContext(), SecondTimothy.class);
                startActivity(intent16);
                break;
            case R.id.btn_17:
                Button b17 = (Button) v.findViewById(R.id.btn_17);
                Intent intent17 = new Intent(getApplicationContext(), Titus.class);
                startActivity(intent17);
                break;
            case R.id.btn_18:
                Button b18 = (Button) v.findViewById(R.id.btn_18);
                Intent intent18 = new Intent(getApplicationContext(), Philemon.class);
                startActivity(intent18);
                break;
            case R.id.btn_19:
                Button b19 = (Button) v.findViewById(R.id.btn_19);
                Intent intent19 = new Intent(getApplicationContext(), Hebrews.class);
                startActivity(intent19);
                break;
            case R.id.btn_20:
                Button b20 = (Button) v.findViewById(R.id.btn_20);
                Intent intent20 = new Intent(getApplicationContext(), James.class);
                startActivity(intent20);
                break;
            case R.id.btn_21:
                Button b21 = (Button) v.findViewById(R.id.btn_21);
                Intent intent21 = new Intent(getApplicationContext(), First_Peter.class);
                startActivity(intent21);
                break;
            case R.id.btn_22:
                Button b22 = (Button) v.findViewById(R.id.btn_22);
                Intent intent22 = new Intent(getApplicationContext(), Second_Peter.class);
                startActivity(intent22);
                break;
            case R.id.btn_23:
                Button b23 = (Button) v.findViewById(R.id.btn_23);
                Intent intent23 = new Intent(getApplicationContext(), FirstJohn.class);
                startActivity(intent23);
                break;
            case R.id.btn_24:
                Button b24 = (Button) v.findViewById(R.id.btn_24);
                Intent intent24 = new Intent(getApplicationContext(), SecondJohn.class);
                startActivity(intent24);
                break;
            case R.id.btn_25:
                Button b25 = (Button) v.findViewById(R.id.btn_25);
                Intent intent25 = new Intent(getApplicationContext(), ThirdJohn.class);
                startActivity(intent25);
                break;
            case R.id.btn_26:
                Button b26 = (Button) v.findViewById(R.id.btn_26);
                Intent intent26 = new Intent(getApplicationContext(), Jude.class);
                startActivity(intent26);
                break;
            case R.id.btn_27:
                Button b27 = (Button) v.findViewById(R.id.btn_27);
                Intent intent27 = new Intent(getApplicationContext(), Revelation.class);
                startActivity(intent27);
                break;


            //==OLD TESTAMENT==
            case R.id.btn_28:
                Button b28 = (Button) v.findViewById(R.id.btn_28);
                Intent intent28 = new Intent(getApplicationContext(), Genesis.class);
                startActivity(intent28);
                break;
            case R.id.btn_29:
                Button b29 = (Button) v.findViewById(R.id.btn_29);
                Intent intent29 = new Intent(getApplicationContext(), Exodus.class);
                startActivity(intent29);
                break;
            case R.id.btn_30:
                Button b30 = (Button) v.findViewById(R.id.btn_30);
                Intent intent30 = new Intent(getApplicationContext(), Leviticus.class);
                startActivity(intent30);
                break;
            case R.id.btn_31:
                Button b31 = (Button) v.findViewById(R.id.btn_31);
                Intent intent31 = new Intent(getApplicationContext(), Numbers.class);
                startActivity(intent31);
                break;
            case R.id.btn_32:
                Button b32 = (Button) v.findViewById(R.id.btn_32);
                Intent intent32 = new Intent(getApplicationContext(), Deuteronomy.class);
                startActivity(intent32);
                break;
            case R.id.btn_33:
                Button b33 = (Button) v.findViewById(R.id.btn_33);
                Intent intent33 = new Intent(getApplicationContext(), Joshua.class);
                startActivity(intent33);
                break;
            case R.id.btn_34:
                Button b34 = (Button) v.findViewById(R.id.btn_34);
                Intent intent34 = new Intent(getApplicationContext(), Judges.class);
                startActivity(intent34);
                break;
            case R.id.btn_35:
                Button b35 = (Button) v.findViewById(R.id.btn_35);
                Intent intent35 = new Intent(getApplicationContext(), Ruth.class);
                startActivity(intent35);
                break;
            case R.id.btn_36:
                Button b36 = (Button) v.findViewById(R.id.btn_36);
                Intent intent36 = new Intent(getApplicationContext(),First_samuel.class);
                startActivity(intent36);
                break;
            case R.id.btn_37:
                Button b37 = (Button) v.findViewById(R.id.btn_37);
                Intent intent37 = new Intent(getApplicationContext(), Second_samuel.class);
                startActivity(intent37);
                break;
            case R.id.btn_38:
                Button b38 = (Button) v.findViewById(R.id.btn_38);
                Intent intent38 = new Intent(getApplicationContext(), First_king.class);
                startActivity(intent38);
                break;
            case R.id.btn_39:
                Button b39 = (Button) v.findViewById(R.id.btn_39);
                Intent intent39 = new Intent(getApplicationContext(), Second_king.class);
                startActivity(intent39);
                break;
            case R.id.btn_40:
                Button b40 = (Button) v.findViewById(R.id.btn_40);
                Intent intent40 = new Intent(getApplicationContext(), First_chronicle.class);
                startActivity(intent40);
                break;
            case R.id.btn_41:
                Button b41 = (Button) v.findViewById(R.id.btn_41);
                Intent intent41 = new Intent(getApplicationContext(), Second_chronicle.class);
                startActivity(intent41);
                break;
            case R.id.btn_42:
                Button b42 = (Button) v.findViewById(R.id.btn_42);
                Intent intent42 = new Intent(getApplicationContext(), Ezra.class);
                startActivity(intent42);
                break;
            case R.id.btn_43:
                Button b43 = (Button) v.findViewById(R.id.btn_43);
                Intent intent43 = new Intent(getApplicationContext(), Nehemiah.class);
                startActivity(intent43);
                break;
            case R.id.btn_44:
                Button b44 = (Button) v.findViewById(R.id.btn_44);
                Intent intent44 = new Intent(getApplicationContext(), Esther.class);
                startActivity(intent44);
                break;
            case R.id.btn_45:
                Button b45 = (Button) v.findViewById(R.id.btn_45);
                Intent intent45 = new Intent(getApplicationContext(), Job.class);
                startActivity(intent45);
                break;
            case R.id.btn_46:
                Button b46 = (Button) v.findViewById(R.id.btn_46);
                Intent intent46 = new Intent(getApplicationContext(), Psalm.class);
                startActivity(intent46);
                break;
            case R.id.btn_47:
                Button b47 = (Button) v.findViewById(R.id.btn_47);
                Intent intent47 = new Intent(getApplicationContext(), Proverbs.class);
                startActivity(intent47);
                break;
            case R.id.btn_48:
                Button b48 = (Button) v.findViewById(R.id.btn_48);
                Intent intent48 = new Intent(getApplicationContext(), Ecclesiastes.class);
                startActivity(intent48);
                break;
            case R.id.btn_49:
                Button b49 = (Button) v.findViewById(R.id.btn_49);
                Intent intent49 = new Intent(getApplicationContext(), Solomon.class);
                startActivity(intent49);
                break;
            case R.id.btn_50:
                Button b50 = (Button) v.findViewById(R.id.btn_50);
                Intent intent50 = new Intent(getApplicationContext(), Isiah.class);
                startActivity(intent50);
                break;
            case R.id.btn_51:
                Button b51 = (Button) v.findViewById(R.id.btn_51);
                Intent intent51 = new Intent(getApplicationContext(), Jeremiah.class);
                startActivity(intent51);
                break;
            case R.id.btn_52:
                Button b52 = (Button) v.findViewById(R.id.btn_52);
                Intent intent52 = new Intent(getApplicationContext(), Lamentation.class);
                startActivity(intent52);
                break;
            case R.id.btn_53:
                Button b53 = (Button) v.findViewById(R.id.btn_53);
                Intent intent53 = new Intent(getApplicationContext(), Ezekiel.class);
                startActivity(intent53);
                break;
            case R.id.btn_54:
                Button b54 = (Button) v.findViewById(R.id.btn_54);
                Intent intent54 = new Intent(getApplicationContext(), Daniel.class);
                startActivity(intent54);
                break;
            case R.id.btn_55:
                Button b55 = (Button) v.findViewById(R.id.btn_55);
                Intent intent55 = new Intent(getApplicationContext(), Hosiah.class);
                startActivity(intent55);
                break;
            case R.id.btn_56:
                Button b56 = (Button) v.findViewById(R.id.btn_56);
                Intent intent56 = new Intent(getApplicationContext(), Joel.class);
                startActivity(intent56);
                break;
            case R.id.btn_57:
                Button b57 = (Button) v.findViewById(R.id.btn_57);
                Intent intent57 = new Intent(getApplicationContext(), Amos.class);
                startActivity(intent57);
                break;
            case R.id.btn_58:
                Button b58 = (Button) v.findViewById(R.id.btn_58);
                Intent intent58 = new Intent(getApplicationContext(), Obadiah.class);
                startActivity(intent58);
                break;
            case R.id.btn_59:
                Button b59 = (Button) v.findViewById(R.id.btn_59);
                Intent intent59 = new Intent(getApplicationContext(), Jonah.class);
                startActivity(intent59);
                break;
            case R.id.btn_60:
                Button b60 = (Button) v.findViewById(R.id.btn_60);
                Intent intent60 = new Intent(getApplicationContext(), Micah.class);
                startActivity(intent60);
                break;
            case R.id.btn_61:
                Button b61 = (Button) v.findViewById(R.id.btn_61);
                Intent intent61 = new Intent(getApplicationContext(),Nahum.class);
                startActivity(intent61);
                break;
            case R.id.btn_62:
                Button b62 = (Button) v.findViewById(R.id.btn_62);
                Intent intent62 = new Intent(getApplicationContext(), Habbakkuk.class);
                startActivity(intent62);
                break;
            case R.id.btn_63:
                Button b63 = (Button) v.findViewById(R.id.btn_63);
                Intent intent63 = new Intent(getApplicationContext(), Zephaniah.class);
                startActivity(intent63);
                break;
            case R.id.btn_64:
                Button b64 = (Button) v.findViewById(R.id.btn_64);
                Intent intent64 = new Intent(getApplicationContext(), Haggai.class);
                startActivity(intent64);
                break;
            case R.id.btn_65:
                Button b65 = (Button) v.findViewById(R.id.btn_65);
                Intent intent65 = new Intent(getApplicationContext(), Zechariah.class);
                startActivity(intent65);
                break;
            case R.id.btn_66:
                Button b66 = (Button) v.findViewById(R.id.btn_66);
                Intent intent66 = new Intent(getApplicationContext(), Malachi.class);
                startActivity(intent66);
                break;
        }
    }
}