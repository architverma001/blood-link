package com.example.blood_link

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference

class Login_activity : AppCompatActivity() {
    private lateinit var email:EditText
    private lateinit var password:EditText
    private lateinit var btnlogin:Button

    private lateinit var loader: ProgressDialog
    private lateinit var mAuth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)

        supportActionBar?.hide()
        mAuth = FirebaseAuth.getInstance()

        btnlogin = findViewById(R.id.btn_log_in)
     email = findViewById(R.id.edt_log_in_email)
     password = findViewById(R.id.edt_log_in_pass)
        btnlogin.setOnClickListener {

            if(email.text.isEmpty()){
                email.setError("required")
            }
            else if(password.text.isEmpty()){
                password.setError("required")
            }

            else {

                loader = ProgressDialog(this)
                loader.setTitle("Logging in")
                loader.setMessage("Please wait")
                loader.show()
                val e_mail = email.text.toString()
                val pass_word = password.text.toString()
                mAuth.signInWithEmailAndPassword(e_mail,pass_word)
                    .addOnSuccessListener {



                        val intent = Intent(this@Login_activity, AfterLoginDirectionpage::class.java)
                        finish()
                        startActivity(intent)

                    }
                    .addOnFailureListener{
                        Toast.makeText(this@Login_activity,it.toString(),Toast.LENGTH_LONG).show()
                    }.addOnFailureListener {
                        Toast.makeText(this,"Please enter details in correct format",Toast.LENGTH_SHORT).show()
                    }
                loader.dismiss()
            }
        }


    }
}