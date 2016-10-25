package com.example.rinnv.tieuluancnpm;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Topic_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Maintopic Maintopic_choosen = SaveObject.saveMaintopic;
        setTitle(Maintopic_choosen.getMaintopic_Tittle() +" - " +Maintopic_choosen.getMaintopic_Tittle_VN());


        SQLiteDataController db = new SQLiteDataController(this);
        final ListView listView_Topic = (ListView) findViewById(R.id.list_item);
        Adapter_Topic adapter_topic = new Adapter_Topic(this,db.getListTopic(Maintopic_choosen));
        listView_Topic.setAdapter(adapter_topic);

        listView_Topic.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SaveObject.saveTopic = (Topic) listView_Topic.getItemAtPosition(position);

                Intent intent = new Intent(Topic_Activity.this, Word_Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }
        });


    }

}
