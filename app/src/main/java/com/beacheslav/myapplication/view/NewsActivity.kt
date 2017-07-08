package com.beacheslav.myapplication.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.beacheslav.myapplication.R
import com.beacheslav.myapplication.presenter.NewsPresenter
import com.beacheslav.myapplication.presenter.contract.NewsContract
import com.google.gson.JsonParser
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_news.*
import kotlinx.android.synthetic.main.item_news.*
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import org.jetbrains.anko.longToast
import java.util.concurrent.TimeUnit

class NewsActivity : AppCompatActivity() {

    class New(
            val title: String,
            val text: String,
            val image: String
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        Observable.create<List<New>> {emitter ->

            val client = OkHttpClient.Builder()
                    .readTimeout(100000L, TimeUnit.MILLISECONDS)
                    .build()

            val request = Request.Builder()
                    .url("https://api.myjson.com/bins/a829r")
                    .get()
                    .build()
            val result = client.newCall(request).execute().body().string()

            val resultJson = JsonParser().parse(result).asJsonObject
            val code = resultJson["code"].asInt

//            val news = mutableListOf<New>()

            val responseArray = resultJson["response"].asJsonArray
            val news = responseArray.map{ el ->

                val newJson = el.asJsonObject

                val title = newJson["title"].asString
                val text = newJson["text"].asString
                val image = newJson["image"].asString

                New(title, text, image)
            }

            emitter.onNext(news)
        }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{ news ->
                    val adapter = NewsAdapter()
                    adapter.setData(news)
                    recyclerView.adapter = adapter
                    recyclerView.layoutManager = LinearLayoutManager(this)
                }

//        Observable.create<List<New>>{
//            emitter ->
//
//            emitter.onNext()
//        }
//
//        Observable.just(1).
//                flatMap {i ->
//                    Observable.just("" + 1)
//                }
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe{ r ->
//                    Log.e("NewsActivity", r)
//                }
    }
}
