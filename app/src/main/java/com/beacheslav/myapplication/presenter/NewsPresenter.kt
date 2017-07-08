package com.beacheslav.myapplication.presenter
import android.app.Activity
import com.beacheslav.myapplication.presenter.contract.NewsContract
import com.beacheslav.myapplication.presenter.navigator.NewsNavigator

class NewsPresenter( val view : NewsContract.View,
                     activity : Activity) : NewsContract.Presenter{

    private val navigator = NewsNavigator(activity)

    override fun onCommentsClick() {
        navigator.toComments()
    }
}