package com.beacheslav.myapplication.presenter.navigator

import android.app.Activity
import com.beacheslav.myapplication.view.CommentsActivity
import org.jetbrains.anko.startActivity

class NewsNavigator(private val activity : Activity){
    fun toComments(){
        activity.startActivity<CommentsActivity>()
    }
}