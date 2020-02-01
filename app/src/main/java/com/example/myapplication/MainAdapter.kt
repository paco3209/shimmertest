package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_row.view.*

class MainAdapter(private val context: Context) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    private var datalist = mutableListOf<User>()

    fun setListData(data: MutableList<User>){

        datalist = data

    }

    inner class MainViewHolder(itemview: View): RecyclerView.ViewHolder(itemview){

        fun bindView(user: User){
            Glide.with(context)
                .load(user.imageUrl)
                .into(itemView.circleImageView)

            itemView.txt_title.text = user.nombre
            itemView.txt_desc.text = user.descripcion

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_row,parent, false)
        return MainViewHolder(view)
    }

    override fun getItemCount(): Int {
      return datalist.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val user: User = datalist[position]
        holder.bindView(user)

    }

}
