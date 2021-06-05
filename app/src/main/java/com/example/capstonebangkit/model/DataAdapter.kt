package com.example.capstonebangkit.model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.capstonebangkit.R
import kotlinx.android.synthetic.main.cardview__.view.*

class DataAdapter (private val lists: ArrayList<DataInformation>, val context: Context) : RecyclerView.Adapter<DataAdapter.DataHolder>(){
    inner class DataHolder(view: View) : RecyclerView.ViewHolder(view){
        fun bind(dataInformation: DataInformation){
            with(itemView){
                Glide.with(itemView.context)
                        .load(dataInformation.img)
                        .apply(RequestOptions().override(200,150))
                        .into(image__)
                judul_list.text = dataInformation.judul
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataAdapter.DataHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.cardview__, parent, false)
        return DataHolder(v)
    }

    override fun onBindViewHolder(holder: DataAdapter.DataHolder, position: Int) {
        val data = lists[position]
        Glide.with(holder.itemView.context)
                .load(data.img)
                .apply(RequestOptions().override(200,150))
        holder.bind(lists[position])
    }

    override fun getItemCount(): Int = lists.size
}