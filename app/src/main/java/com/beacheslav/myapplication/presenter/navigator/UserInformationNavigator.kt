package com.beacheslav.myapplication.presenter.navigator

import android.app.Activity
import com.beacheslav.myapplication.view.NewsActivity
import org.jetbrains.anko.startActivity

class UserInformationNavigator (private val activity : Activity){
    fun toNews(){
        activity.startActivity<NewsActivity>()
    }
}