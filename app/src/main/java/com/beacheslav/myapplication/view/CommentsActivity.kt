package com.beacheslav.myapplication.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.beacheslav.myapplication.R

class CommentsActivity : AppCompatActivity() {

    var newId : Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comments)

        val intent : Intent? = intent
        if(intent != null) {
            newId = intent.getIntExtra("KEY_NEW_ID", 0)
        }
    }
}