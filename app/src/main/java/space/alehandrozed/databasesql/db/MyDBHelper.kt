package space.alehandrozed.databasesql.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import space.alehandrozed.databasesql.db.MyDBNameClass.CREATE_TABLE
import space.alehandrozed.databasesql.db.MyDBNameClass.DATABASE_NAME
import space.alehandrozed.databasesql.db.MyDBNameClass.DATABASE_VERSION
import space.alehandrozed.databasesql.db.MyDBNameClass.SQL_DELETE_TABLE

class MyDBHelper(context: Context):SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(SQL_DELETE_TABLE)
        if (db != null) {
            onCreate(db)
        }

    }

}