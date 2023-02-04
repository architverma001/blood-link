package com.example.blood_link

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class aftersplash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aftersplash)

        supportActionBar?.hide()
        Handler().postDelayed({
            startActivity(
                Intent(this@aftersplash,MainActivity::class.java)

            )
            finish()
        }, 500)
    }
}