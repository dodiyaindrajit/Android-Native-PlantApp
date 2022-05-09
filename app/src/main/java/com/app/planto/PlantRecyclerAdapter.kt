package com.app.planto

import android.app.Application
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide



class PlantRecyclerAdapter(private val mList: List<PlantListData>, private val activity: MainActivity,private val onPlantClickListener: OnPlantClickListener) : RecyclerView.Adapter<PlantRecyclerAdapter.ViewHolder>() {



    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the  view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_plant_item, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val plantItem = mList[position]

        // sets the image to the imageview from our itemHolder class
        holder.txtViewPlantName.text = plantItem.plantName
        holder.txtViewPlantType.text = plantItem.plantType
        holder.txtViewPlantPrice.text = plantItem.plantPrice

        Glide.with(activity)
            .load(plantItem.plantImage)
            .into(holder.imgPlant)

        Glide.with(activity)
            .load(plantItem.plantBackground)
            .into(holder.imgPlantBackground)

        Glide.with(activity)
            .load(plantItem.cartImage)
            .into(holder.imgCart)

        Glide.with(activity)
            .load(plantItem.heartImage)
            .into(holder.imgHeart)

        holder.imgPlant.setOnClickListener {

            onPlantClickListener.onPlantClick(plantItem,holder.imgPlant)

        }

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

        val txtViewPlantName :TextView = itemView.findViewById(R.id.txtViewplantName)
        val txtViewPlantType :TextView = itemView.findViewById(R.id.txtViewPlantType)
        val txtViewPlantPrice :TextView = itemView.findViewById(R.id.txtViewPlantPrice)
        val imgPlant :ImageView = itemView.findViewById(R.id.imgPlant)
        val imgPlantBackground :ImageView = itemView.findViewById(R.id.imgPlantBackGround)
        val imgCart :ImageView = itemView.findViewById(R.id.imgCart)
        val imgHeart :ImageView = itemView.findViewById(R.id.imgHeart)
    }
}
