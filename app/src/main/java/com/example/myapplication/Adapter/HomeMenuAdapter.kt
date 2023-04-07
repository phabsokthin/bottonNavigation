package com.example.myapplication.Adapter

import android.content.Context
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import com.example.myapplication.ProductMenu.BurgerMainActivity
import com.example.myapplication.ProductMenu.PizzarMainActivity
import com.example.myapplication.R

class HomeMenuAdapter(private val list: MutableList<Any>, private val context: Context) :RecyclerView.Adapter<RecyclerView.ViewHolder> (){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val itemView:View = LayoutInflater.from(parent.context).inflate(R.layout.item_home_menu, parent, false)
        return HomeMenuViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        holder.itemView.setOnClickListener{

           if (position == 0){
               val itemView = Intent(context, PizzarMainActivity::class.java)
               context.startActivity(itemView)
           }else if (position == 1){
               val itemView = Intent(context, BurgerMainActivity::class.java)
               context.startActivity(itemView)
           }

        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class HomeMenuViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    }
}