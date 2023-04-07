package com.example.myapplication.Adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import com.example.myapplication.R

class HomeDrinksAdapter(private val list: MutableList<Any>, private val context: Context):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_home_drink, parent, false)

        return HomeDrinksViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class HomeDrinksViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

    }

}