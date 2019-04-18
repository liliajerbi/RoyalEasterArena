package com.example.royaleasterarena;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final List<Warrior> warriorList = new ArrayList<>();
        ListView listViewWarrior = findViewById(R.id.lvWarrior);
        final WarriorAdapter adapter = new WarriorAdapter(MainActivity.this, warriorList);
        listViewWarrior.setAdapter(adapter);


            Easter.extractWarrior(MainActivity.this, new Easter.WarriorListener() {
                @Override
                public void onWarriors(List<Warrior> warriors) {
                    warriorList.addAll(warriors);
                    adapter.notifyDataSetChanged();
                }
            });



    }
}
