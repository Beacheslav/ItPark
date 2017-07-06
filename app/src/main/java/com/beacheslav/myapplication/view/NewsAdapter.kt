package com.beacheslav.myapplication.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.beacheslav.myapplication.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_news.view.*

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.Holder>(){

    var mData : List<NewsActivity.New> = emptyList()
    fun setData(data: List<NewsActivity.New>){
        mData = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = mData[position]
        holder.title.text = item.title
        holder.text.text = item.text

        Glide.with(holder.itemView.context).
                load(item.image).
                into(holder.image)
    }

    class Holder (view : View) : RecyclerView.ViewHolder(view){
        val title : TextView = view.titleNew
        val text : TextView = view.textNew
        val image : ImageView = view.image
    }
}
