package com.example.myapplication.Adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Models.HomeModel
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import android.content.Context
import com.smarteist.autoimageslider.SliderView


class HomeAdapter(private val model:MutableList<Any>, private val context: Context):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return when(viewType){

            HomeModel.Home_type.TYPE_BANNER ->{
                val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_home_banner,parent, false)
                HomeBannerViewHolder(itemView)
            }
            HomeModel.Home_type.TYPE_MENU ->{
                val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_menu_recyclercview,parent, false)
                HomeMenuViewHolder(itemView)
            }

            HomeModel.Home_type.TYPE_CATEGORY ->{

                val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_category_recyclerview, parent, false)
                HomeCategoryViewHolder(itemView)

            }

            HomeModel.Home_type.TYPE_GOODS ->{
                val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_goods_recyclerview, parent, false)
                HomeGoodsViewHolder(itemView)
            }

            HomeModel.Home_type.TYPE_DRINK ->{

                val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_drinks_recyclerview, parent, false)
                HomeDrinksViewHolder(itemView)
            }

            else ->{
                val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_home, parent, false)
                HomeBannerViewHolder(itemView)
            }

        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (getItemViewType(position) == HomeModel.Home_type.TYPE_BANNER){

            val imglist :MutableList<Int> = mutableListOf(

                R.drawable.img,
                R.drawable.img_1,
                R.drawable.img_2,
                R.drawable.img_3
            )

            val sliderAdapter = ImageSliderAdapter(imglist)
            val itemView = (holder as HomeBannerViewHolder)
            itemView.rvBannerSlider.setSliderAdapter(sliderAdapter)
            itemView.rvBannerSlider.isAutoCycle = true
            itemView.rvBannerSlider.scrollTimeInSec = 8
            itemView.rvBannerSlider.startAutoCycle()


        }else if (getItemViewType(position) == HomeModel.Home_type.TYPE_MENU){

            var itemView = (holder as HomeMenuViewHolder)

            itemView.rvMenu.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)

            itemView.rvMenu.adapter = HomeMenuAdapter(list = model,context)
            itemView.rvMenu.setHasFixedSize(true)

        }
        else if (getItemViewType(position) == HomeModel.Home_type.TYPE_CATEGORY){

            var itemView = (holder as HomeCategoryViewHolder)

            itemView.rvCategory.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)
            itemView.rvCategory.adapter = HomeCategoryAdapter(list = model,context)
            itemView.rvCategory.setHasFixedSize(true)

        }
        else if (getItemViewType(position) == HomeModel.Home_type.TYPE_GOODS){
            val itemView = (holder as HomeGoodsViewHolder)

            itemView.rvGoods.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)
            itemView.rvGoods.adapter = HomeGoodsAdapter(list = model, context)
            itemView.rvGoods.setHasFixedSize(true)

        }
        else if (getItemViewType(position) == HomeModel.Home_type.TYPE_DRINK){

            val itemView = (holder as HomeDrinksViewHolder)

            itemView.rvDrinks.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)
            itemView.rvDrinks.adapter = HomeDrinksAdapter(list = model, context)
            itemView.rvDrinks.setHasFixedSize(true)

        }

    }

    override fun getItemViewType(position: Int): Int {

        if (model[position] is HomeModel.HomeBaner){
            return HomeModel.Home_type.TYPE_BANNER
        }else if (model[position] is HomeModel.HomeMenu){
            return HomeModel.Home_type.TYPE_MENU
        }else if (model[position] is HomeModel.HomeCategory){
            return  HomeModel.Home_type.TYPE_CATEGORY
        }else if (model[position] is HomeModel.HomeGoods){
            return HomeModel.Home_type.TYPE_GOODS
        }else if (model[position] is HomeModel.HomeDrink){
            return HomeModel.Home_type.TYPE_DRINK
        }

        return super.getItemViewType(position)

    }

    override fun getItemCount(): Int = model.size


    inner class HomeBannerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val rvBannerSlider:SliderView = itemView.findViewById(R.id.slider)

    }
    inner class HomeMenuViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

       val rvMenu:RecyclerView = itemView.findViewById(R.id.rv_menu)

    }
    inner class HomeCategoryViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
       val rvCategory:RecyclerView = itemView.findViewById(R.id.rv_category)
    }


    inner class HomeGoodsViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val rvGoods:RecyclerView = itemView.findViewById(R.id.rv_goods)
    }

    inner class HomeDrinksViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        val rvDrinks:RecyclerView = itemView.findViewById(R.id.rv_drink)

    }

}