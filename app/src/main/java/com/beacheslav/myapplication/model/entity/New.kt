package com.beacheslav.myapplication.model.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


@Entity(tableName = "news")
class New {

    @PrimaryKey
    var id: Long = 0

    var title : String = ""
    var content : String = ""
    var image : String = ""
    var userLogin : String = ""
}