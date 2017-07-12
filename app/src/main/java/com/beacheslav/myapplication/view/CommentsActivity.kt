package com.beacheslav.myapplication.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.beacheslav.myapplication.R
import com.beacheslav.myapplication.db
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_comments.*

class CommentsActivity : AppCompatActivity() {

    companion object {
        const val KEY_NEW_ID = "com.beacheslav.myapplication.view.KEY_NEW_ID"
    }

    var newId : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comments)

        newId = intent.getIntExtra(KEY_NEW_ID, 0)

        val contentList = db.newDao().equalsId(newId.toLong())

        titleNewComments.text = contentList[0].title
        textNewComments.text = contentList[0].content
        Glide.with(this).
                load(contentList[0].image).
                into(imageNewComments)
    }
}