package com.app.planto

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.planto.databinding.ActivityMainBinding


interface OnPlantClickListener{
    fun onPlantClick(plantData: PlantListData,view:View)
}

class MainActivity : AppCompatActivity(), OnPlantClickListener {

    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(this,R.color.white)


        binding.imgFilter.setOnClickListener {
            val intent = Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }

        val tabLayout = binding.tabLayout
        tabLayout.addTab(tabLayout.newTab().setText("Top Picks"))
        tabLayout.addTab(tabLayout.newTab().setText("Indoor"))
        tabLayout.addTab(tabLayout.newTab().setText("Outdoor"))
        tabLayout.addTab(tabLayout.newTab().setText("Seed"))
        tabLayout.addTab(tabLayout.newTab().setText("Planter"))


        val rvPlantItem = binding.recyclerViewPlant
        rvPlantItem.layoutManager = LinearLayoutManager(this)
        rvPlantItem.adapter = PlantRecyclerAdapter(getPlantList(),this,this)


    }

    fun getPlantList(): List<PlantListData> {
        return listOf(
            PlantListData("Peperomia", "Air Purifier", "$400", R.drawable.img_plant1, R.drawable.img_plant1_background, R.drawable.ic_cart, R.drawable.ic_heart),
            PlantListData("Watermelon", "Air Purifier", "$350", R.drawable.img_plant2, R.drawable.img_plant2_background, R.drawable.ic_cart, R.drawable.ic_heart),
            PlantListData("Croton Petra", "Air Purifier", "$200", R.drawable.img_plant3, R.drawable.img_plant1_background, R.drawable.ic_cart, R.drawable.ic_heart),
            PlantListData("Birds Nest Fern", "Air Purifier", "$450", R.drawable.img_plant4, R.drawable.img_plant4_background, R.drawable.ic_cart, R.drawable.ic_heart),
            PlantListData("Cactus", "Air Purifier", "$260", R.drawable.img_plant5, R.drawable.img_plant2_background, R.drawable.ic_cart, R.drawable.ic_heart)
        )
    }

    override fun onPlantClick(plantData: PlantListData, view: View) {
        val intent = Intent(this,PlantActivity::class.java)
        intent.putExtra("plantName",plantData.plantName)
        intent.putExtra("plantType",plantData.plantType)
        intent.putExtra("plantPrice",plantData.plantPrice)
        intent.putExtra("plantImage",plantData.plantImage)
        startActivity(intent)
    }
}