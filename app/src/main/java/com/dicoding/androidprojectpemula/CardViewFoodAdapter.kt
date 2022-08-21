package com.dicoding.androidprojectpemula

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import java.text.DecimalFormat
import java.text.NumberFormat

class CardViewFoodAdapter(private val listFood: ArrayList<Food>) : RecyclerView.Adapter<CardViewFoodAdapter.CardViewViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_cardview_food, parent, false)
        return CardViewViewHolder(view)
    }
    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        val food = listFood[position]

        Glide.with(holder.itemView.context)
            .load(food.photo)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPhoto)

        holder.tvName.text = food.name
        holder.tvDetail.text = food.detail
        val formatter: NumberFormat = DecimalFormat("#,###")
        val myNumber = food.price
        val formattedNumber: String = formatter.format(myNumber)
        holder.btnBuy.text = String.format(holder.itemView.context.getString(R.string.buy), formattedNumber)
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(holder.bindingAdapterPosition) }
        holder.btnBuy.setOnClickListener { onItemClickCallback.onBuyClicked(listFood[holder.bindingAdapterPosition]) }
        holder.btnShare.setOnClickListener { onItemClickCallback.onShareClicked(listFood[holder.bindingAdapterPosition]) }
    }

    override fun getItemCount(): Int {
        return listFood.size
    }
    inner class CardViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_food_photo)
        var tvName: TextView = itemView.findViewById(R.id.tv_food_name)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_food_detail)
        var btnBuy: Button = itemView.findViewById(R.id.action_buy)
        var btnShare: Button = itemView.findViewById(R.id.action_share)

    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(position: Int)
        fun onBuyClicked(data: Food)
        fun onShareClicked(data: Food)
    }

}