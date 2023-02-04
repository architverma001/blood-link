package com.example.blood_link

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class receiverActivity : AppCompatActivity() {
    private lateinit var arrayList: ArrayList<receiver_data>
    private lateinit var adapter: receiverAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var mAuth:FirebaseAuth
    private lateinit var mDbref: DatabaseReference
    private lateinit var floatingActionButton: FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receiver)
        supportActionBar?.hide()
        mAuth = FirebaseAuth.getInstance()
        var curr = mAuth.currentUser?.uid
        mDbref = FirebaseDatabase.getInstance().getReference()

        arrayList = ArrayList()

        adapter = receiverAdapter(this, arrayList)
//        Log.d("List",arrayList[0].toString())
        recyclerView = findViewById(R.id.receiver_recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        floatingActionButton = findViewById(R.id.sub_data_btn)
        floatingActionButton.setOnClickListener {
            startActivity(Intent(this@receiverActivity,amount_desire::class.java))
        }
        recyclerView.adapter = adapter


        mDbref.child("recivers").child(curr.toString()).addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                arrayList.clear()
                for (postsnap in snapshot.children){
                    var datas = postsnap.getValue(receiver_data::class.java)
                    arrayList.add(datas!!)
                }
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
              Log.d("y","Some")
            }

        })
    }
}