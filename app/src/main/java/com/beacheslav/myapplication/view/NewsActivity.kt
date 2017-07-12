package com.beacheslav.myapplication.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.beacheslav.myapplication.R
import com.beacheslav.myapplication.db
import com.beacheslav.myapplication.model.entity.New
import com.beacheslav.myapplication.model.entity.User
import com.beacheslav.myapplication.presenter.NewsPresenter
import com.beacheslav.myapplication.presenter.contract.NewsContract
import com.google.gson.JsonParser
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_news.*
import okhttp3.OkHttpClient
import okhttp3.Request
import org.jetbrains.anko.longToast
import java.util.concurrent.TimeUnit

class NewsActivity : NewsContract.View, AppCompatActivity() {

    val presenter : NewsContract.Presenter = NewsPresenter(this, this)

    override fun displayError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class News(
            val newId: Int,
            val title: String,
            val text: String,
            val image: String
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        Observable.create<List<News>> {emitter ->

            val client = OkHttpClient.Builder()
                    .readTimeout(1000L, TimeUnit.MILLISECONDS)
                    .build()

            val request = Request.Builder()
                    .url("http://207.254.71.167:8083/park/news")
                    .get()
                    .build()
            val result = client.newCall(request).execute().body().string()

            val resultJson = JsonParser().parse(result).asJsonObject
            val code = resultJson["code"].asInt

//            val news = mutableListOf<New>()

            val responseArray = resultJson["response"].asJsonArray
            val news = responseArray.map{ el ->

                val newJson = el.asJsonObject

                val titleJs = newJson["title"].asString
                val textJs = newJson["content"].asString
                val imageJs = newJson["image"].asString
                val newIdJs = newJson["id"].asInt
                val userLoginJs = newJson["userLogin"].asString

                val new =
                        New().apply {
                            id = newIdJs.toLong()
                            title = titleJs
                            content = textJs
                            image = imageJs
                            userLogin = userLoginJs
                        }

                db.newDao().insert(new)
                db.userDao().all()

                News(newIdJs, titleJs, textJs, imageJs)
            }

            emitter.onNext(news)
        }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{ news ->
                    val adapter = NewsAdapter(presenter)
                    adapter.setData(news)
                    recyclerView.adapter = adapter
                    recyclerView.layoutManager = LinearLayoutManager(this)
                }
    }
}
