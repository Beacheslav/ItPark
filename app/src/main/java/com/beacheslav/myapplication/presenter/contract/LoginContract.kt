package com.beacheslav.myapplication.presenter.contract

interface LoginContract {
    interface View {
        fun displayError()
    }
    interface Presenter {
        fun onLoginClick(login: String, password: String)
        fun onRegistrationClick()
    }
}