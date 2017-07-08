package com.beacheslav.myapplication.view

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.beacheslav.myapplication.R
import com.beacheslav.myapplication.presenter.UserInformationPresenter
import com.beacheslav.myapplication.presenter.contract.UserInformationContract
import kotlinx.android.synthetic.main.activity_user_information.*
import org.jetbrains.anko.longToast
import org.jetbrains.anko.sdk15.listeners.onClick

class UserInformationActivity : UserInformationContract.View,  AppCompatActivity() {

    private val presenter : UserInformationContract.Presenter = UserInformationPresenter(this, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_information)

        newsButton.onClick {
            presenter.onNewsClick()
        }
    }

    override fun displayError() {
        longToast(R.string.error)
    }

}
