package com.example.project;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project.UserFacilityNotes.UserNoteAdapter;

import java.util.ArrayList;


public class UserActivity extends AppCompatActivity {

    public Button addButton;
    public Button showButton;
    public EditText edit;
    public RecyclerView recyclerView;
    public RecyclerView.LayoutManager layoutManager;
    public RecyclerView.Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        addButton=findViewById(R.id.addnote);
        showButton=findViewById(R.id.shownote);
        edit=findViewById(R.id.edit);
        //edit.setVisibility(View.INVISIBLE);
        final UserNotesDatabaseHelper user=new UserNotesDatabaseHelper(this);


        recyclerView=findViewById(R.id.note_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //edit.setVisibility(View.VISIBLE);
                String n=new String();
                n=edit.getText().toString();
                user.insertNote(n);


            }
        });
        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit.setVisibility(View.INVISIBLE);
               //showButton.setVisibility(View.INVISIBLE);
                //addButton.setVisibility(View.INVISIBLE);
                ArrayList<String> note=user.getAllNotes();
                adapter=new UserNoteAdapter(note);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(adapter);

            }
        });








    }
}