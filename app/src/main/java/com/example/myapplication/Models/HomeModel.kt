package com.example.myapplication.Models

object HomeModel {
    data class HomeMomdel(var title:String, var sub_title: String)

    object Home_type{
        val TYPE_BANNER =1
        val TYPE_MENU = 2
        val TYPE_CATEGORY = 3
        val TYPE_GOODS = 4
        val TYPE_DRINK = 5
    }

    data class HomeBaner (val id: Int)
    data class HomeMenu (val id: Int)
    data class HomeCategory (val id: Int)
    data class HomeGoods (val id: Int)
    data class HomeDrink (val id: Int)

}