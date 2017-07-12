package com.beacheslav.myapplication.model.entity

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface NewDao{

    @Query("SELECT * FROM news")
    fun all(): List<New>

    @Query("SELECT * FROM news WHERE id = :eqId")
    fun equalsId(eqId: Long): List<New>

    @Insert
    fun insert(new : New)
}