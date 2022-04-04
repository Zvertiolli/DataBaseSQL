package space.alehandrozed.databasesql.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MYDBManager(context: Context) {
    val MyDBHelper = MyDBHelper(context)
    var db: SQLiteDatabase? = null

    fun openDB() {
        db = MyDBHelper.writableDatabase
    }

    fun insertToDB(title: String, content: String) {
        val values = ContentValues().apply {
            put(MyDBNameClass.COLUMN_NAME_TITLE, title)
            put(MyDBNameClass.COLUMN_NAME_CONTENT, content)

        }
        db?.insert(MyDBNameClass.TABLE_NAME, null, values)
    }

    fun readDBData(): ArrayList<TitleContent> {
        val dataList = ArrayList<TitleContent>()
        val cursor = db?.query(
            MyDBNameClass.TABLE_NAME, null,
            null, null, null, null, null
        )
        with(cursor) {
            while (this?.moveToNext()!!) {
                val dataText = cursor?.getString(cursor.getColumnIndexOrThrow(MyDBNameClass.COLUMN_NAME_TITLE))
                val dataContext = cursor?.getString(cursor.getColumnIndexOrThrow(MyDBNameClass.COLUMN_NAME_CONTENT))
                val result = TitleContent()
                result.title = dataText.toString()
                result.context = dataContext.toString()
                dataList.add(result)
            }
        }
        cursor?.close()
        return dataList
    }

    fun closeDB() {
        MyDBHelper.close()
    }

}