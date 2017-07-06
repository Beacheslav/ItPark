package com.beacheslav.myapplication.presenter.contract

import android.app.Activity
import com.beacheslav.myapplication.presenter.contract.RegistrationContract
import com.beacheslav.myapplication.presenter.navigator.RegistrationNavigator

class RegistrationPresenter(
        private val view: RegistrationContract.View,
        activity: Activity) : RegistrationContract.Presenter {

    private val navigator = RegistrationNavigator(activity)

    override fun onRegistrationClick(fName: String, lName: String, login: String, password: String) {
        navigator.toLogin()
    }

}