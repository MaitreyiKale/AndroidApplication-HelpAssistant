package com.example.project.MedicalStore;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.project.DatabaseOpenHelper;

import java.util.ArrayList;

public class DatabaseAccessM {
    private SQLiteOpenHelper sqLiteOpenHelper;
    private SQLiteDatabase db;
    private static DatabaseAccessM instance;
    Cursor c = null;
    ArrayList<String> All;
    ArrayList<String> cont = new ArrayList<>();
    ArrayList<String> locAll = new ArrayList<>();
    int count = 0;

    private DatabaseAccessM(Context context) {
        this.sqLiteOpenHelper = new DatabaseOpenHelper(context);
    }

    public static DatabaseAccessM getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccessM(context);
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
        c = db.rawQuery("select count(*) from MedicalStore", new String[]{});
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


        c = db.rawQuery("select * from MedicalStore where Area='"+area+"'", new String[]{});
        while (c.moveToNext()) {
            MedicalStoreObject medicalStoreObject = new MedicalStoreObject();
            String NameM = c.getString(2);
            String AddressM = c.getString(3);
            String ContactM = c.getString(4);
            locAll.add(AddressM);
            cont.add(ContactM);
            medicalStoreObject.getAll(NameM,AddressM,ContactM);
            All.add(medicalStoreObject.toString());
        }
        c=null;
        return All;

    }
}