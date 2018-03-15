package com.health.database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.security.PrivateKey;

import javax.xml.namespace.NamespaceContext;

/**
 * Created by Owner's on 3/13/2018.
 */

public class DB extends SQLiteOpenHelper {

   private static final String dataBase_Name = "ABS";
   private static final String tableName = "Health";
   private static final int dataBase_Version = 1;
   private static final String UID = "id";
   private static final String names = "Name";
   private static final String DROP_TABLE = "DROP TABLE ID EXISTS"+tableName;
   private static final String CREATE_TABLE = "C0REATE TABLE "+tableName+
           " ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+names+" VARCHAR(255));";
   private Context context;

    public DB(Context context) {
        super(context, dataBase_Name,null, dataBase_Version);
        this.context = context;
        Toast.makeText(context,"this is constructor",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
        db.execSQL(CREATE_TABLE);
            Toast.makeText(context,"onCreate Method",Toast.LENGTH_LONG).show();
    }catch (SQLException e){
            Toast.makeText(context,"due to: "+e,Toast.LENGTH_LONG).show();
        }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            try{
                Toast.makeText(null,"onUpgrade Method",Toast.LENGTH_LONG).show();

                db.execSQL(DROP_TABLE);
                onCreate(db);
            }catch (SQLException e){
                Toast.makeText(context,"due to: "+e,Toast.LENGTH_LONG).show();
            }
    }
}
