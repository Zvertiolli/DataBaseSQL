package space.alehandrozed.databasesql

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import space.alehandrozed.databasesql.db.MYDBManager

class MainActivity : AppCompatActivity() {
    val mydbManager = MYDBManager(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        mydbManager.openDB()
        val dataList = mydbManager.readDBData()
        for (item in dataList) {
            tvTest.append(item.title + " - " + item.context + "\n")
        }
    }

    fun onClickSave(view: View) {
        tvTest.text = ""
        mydbManager.insertToDB(edTitle.text.toString(), edContent.text.toString())

        val dataList = mydbManager.readDBData()
        for (item in dataList) {
            tvTest.append(item.title + " - " + item.context + "\n")
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        mydbManager.closeDB()
    }
}