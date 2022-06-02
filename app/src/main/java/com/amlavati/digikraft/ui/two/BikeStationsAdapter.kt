package com.amlavati.digikraft.ui.two


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amlavati.digikraft.databinding.ItemListContentBinding
import com.amlavati.digikraft.model.BikeStationData
import com.amlavati.digikraft.model.Feature

/**
 * Created by Sudarshan Bhatt on 02-06-2022
 * All rights reserved to https://www.amlavati.com
 */
class BikeStationsAdapter(private val listener: CellClickListener) :
    RecyclerView.Adapter<BikeStationsAdapter.MainViewHolder>() {

    private var bikeStationData: BikeStationData? = null

    fun updateData(data: BikeStationData) {
        bikeStationData = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemListContentBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {

        val data = bikeStationData?.features?.get(position)
        holder.itemView.setOnClickListener {
            if (data != null) {
                listener.onCellClickListener(data)
            }
        }
        holder.binding.apply {
            data?.apply {
                tvId.text = id
                tvLabel.text = properties.label
                //   tvDistance.text = "600 mtr"
                tvType.text = type
                tvAvailableBikes.text = properties.bikes
                tvAvailablePlaces.text = properties.free_racks

            }

        }

    }

    override fun getItemCount(): Int {
        return bikeStationData?.features?.size ?: 0
    }


    class MainViewHolder(val binding: ItemListContentBinding) :
        RecyclerView.ViewHolder(binding.root)

}

interface CellClickListener {


    fun onCellClickListener(data: Feature)
}