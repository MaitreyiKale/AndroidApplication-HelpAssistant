package com.example.project;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.project.Hospital.DatabaseAccess;
import com.example.project.Hospital.MainAdapter;
import com.example.project.MedicalStore.DatabaseAccessM;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public Button Hbutton;
    public Button Mbutton;
    public Button notes;
    public RecyclerView recyclerView;
    public RecyclerView.LayoutManager layoutManager;
    public RecyclerView.Adapter adapter1;
    public ImageView hospitalicon;
    public String area;
    //  DrawerLayout drawer = findViewById(R.id.drawerlayout);




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Hbutton = findViewById(R.id.Hbutton);

        Mbutton = findViewById(R.id.Mbutton);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        notes = findViewById(R.id.notes);

      /*  Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
*/

        final Spinner spinner = (Spinner) findViewById(R.id.hospSpinner);
        spinner.bringToFront();
        final ArrayAdapter<CharSequence> adaptersp = ArrayAdapter.createFromResource(this, R.array.Area, android.R.layout.simple_spinner_dropdown_item);

        adaptersp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adaptersp);

        final int[] check = {0};

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spinner.setSelection(i, false);
                if (++check[0] > 1) {

                    switch (i) {
                        case 1:

                            DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
                            databaseAccess.open();

                            ArrayList<String> dispAll = databaseAccess.getData("Kothrud");
                            ArrayList<String> contAll = databaseAccess.getContact();
                            ArrayList<String> locAll = databaseAccess.getLocation();
                            RecyclerView.Adapter adapter;
                            adapter = new MainAdapter(dispAll, contAll, locAll);
                            recyclerView.setLayoutManager(layoutManager);
                            recyclerView.setAdapter(adapter);
                            break;
                        case 2:
                            databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
                            databaseAccess.open();
                            dispAll = databaseAccess.getData("KasbaPeth");
                            contAll = databaseAccess.getContact();
                            locAll = databaseAccess.getLocation();
                            //RecyclerView.Adapter adapter;
                            adapter = new MainAdapter(dispAll, contAll, locAll);
                            recyclerView.setLayoutManager(layoutManager);
                            recyclerView.setAdapter(adapter);
                            break;
                        case 3:
                            databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
                            databaseAccess.open();
                            dispAll = databaseAccess.getData("Shivajinagar");
                            contAll = databaseAccess.getContact();
                            locAll = databaseAccess.getLocation();
                            //RecyclerView.Adapter adapter;
                            adapter = new MainAdapter(dispAll, contAll, locAll);
                            recyclerView.setLayoutManager(layoutManager);
                            recyclerView.setAdapter(adapter);

                            break;

                        case 4:
                            databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
                            databaseAccess.open();
                            dispAll = databaseAccess.getData("VadgaonSheri");
                            contAll = databaseAccess.getContact();
                            locAll = databaseAccess.getLocation();
                            //RecyclerView.Adapter adapter;
                            adapter = new MainAdapter(dispAll, contAll, locAll);
                            recyclerView.setLayoutManager(layoutManager);
                            recyclerView.setAdapter(adapter);

                            break;
                        case 5:
                            databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
                            databaseAccess.open();
                            dispAll = databaseAccess.getData("PuneCantonment");
                            contAll = databaseAccess.getContact();
                            locAll = databaseAccess.getLocation();
                            //RecyclerView.Adapter adapter;
                            adapter = new MainAdapter(dispAll, contAll, locAll);
                            recyclerView.setLayoutManager(layoutManager);
                            recyclerView.setAdapter(adapter);

                            break;
                        case 6:
                            databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
                            databaseAccess.open();
                            dispAll = databaseAccess.getData("Parvati");
                            contAll = databaseAccess.getContact();
                            locAll = databaseAccess.getLocation();
                            //RecyclerView.Adapter adapter;
                            adapter = new MainAdapter(dispAll, contAll, locAll);
                            recyclerView.setLayoutManager(layoutManager);
                            recyclerView.setAdapter(adapter);

                            break;

                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });
        /*---------------------------------------------------------------------------*/


        final Spinner medspinner = (Spinner) findViewById(R.id.medSpinner);
        medspinner.bringToFront();
        final ArrayAdapter<CharSequence> adaptermed = ArrayAdapter.createFromResource(this, R.array.AreaMed, android.R.layout.simple_spinner_dropdown_item);

        adaptersp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        medspinner.setAdapter(adaptermed);

        final int[] checkm = {0};

        medspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                medspinner.setSelection(i, false);
                if (++checkm[0] > 1) {

                    switch (i) {
                        case 1:

                            DatabaseAccessM databaseAccessM = DatabaseAccessM.getInstance(getApplicationContext());
                            databaseAccessM.open();

                            ArrayList<String> dispAll = databaseAccessM.getData("Kothrud");
                            ArrayList<String> contAll = databaseAccessM.getContact();
                            ArrayList<String> locAll = databaseAccessM.getLocation();
                            RecyclerView.Adapter adapter;
                            adapter = new MainAdapter(dispAll, contAll, locAll);
                            recyclerView.setLayoutManager(layoutManager);
                            recyclerView.setAdapter(adapter);
                            break;
                        case 2:
                            databaseAccessM = DatabaseAccessM.getInstance(getApplicationContext());
                            databaseAccessM.open();
                            dispAll = databaseAccessM.getData("KasbaPeth");
                            contAll = databaseAccessM.getContact();
                            locAll = databaseAccessM.getLocation();
                            //RecyclerView.Adapter adapter;
                            adapter = new MainAdapter(dispAll, contAll, locAll);
                            recyclerView.setLayoutManager(layoutManager);
                            recyclerView.setAdapter(adapter);
                            break;
                        case 3:
                            databaseAccessM = DatabaseAccessM.getInstance(getApplicationContext());
                            databaseAccessM.open();
                            dispAll = databaseAccessM.getData("Shivajinagar");
                            contAll = databaseAccessM.getContact();
                            locAll = databaseAccessM.getLocation();
                            //RecyclerView.Adapter adapter;
                            adapter = new MainAdapter(dispAll, contAll, locAll);
                            recyclerView.setLayoutManager(layoutManager);
                            recyclerView.setAdapter(adapter);

                            break;

                        case 4:
                            databaseAccessM = DatabaseAccessM.getInstance(getApplicationContext());
                            databaseAccessM.open();
                            dispAll = databaseAccessM.getData("VadgaonSheri");
                            contAll = databaseAccessM.getContact();
                            locAll = databaseAccessM.getLocation();
                            //RecyclerView.Adapter adapter;
                            adapter = new MainAdapter(dispAll, contAll, locAll);
                            recyclerView.setLayoutManager(layoutManager);
                            recyclerView.setAdapter(adapter);

                            break;
                        case 5:
                            databaseAccessM = DatabaseAccessM.getInstance(getApplicationContext());
                            databaseAccessM.open();
                            dispAll = databaseAccessM.getData("PuneCantonment");
                            contAll = databaseAccessM.getContact();
                            locAll = databaseAccessM.getLocation();
                            //RecyclerView.Adapter adapter;
                            adapter = new MainAdapter(dispAll, contAll, locAll);
                            recyclerView.setLayoutManager(layoutManager);
                            recyclerView.setAdapter(adapter);

                            break;
                        case 6:
                            databaseAccessM = DatabaseAccessM.getInstance(getApplicationContext());
                            databaseAccessM.open();
                            dispAll = databaseAccessM.getData("Parvati");
                            contAll = databaseAccessM.getContact();
                            locAll = databaseAccessM.getLocation();
                            //RecyclerView.Adapter adapter;
                            adapter = new MainAdapter(dispAll, contAll, locAll);
                            recyclerView.setLayoutManager(layoutManager);
                            recyclerView.setAdapter(adapter);

                            break;

                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });


        notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, UserActivity.class);
                startActivity(i);
            }
        });



    }

      /*  public void onBackPressed(){
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }*/
}




