package com.beacheslav.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_news.*
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
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
                .readTimeout(100000L, TimeUnit.MILLISECONDS)
                .build()

        val task1 = Runnable{

            try {
                val request = Request.Builder()
                        .url("https://api.myjson.com/bins/a829r")
                        .get()
                        .build()
                val result = client.newCall(request).execute().body().string()
            } catch(e: Exception) {
                Toast.makeText(this@NewsActivity, "OOPS...(1)", Toast.LENGTH_SHORT).show()
            }

        }
        val task2 = Runnable{

            try {
                val request = Request.Builder()
                        .url("https://bash.im/index/1269?count=2&offset=14")
                        .get()
                        .build()
                val result = client.newCall(request).execute().body().string()
            } catch(e: Exception) {
                Toast.makeText(this@NewsActivity, "OOPS...(2)", Toast.LENGTH_SHORT).show()
            }

        }
        val task3 = Runnable{

            try {
                val name = "что то отправляем"
                val body = RequestBody.create(MediaType.parse("application/nameList; charset=utf-8"), name)
                val request = Request.Builder()
                        .url("https://api.myjson.com/bins/a829r")
                        .post(body)
                        .build()
                val result = client.newCall(request).execute().body().string()
            } catch(e: Exception) {
                Toast.makeText(this@NewsActivity, "OOPS...(3)", Toast.LENGTH_SHORT).show()
            }

        }

        task1.run()
        task2.run()
        task3.run()

        val data =
                listOf(
                        New("123", "312"),
                        New("12345", "3223"),
                        New("12311", "322"),
                        New("123", "312")
                )

        val adapter = NewsAdapter()
        adapter.setData(data)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}
