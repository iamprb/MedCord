package com.thoughtbeats.pranay.medcords.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thoughtbeats.pranay.medcords.R

class HorizontalAdapter : RecyclerView.Adapter<HorizontalAdapterViewHolder> (){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalAdapterViewHolder =
        HorizontalAdapterViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_horizontal_view,parent,false
            )
        )

    //As per requirement
    override fun getItemCount()=4

    override fun onBindViewHolder(p0: HorizontalAdapterViewHolder, p1: Int) {

    }

}




class HorizontalAdapterViewHolder(view:View) : RecyclerView.ViewHolder(view)