package com.android.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TodoDao {
    @Query("SELECT * FROM todo_items")
    fun getAll(): List<TodoEntity>

    @Query("SELECT * FROM todo_items WHERE title LIKE :title")
    fun findByTitle(title: String): LiveData<List<TodoEntity>>

    @Insert
    fun insertAll(vararg todo: TodoEntity)

    @Delete
    fun delete(todo: TodoEntity)

    @Update
    fun updateTodo(vararg todos: TodoEntity)
}