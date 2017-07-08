package com.beacheslav.myapplication.presenter

import android.app.Activity
import com.beacheslav.myapplication.presenter.contract.LoginContract
import com.beacheslav.myapplication.presenter.navigator.LoginNavigator

class LoginPresenter(
        private val view: LoginContract.View,
        activity: Activity) : LoginContract.Presenter {

    private val navigator = LoginNavigator(activity)

    override fun onLoginClick(login: String, password: String) {
        navigator.toUserInformation()
    }

    override fun onRegistrationClick() {
        navigator.toRegistration()
    }

}