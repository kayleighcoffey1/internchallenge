package com.example.kayleighcoffey.driving_app;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {


    String[] items = new String [] {"Lesson 6 with Arthur Speed " +
                                    "4015 Connolly Street",
                                    "Lesson 7 with Arthur Speed " +
                                    "4015 Connolly Street",
                                    "Lesson 7 with Arthur Speed " +
                                            "4015 Connolly Street",
                                    "Lesson 7 with Arthur Speed " +
                                    "4015 Connolly Street",
                                    "Lesson 7 with Arthur Speed " +
                                    "4015 Connolly Street",
                                    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);



        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_favorites:

                            case R.id.action_schedules:

                            case R.id.action_music:

                        }
                        return true;
                    }
                });


        // adds hardcoded list into a arraylist
        final ArrayList<String> list = new ArrayList<String>();
        for(int i=0 ; i < items.length; i++)
        {
            list.add(items[i]);
        }

        ArrayAdapter<String> adapter;

        adapter = new ArrayAdapter<String>(this,R.layout.row_red_layout, list);
        adapter.notifyDataSetChanged();
        final ListView listview = (ListView)findViewById(R.id.list_view);
        
        listview.setAdapter(adapter);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       // getMenuInflater().inflate(R.menu., menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_favorites) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    private class StableArrayAdapter extends BaseAdapter {
        private LayoutInflater inflater;
        ArrayList<HashMap<String, String>> data = null;


        public StableArrayAdapter(Context context, ArrayList<HashMap<String, String>> data) {
            inflater = LayoutInflater.from(context);

        }

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            MessageHolder holder = null;
            if(position == 0)
            {
                LayoutInflater inflater = getLayoutInflater();
                convertView = inflater.inflate(R.layout.row_green_layout, parent, false);
                holder = new MessageHolder();

                holder.txtMsg = (TextView)convertView.findViewById(R.id.txtMsg);
                convertView.setTag(holder);
            }
            else
            {
                LayoutInflater inflater = getLayoutInflater();
                convertView = inflater.inflate(R.layout.row_red_layout, parent, false);
                holder = new MessageHolder();

                holder.txtMsg = (TextView)convertView.findViewById(R.id.txtMsg);
                convertView.setTag(holder);
            }

            return convertView;
        }

        class MessageHolder
        {
            TextView txtMsg;
        }
    }




}
