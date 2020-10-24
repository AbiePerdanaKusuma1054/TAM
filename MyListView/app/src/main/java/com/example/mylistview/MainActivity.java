package com.example.mylistview;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import static android.os.Looper.prepare;

public class MainActivity extends AppCompatActivity {

    private HeroAdapter adapter;
    private String[] dataName;
    private String[] dataDescription;
    private TypedArray dataPhoto;
    private ArrayList<Hero> heroes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.lv_list);
        adapter = new HeroAdapter(this);
        listView.setAdapter(adapter);

        prepare();
        addItem();
    }

    private void prepare(){
        dataName=getResources().getStringArray(R.array.data_name);
        dataDescription=getResources().getStringArray(R.array.data_description);
        dataPhoto=getResources().obtainTypedArray(R.array.data_photo);
    }

    private void addItem(){
        heroes = new ArrayList<>();
        for (int i = 0; i< dataName.length;i++){
            Hero hero = new Hero();
            hero.setPhoto(dataPhoto.getResourceId(i,-1));
            hero.setName(dataName[i]);
            hero.setDescription(dataDescription[i]);
            heroes.add(hero);
        }
        adapter.setHeroes(heroes);
    }
}
