package com.beacheslav.myapplication.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.beacheslav.myapplication.R
import com.beacheslav.myapplication.presenter.contract.LoginContract
import com.beacheslav.myapplication.presenter.contract.LoginPresenter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.longToast

class MainActivity : LoginContract.View, AppCompatActivity() {

    private val presenter: LoginContract.Presenter = LoginPresenter(this, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registerButton.setOnClickListener(View.OnClickListener {

            presenter.onRegistrationClick()

//            val intent = Intent(this@MainActivity, RegistrationActivity::class.java)
//            startActivity(intent)
        })

        signInButton.setOnClickListener(View.OnClickListener {

            presenter.onLoginClick(
                    editLogin.text.toString(),
                    editPassword.text.toString())

//            val intent = Intent(this@MainActivity, UserInformationActivity::class.java)
//            startActivity(intent)
        })
    }

    override fun displayError() {
        longToast(R.string.error)
    }

}
