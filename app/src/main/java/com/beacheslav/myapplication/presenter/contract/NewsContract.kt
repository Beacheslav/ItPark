package com.beacheslav.myapplication.presenter.contract

interface NewsContract{
    interface View {
        fun displayError()
    }
    interface Presenter {
        fun onCommentsClick()
    }
}