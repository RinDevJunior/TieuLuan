package com.example.rinnv.tieuluancnpm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createDB();


        SQLiteDataController db = new SQLiteDataController(this);


        final ListView listView_Maintopic = (ListView) findViewById(R.id.list_item);
        Adapter_Maintopic adapterMaintopic = new Adapter_Maintopic(this, db.getListMainTopic());
        listView_Maintopic.setAdapter(adapterMaintopic);
        listView_Maintopic.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Maintopic maintopic = (Maintopic) listView_Maintopic.getItemAtPosition(position);
                SaveObject.saveMaintopic = maintopic;

                Intent intent = new Intent(MainActivity.this, Topic_Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                startActivity(intent);
            }
        });


    }

    private void createDB() {
        SQLiteDataController sql = new SQLiteDataController(this);
        try {
            sql.isCreatedDatabase();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
