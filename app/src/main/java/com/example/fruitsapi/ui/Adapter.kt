package com.example.fruitsapi.ui

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fruitsapi.R
import com.example.fruitsapi.model.FruitsInfoItem

class Adapter(val context: Context, var list: MutableList<FruitsInfoItem>) :
    RecyclerView.Adapter<Adapter.MyviewHolder>() {
    class MyviewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var name = view.findViewById<TextView>(R.id.name)
        var calories = view.findViewById<TextView>(R.id.calories)
        var order = view.findViewById<TextView>(R.id.order)
        var carbohydrates = view.findViewById<TextView>(R.id.carbohydrates)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item, parent, false)
        return MyviewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {
        holder.name.text = list[position].name
        holder.calories.text = "${list[position].nutritions.calories} Calories"
        holder.order.text = "${list[position].order} Order"
        holder.carbohydrates.text = "${list[position].nutritions.carbohydrates} Carbohydrates"
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setMovieListItems(listitem: ArrayList<FruitsInfoItem>) {
        this.list = listitem
        notifyDataSetChanged()
    }


}