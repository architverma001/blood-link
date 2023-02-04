package com.example.blood_link

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.ImageView

class spalshActivity : AppCompatActivity() {
    private lateinit var img: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spalsh)


        supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        img = findViewById(R.id.imageView)
        val ani = AnimationUtils.loadAnimation(this,R.anim.splash_animation)
        img.startAnimation(ani)

        Handler().postDelayed({
            startActivity(Intent(this@spalshActivity,aftersplash::class.java)

            )
            finish()
        }, 2000)

    }
}