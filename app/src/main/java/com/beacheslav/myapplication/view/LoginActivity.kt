package com.beacheslav.myapplication.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.beacheslav.myapplication.R
import com.beacheslav.myapplication.presenter.contract.LoginContract
import com.beacheslav.myapplication.presenter.LoginPresenter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.longToast
import org.jetbrains.anko.sdk15.listeners.onClick

class LoginActivity : LoginContract.View, AppCompatActivity() {

    private val presenter: LoginContract.Presenter = LoginPresenter(this, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registerButton.onClick {

            presenter.onRegistrationClick()

        }

        signInButton.onClick {

            presenter.onLoginClick(
                    editLogin.text.toString(),
                    editPassword.text.toString())

        }
    }

    override fun displayError() {
        longToast(R.string.error)
    }

}
