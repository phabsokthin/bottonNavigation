package com.example.myapplication.Fragment

import android.os.Bundle
import android.util.Size
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Adapter.HomeAdapter
import com.example.myapplication.Models.HomeModel
import com.example.myapplication.R

class HomeFragment: Fragment(R.layout.home_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val itemList = getDummyList(100)
        val adapter = HomeAdapter(itemList, requireContext())
        val recyclerView = view.findViewById<RecyclerView>(R.id.home_recycler)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)

    }
    private fun getDummyList(size: Int): MutableList<Any>{

        val list = ArrayList<Any>()

        list.add(HomeModel.HomeBaner(1))
        list.add(HomeModel.HomeMenu(1))
        list.add(HomeModel.HomeCategory(1))
        list.add(HomeModel.HomeGoods(1))
        list.add(HomeModel.HomeDrink(1))


        return list

    }

}