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

class donorActivity : AppCompatActivity() {
    private lateinit var arrayList: ArrayList<donor_data>
    private lateinit var adapter: donorAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var mAuth: FirebaseAuth
    private lateinit var mDbref: DatabaseReference
    private lateinit var floatingActionButton: FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_donor)
        supportActionBar?.hide()
        mAuth = FirebaseAuth.getInstance()
        var curr = mAuth.currentUser?.uid
        mDbref = FirebaseDatabase.getInstance().getReference()
        floatingActionButton = findViewById(R.id.add_data_btn)
        arrayList = ArrayList()

        adapter = donorAdapter(this, arrayList)
//        Log.d("List",arrayList[0].toString())
        recyclerView = findViewById(R.id.donor_recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        mDbref.child("Doners").child(curr.toString()).addValueEventListener(object :
            ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                arrayList.clear()
                for (postsnap in snapshot.children){
                    var datas = postsnap.getValue(donor_data::class.java)
                    arrayList.add(datas!!)
                }
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                Log.d("y","Some")
            }

        })

        floatingActionButton.setOnClickListener {
            startActivity(Intent(this@donorActivity,Amount_donate::class.java))
        }

    }
}