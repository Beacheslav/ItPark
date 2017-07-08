package com.beacheslav.myapplication.presenter

import android.app.Activity
import com.beacheslav.myapplication.presenter.contract.UserInformationContract
import com.beacheslav.myapplication.presenter.navigator.UserInformationNavigator

class UserInformationPresenter(view : UserInformationContract.View, activity : Activity) : UserInformationContract.Presenter{

    private val navigator = UserInformationNavigator(activity)

    override fun onNewsClick() {
        navigator.toNews()
    }
}