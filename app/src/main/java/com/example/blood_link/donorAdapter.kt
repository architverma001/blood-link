package com.example.blood_link

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.grpc.Context

class donorAdapter(val context: android.content.Context, var donorlist:ArrayList<donor_data>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val view:View = LayoutInflater.from(context).inflate(R.layout.hospital_d_item,parent,false)
        return donors(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var curr = donorlist[position]
        val ViewHolder =  holder as donors
        holder.name.text = curr.name
        holder.age.text = curr.age.toString()
        holder.address.text = curr.address
        holder.sex.text = curr.sex
        holder.phone.text = curr.phone.toString()
        holder.donated.text = curr.donated.toString()
        holder.blood_grp.text = curr.bloodgroup
        holder.disease.text = curr.disease
    }

    override fun getItemCount(): Int {
        return donorlist.size
    }

    class donors(itemView: View): RecyclerView.ViewHolder(itemView){
        var name = itemView.findViewById<TextView>(R.id.hos_don_name)
        var age = itemView.findViewById<TextView>(R.id.hos_don_age)
        var sex = itemView.findViewById<TextView>(R.id.hos_don_sex)
        var address = itemView.findViewById<TextView>(R.id.hos_don_address)
        var phone = itemView.findViewById<TextView>(R.id.hos_don_phone)
        var donated = itemView.findViewById<TextView>(R.id.hos_don_amount)
        var blood_grp = itemView.findViewById<TextView>(R.id.hos_don_bldgrp)
        var disease = itemView.findViewById<TextView>(R.id.hos_don_dse)
    }
}