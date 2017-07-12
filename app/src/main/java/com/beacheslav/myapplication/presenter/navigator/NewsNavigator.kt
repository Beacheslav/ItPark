package com.beacheslav.myapplication.presenter.navigator

import android.app.Activity
import com.beacheslav.myapplication.view.CommentsActivity
import org.jetbrains.anko.startActivity
import java.security.Key

class NewsNavigator(private val activity : Activity){

    fun toComments(id : Int){
        activity.startActivity<CommentsActivity>("KEY_NEW_ID" to id)
    }
}