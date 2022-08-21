package com.dicoding.androidprojectpemula

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import java.text.DecimalFormat
import java.text.NumberFormat

class DetailFoodActivity : AppCompatActivity() {
    private lateinit var imgFood: ImageView
    private lateinit var tvFoodName: TextView
    private lateinit var tvFoodDescription: TextView
    private lateinit var tvCalorie: TextView
    private lateinit var tvRating: TextView
    private lateinit var btnBuyNow: Button

    companion object {
        const val EXTRA_POSITION = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_food)
        supportActionBar?.hide()

        val position = intent.getIntExtra(EXTRA_POSITION, 0)
        imgFood = findViewById(R.id.img_detail_photo)
        tvFoodName = findViewById(R.id.tv_food_detail)
        tvFoodDescription = findViewById(R.id.tv_food_description)
        tvCalorie = findViewById(R.id.tv_food_calorie)
        tvRating = findViewById(R.id.tv_food_rating)
        btnBuyNow = findViewById(R.id.btn_buy_now)

        showDetailData(position)
    }

    private fun showDetailData(position: Int) {
        val food = FoodsData.getData(position)

        Glide.with(imgFood.context)
            .load(food.photo)
            .apply(RequestOptions())
            .into(imgFood)

        tvFoodName.text = food.name
        tvFoodDescription.text = food.detail
        tvCalorie.text = String.format(resources.getString(R.string.calorie), food.calorie)
        tvRating.text = String.format(resources.getString(R.string.rating), food.rating)

        val formatter: NumberFormat = DecimalFormat("#,###")
        val myNumber = food.price
        val formattedNumber: String = formatter.format(myNumber)
        btnBuyNow.text = String.format(resources.getString(R.string.buy_now), formattedNumber)

    }
}