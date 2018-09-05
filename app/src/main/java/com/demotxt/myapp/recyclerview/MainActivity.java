package com.demotxt.myapp.recyclerview;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Book> lstBook ;
    RecyclerView myrv;
    Configuration orientation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstBook = new ArrayList<>();
        lstBook.add(new Book("The Vegitarian","Categorie Book","Description book",R.drawable.thevigitarian));
        lstBook.add(new Book("The Wild Robot","Categorie Book","Description book",R.drawable.thewildrobot));
        lstBook.add(new Book("Maria Semples","Categorie Book","Description book",R.drawable.mariasemples));
        lstBook.add(new Book("The Martian","Categorie Book","Description book",R.drawable.themartian));
        lstBook.add(new Book("He Died with...","Categorie Book","Description book",R.drawable.hediedwith));

        myrv = (RecyclerView) findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this,lstBook);
       // myrv.setLayoutManager(new GridLayoutManager(this,2));
        orientation = new Configuration();
        if(this.myrv.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            myrv.setLayoutManager(new GridLayoutManager(this, 2));
        } else if (this.myrv.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            myrv.setLayoutManager(new GridLayoutManager(this, 4));
        }

        myrv.setAdapter(myAdapter);


    }
}
