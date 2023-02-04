package com.example.blood_link

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class receiverAdapter(val context: android.content.Context, var receiverlist:ArrayList<receiver_data>): RecyclerView.Adapter<RecyclerView.ViewHolder>()   {






    class receivers(itemView: View): RecyclerView.ViewHolder(itemView){
        var name = itemView.findViewById<TextView>(R.id.hos_rec_name)
        var age = itemView.findViewById<TextView>(R.id.hos_rec_age)
        var sex = itemView.findViewById<TextView>(R.id.hos_rec_sex)
        var address = itemView.findViewById<TextView>(R.id.hos_rec_address)
        var phone = itemView.findViewById<TextView>(R.id.hos_rec_phone)
        var require = itemView.findViewById<TextView>(R.id.hos_rec_amount)
        var blood_grp = itemView.findViewById<TextView>(R.id.hos_rec_bldgrp)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view:View = LayoutInflater.from(context).inflate(R.layout.hospital_r_item,parent,false)
        return receivers(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var curr = receiverlist[position]
        val ViewHolder =  holder as receivers
        holder.name.text = curr.name
        holder.age.text = curr.age.toString()
        holder.address.text = curr.address
        holder.sex.text = curr.sex
        holder.phone.text = curr.phone.toString()
        holder.require.text = curr.donated.toString()
        holder.blood_grp.text = curr.bloodgroup

    }

    override fun getItemCount(): Int {
        return receiverlist.size
    }
}