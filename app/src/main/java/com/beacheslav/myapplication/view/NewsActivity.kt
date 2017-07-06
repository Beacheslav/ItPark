package com.beacheslav.myapplication.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.beacheslav.myapplication.R
import com.google.gson.JsonParser
import kotlinx.android.synthetic.main.activity_news.*
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
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

        val client = OkHttpClient.Builder()
                .readTimeout(100000L, TimeUnit.MILLISECONDS)
                .build()

        val task1 = Runnable {

            val request = Request.Builder()
                    .url("https://api.myjson.com/bins/a829r")
                    .get()
                    .build()
            val result = client.newCall(request).execute().body().string()

            val resultJson = JsonParser().parse(result).asJsonObject
            val code = resultJson["code"].asInt

            val news = mutableListOf<New>()

            val responseArray = resultJson["response"].asJsonArray
            for (el in responseArray) {
                val newJson = el.asJsonObject

                val title = newJson["title"].asString
                val text = newJson["text"].asString
                val image = newJson["image"].asString

                news.add(
                        New(title, text, image)
                )
            }

            runOnUiThread {
                val adapter = NewsAdapter()
                adapter.setData(news)
                recyclerView.adapter = adapter
                recyclerView.layoutManager = LinearLayoutManager(this)
            }

        }
        val task2 = Runnable {

            val request = Request.Builder()
                    .url("https://bash.im/index/1269?count=2&offset=14")
                    .get()
                    .build()
            val result = client.newCall(request).execute().body().string()

        }
        val task3 = Runnable {

            val name = "что то отправляем"
            val body = RequestBody.create(MediaType.parse("application/nameList; charset=utf-8"), name)
            val request = Request.Builder()
                    .url("https://api.myjson.com/bins/a829r:80")
                    .post(body)
                    .build()
            val result = client.newCall(request).execute().body().string()

        }

        Thread(task1).start()
        Thread(task2).start()
        Thread(task3).start()
    }
}
