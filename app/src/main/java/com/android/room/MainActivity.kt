package com.android.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = AppDatabase(this)

        Thread {
            db.TodoDao().insertAll(TodoEntity(0,"Title", "Content"))
            db.TodoDao().getAll().forEach {
                println("Todo info : $it")
            }
        }.start()

    }
}
