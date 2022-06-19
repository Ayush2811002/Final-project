package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private RecyclerView cont;
    myadapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cont=(RecyclerView) findViewById(R.id.cont);
        cont.setLayoutManager(new LinearLayoutManager(this));
        FirebaseRecyclerOptions<mode> options =
                new FirebaseRecyclerOptions.Builder<mode>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child(""), mode.class)
                        .build();
        adapter=new myadapter(options);
        cont.setAdapter(adapter);
    }
    @Override
    protected void onStart(){
        super.onStart();
        adapter.startListening();
    }
    @Override
    protected void onStop(){
        super.onStop();
        adapter.stopListening();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.searchmenu,menu);
        MenuItem item=menu.findItem(R.id.searc);
        SearchView searchView=(SearchView)item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {

                processsearch(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                processsearch(s);
                return false;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }

    private void  processsearch(String s)
    {
        FirebaseRecyclerOptions<mode> options =
                new FirebaseRecyclerOptions.Builder<mode>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Student record").orderByChild("Title").startAt(s).endAt(s+"\uf8ff"), mode.class)
                        .build();

        adapter=new myadapter(options);
        adapter.startListening();
        cont.setAdapter(adapter);

    }
}
