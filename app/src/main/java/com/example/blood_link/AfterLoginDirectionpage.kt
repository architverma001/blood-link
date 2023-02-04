package com.example.blood_link

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.cardview.widget.CardView
import com.google.firebase.auth.FirebaseAuth

class AfterLoginDirectionpage : AppCompatActivity() {
    private lateinit var donate: CardView
    private lateinit var receive: CardView
    private lateinit var hospital: CardView
    private lateinit var mAuth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_after_login_directionpage)

        donate = findViewById(R.id.donate)
        receive = findViewById(R.id.receive)
        hospital = findViewById(R.id.hospitals)

        mAuth = FirebaseAuth.getInstance()
        donate.setOnClickListener {
            startActivity(Intent(this@AfterLoginDirectionpage, donorActivity::class.java))
        }

        receive.setOnClickListener {
            startActivity(Intent(this@AfterLoginDirectionpage, receiverActivity::class.java))
        }
        hospital.setOnClickListener {
            startActivity(Intent(this@AfterLoginDirectionpage, HospitalActivity::class.java))
        }


    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId== R.id.logout){
            mAuth.signOut()
            val intent = Intent(this@AfterLoginDirectionpage,MainActivity::class.java)
            finish()
            startActivity(intent)
            return true
        }
        return true
    }


}