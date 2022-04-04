package space.alehandrozed.databasesql.db

import android.provider.BaseColumns
import space.alehandrozed.databasesql.db.MyDBNameClass.TABLE_NAME

object MyDBNameClass : BaseColumns {
    const val TABLE_NAME = "my_table"                  // id   title   content
     const val COLUMN_NAME_TITLE = "title"              // 1    sova    bird
     const val COLUMN_NAME_CONTENT = "content"

    const val DATABASE_VERSION = 1
    const val DATABASE_NAME = "MyLessonDB.db"

    const val CREATE_TABLE = "CREATE TABLE If NOT EXIST $TABLE_NAME (" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                "$COLUMN_NAME_TITLE TEXT," +
                "$COLUMN_NAME_CONTENT TEXT)"

     const val SQL_DELETE_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
}

