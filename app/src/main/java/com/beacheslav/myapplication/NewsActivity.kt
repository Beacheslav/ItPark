package com.beacheslav.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_news.*
import okhttp3.OkHttpClient
import okhttp3.Request
import java.util.concurrent.TimeUnit

class NewsActivity : AppCompatActivity() {

    class New(
        val title: String,
        val text: String
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        val client = OkHttpClient.Builder()
                .readTimeout(1000L, TimeUnit.MILLISECONDS)
                .build()

        val task = Runnable{

            val request = Request.Builder()
                    .url("https://api.myjson.com/bins/a829r")
                    .build()
            val result = client.newCall(request).execute().body().string()

            Log.e("NewsActivity" , "Thread")

        }

        val data =
                listOf(
                        New("123", "312"),
                        New("12345", "3223"),
                        New("12311", "322"),
                        New("123", "312"),
                        New("12345", "3223"),
                        New("12311", "322"),
                        New("123", "312"),
                        New("12345", "3223"),
                        New("12311", "322"),
                        New("123", "312"),
                        New("12345", "3223"),
                        New("12311", "322"),
                        New("123", "312"),
                        New("12345", "3223"),
                        New("12311", "322"),
                        New("123", "312"),
                        New("12345", "3223"),
                        New("12311", "322"),
                        New("123", "312"),
                        New("12345", "3223"),
                        New("12311", "322"),
                        New("123", "312"),
                        New("12345", "3223"),
                        New("12311", "322"),
                        New("123", "312"),
                        New("12345", "3223"),
                        New("12311", "322"),
                        New("123", "312"),
                        New("12345", "3223"),
                        New("12311", "322"),
                        New("123", "312"),
                        New("12345", "3223"),
                        New("12311", "322"),
                        New("123", "312"),
                        New("12345", "3223"),
                        New("12311", "322"),
                        New("123", "312"),
                        New("12345", "3223"),
                        New("12311", "322"),
                        New("123", "312"),
                        New("12345", "3223"),
                        New("12311", "322"),
                        New("123", "312"),
                        New("12345", "3223"),
                        New("12311", "322"),
                        New("123", "312"),
                        New("12345", "3223"),
                        New("12311", "322"),
                        New("123", "312"),
                        New("12345", "3223"),
                        New("12311", "322"),
                        New("123", "312"),
                        New("12345", "3223"),
                        New("12311", "322"),
                        New("123", "312"),
                        New("12345", "3223"),
                        New("12311", "322"),
                        New("123", "312"),
                        New("12345", "3223"),
                        New("12311", "322"),
                        New("123", "312"),
                        New("12345", "3223"),
                        New("12311", "322"),
                        New("123", "312"),
                        New("12345", "3223"),
                        New("12311", "322"),
                        New("123", "312"),
                        New("12345", "3223"),
                        New("12311", "322"),
                        New("123", "312"),
                        New("12345", "3223"),
                        New("12311", "322"),
                        New("123", "312"),
                        New("12345", "3223"),
                        New("12311", "322"),
                        New("123", "312"),
                        New("12345", "3223"),
                        New("12311", "322"),
                        New("123", "312"),
                        New("12345", "3223"),
                        New("12311", "322"),
                        New("123", "312"),
                        New("12345", "3223"),
                        New("12311", "322")
                )

        val adapter = NewsAdapter()
        adapter.setData(data)
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(this)
    }
}
