package com.example.blood_link

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HospitalActivity : AppCompatActivity() {
    private lateinit var receiver_data:Button
    private lateinit var sender_data:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hospital)
        supportActionBar?.hide()
        receiver_data = findViewById(R.id.reciver_data)
        sender_data = findViewById(R.id.doner_data)

        sender_data.setOnClickListener {
            startActivity(Intent(this@HospitalActivity,Hospital_d_Activity::class.java))
        }

        receiver_data.setOnClickListener {
            startActivity(Intent(this@HospitalActivity,Hospital_R_Activity::class.java))
        }
    }
}