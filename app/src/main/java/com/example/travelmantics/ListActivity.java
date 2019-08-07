package com.example.travelmantics;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class ListActivity extends AppCompatActivity {
    ArrayList<TravelDeal>deals;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;
    private ChildEventListener mChildListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        /*
        FirebaseUtil.openFbreference("traveldeals");
        mFirebaseDatabase=FirebaseUtil.mFirebaseDatabase;
        mDatabaseReference=FirebaseUtil.mDatabaseReference;

        mChildListener=new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                TextView tvDeals =(TextView)findViewById(R.id.tvDeals);
                TravelDeal td=dataSnapshot.getValue(TravelDeal.class);
                tvDeals.setText(tvDeals.getText() + "\n"+ td.getTitle());

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        mDatabaseReference.addChildEventListener(mChildListener);*/

        RecyclerView rvDeals=(RecyclerView)findViewById(R.id.rvDeals);
        final DealAdapter adapter=new DealAdapter();
        rvDeals.setAdapter(adapter);
        LinearLayoutManager dealsLayoutManager=new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        rvDeals.setLayoutManager(dealsLayoutManager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.list_activity_menu, menu);
        return true;
    }

    @Override

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.insert_menu:
                Intent intent=new Intent(this, DealActivity.class);
                startActivity(intent);
                return true;


        }
        return super.onOptionsItemSelected(item);
    }
}