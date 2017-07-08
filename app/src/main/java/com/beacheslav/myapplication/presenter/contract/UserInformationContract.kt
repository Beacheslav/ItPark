package com.beacheslav.myapplication.presenter.contract

interface UserInformationContract{
    interface View{
        fun displayError()
    }
    interface Presenter{
        fun onNewsClick()
    }
}