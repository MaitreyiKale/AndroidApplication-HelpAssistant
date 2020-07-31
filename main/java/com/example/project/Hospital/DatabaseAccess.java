package com.example.project.Hospital;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.project.DatabaseOpenHelper;

import java.util.ArrayList;

public class DatabaseAccess {
    private SQLiteOpenHelper sqLiteOpenHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess instance;
    Cursor c = null;
    ArrayList<String> All;
    ArrayList<String> cont = new ArrayList<>();
    ArrayList<String> locAll = new ArrayList<>();
    int count = 0;

    private DatabaseAccess(Context context) {
        this.sqLiteOpenHelper = new DatabaseOpenHelper(context);
    }

    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    public void open() {

        this.db = sqLiteOpenHelper.getWritableDatabase();
    }

    public void close() {
        if (db != null) {
            this.db.close();
        }
    }

    public void getProfilesCount() {
        c = db.rawQuery("select count(*) from Hospital", new String[]{});
        while (c.moveToNext())
            count = count + 1;
    }

    public ArrayList<String> getContact() {
        return cont;
    }

   public ArrayList<String> getLocation() {
      return locAll;
    }

    public ArrayList<String> getData(String area) {
        All=new ArrayList<>();
       // locAll=new ArrayList<>();


        c = db.rawQuery("select * from Hospital where Area='"+area+"'", new String[]{});
        while (c.moveToNext()) {
            HospitalObject hospitalObject = new HospitalObject();
            String NameH = c.getString(2);
            String AddressH = c.getString(3);
            String ContactH = c.getString(4);
            locAll.add(AddressH);
            cont.add(ContactH);
            hospitalObject.getAll(NameH,AddressH,ContactH);
            All.add(hospitalObject.toString());
        }
        c=null;
        return All;

    }
}