package com.beacheslav.myapplication

import com.beacheslav.myapplication.model.entity.UserDao
import android.arch.persistence.room.RoomDatabase
import com.beacheslav.myapplication.model.entity.User
import android.arch.persistence.room.Database


@Database(entities = arrayOf(User::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}