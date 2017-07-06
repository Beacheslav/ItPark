package com.beacheslav.myapplication.presenter.navigator

import android.app.Activity
import com.beacheslav.myapplication.view.NewsActivity
import com.beacheslav.myapplication.view.RegistrationActivity
import org.jetbrains.anko.startActivity

class LoginNavigator(
        private val activity: Activity) {

    fun toMain() {
        activity.startActivity<NewsActivity>()
    }

    fun toRegistration() {
        activity.startActivity<RegistrationActivity>()
    }

}