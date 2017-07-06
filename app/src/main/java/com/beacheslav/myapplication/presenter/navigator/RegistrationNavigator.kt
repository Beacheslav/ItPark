package com.beacheslav.myapplication.presenter.navigator

import android.app.Activity

class RegistrationNavigator(
        private val activity: Activity) {

    fun toLogin() {
        activity.finish()
    }

}