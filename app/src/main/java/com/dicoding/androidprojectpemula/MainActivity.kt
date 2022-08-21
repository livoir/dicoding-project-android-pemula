package com.dicoding.androidprojectpemula

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvFoods: RecyclerView
    private var listData: ArrayList<Food> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvFoods = findViewById(R.id.rv_foods)
        rvFoods.setHasFixedSize(true)

        listData.addAll(FoodsData.listData)

        supportActionBar?.title = resources.getString(R.string.title)
        showRecyclerCardView()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_page -> {
                val moveIntent = Intent(this@MainActivity, ProfileActivity::class.java)
                startActivity(moveIntent)
            }

        }
        return super.onOptionsItemSelected(item)
    }

    private fun showRecyclerCardView() {
        rvFoods.layoutManager = LinearLayoutManager(this)
        val cardViewFoodAdapter = CardViewFoodAdapter(listData)
        rvFoods.adapter = cardViewFoodAdapter

        cardViewFoodAdapter.setOnItemClickCallback(object : CardViewFoodAdapter.OnItemClickCallback {
            override fun onItemClicked(position: Int) {
                val moveWithDataIntent = Intent(this@MainActivity, DetailFoodActivity::class.java)
                moveWithDataIntent.putExtra(DetailFoodActivity.EXTRA_POSITION, position)
                startActivity(moveWithDataIntent)
            }

            override fun onBuyClicked(data: Food) {
                Toast.makeText(applicationContext, "Maaf, fitur ini belum bisa digunakan dikarenakan aplikasi ini hanya merupakan prototype", Toast.LENGTH_SHORT).show()
            }

            override fun onShareClicked(data: Food) {
                Toast.makeText(applicationContext, "Maaf, fitur ini belum bisa digunakan dikarenakan aplikasi ini hanya merupakan prototype", Toast.LENGTH_SHORT).show()
            }
        })
    }
}