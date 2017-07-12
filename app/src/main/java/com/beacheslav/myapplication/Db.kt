package com.beacheslav.myapplication

import com.beacheslav.myapplication.model.entity.UserDao
import android.arch.persistence.room.RoomDatabase
import com.beacheslav.myapplication.model.entity.User
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import com.beacheslav.myapplication.model.entity.NewDao


val db = Room.databaseBuilder(appContext!!, Db::class.java, "db").build()

@Database(entities = arrayOf(User::class), version = 1)
abstract class Db : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun newDao(): NewDao
}
