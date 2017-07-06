package com.beacheslav.myapplication.view

import android.net.sip.SipAudioCall
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.beacheslav.myapplication.R
import com.beacheslav.myapplication.presenter.contract.RegistrationContract
import com.beacheslav.myapplication.presenter.contract.RegistrationPresenter
import kotlinx.android.synthetic.main.activity_register.*

class RegistrationActivity : RegistrationContract.View, AppCompatActivity() {

    private val presenter: RegistrationContract.Presenter = RegistrationPresenter(this, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        finalRegisterButton.onClick {
            presenter.onRegistrationClick(
                    editNameRegister.text.toString(),
                    editFamilyRegister.text.toString(),
                    editLoginRegister.text.toString(),
                    editPasswordRegister.text.toString())
        }
    }

    override fun displayError() {
        longToast(R.string.error)
    }

}
