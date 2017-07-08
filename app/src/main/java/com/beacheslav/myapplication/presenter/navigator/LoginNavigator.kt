package com.beacheslav.myapplication.presenter.navigator

import android.app.Activity
import com.beacheslav.myapplication.view.NewsActivity
import com.beacheslav.myapplication.view.RegistrationActivity
import com.beacheslav.myapplication.view.UserInformationActivity
import org.jetbrains.anko.startActivity

class LoginNavigator(
        private val activity: Activity) {

    fun toUserInformation() {
        activity.startActivity<UserInformationActivity>()
    }

    fun toRegistration() {
        activity.startActivity<RegistrationActivity>()
    }

}