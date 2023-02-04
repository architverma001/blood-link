package com.example.blood_link

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private lateinit var login_direction:TextView
    private lateinit var sign_up_btn:Button
    private lateinit var name:EditText
    private lateinit var email:EditText
    private lateinit var pass:EditText
    private lateinit var loader: ProgressDialog
    private lateinit var mDbRef: DatabaseReference
    private lateinit var mAuth:FirebaseAuth
    private lateinit var cpass:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         login_direction = findViewById(R.id.direct_to_login)
        sign_up_btn = findViewById(R.id.btn_sign_up)
        name = findViewById(R.id.edt_sign_up_name)
        email = findViewById(R.id.edt_sign_up_email)
        pass = findViewById(R.id.edt_sign_pass)
        cpass = findViewById(R.id.edt_pass_con_sign_up)
        supportActionBar?.hide()
        mDbRef = FirebaseDatabase.getInstance().getReference()



        mAuth = FirebaseAuth.getInstance()

        login_direction.setOnClickListener {
            startActivity(Intent(this@MainActivity,Login_activity::class.java))
        }
        if (mAuth.currentUser!=null){
            val intent = Intent(this@MainActivity,AfterLoginDirectionpage::class.java)
            finish()

            startActivity(intent)
        }
        sign_up_btn.setOnClickListener {

            if(name.text.isEmpty()){
                name.setError("required")
            }
            else if(email.text.isEmpty()){
                email.setError("required")
            }
            else if(pass.text.isEmpty()){
                pass.setError("required")
            }
            else if(cpass.text.isEmpty()){
                cpass.setError("required")
            }
            else if(pass.text.toString()!=cpass.text.toString()){
                pass.setError("password and confirm password must be equal")
                cpass.setError("password and confirm password must be equal")
            }

            else {

                loader = ProgressDialog(this)
                loader.setTitle("Logging in")
                loader.setMessage("Please wait")
                loader.show()
                val na_me = name.text.toString()
                val e_mail = email.text.toString()
                val pass_word = pass.text.toString()

                mAuth.createUserWithEmailAndPassword(e_mail,pass_word).addOnSuccessListener {

                    mDbRef.child("users").child(mAuth.currentUser?.uid.toString()).push().setValue(user(na_me,e_mail,mAuth.currentUser?.uid!!))
                    val intent = Intent(this@MainActivity,AfterLoginDirectionpage::class.java)
                    finish()

                    startActivity(intent)
                }.addOnCanceledListener {
                    Toast.makeText(this,it.toString(),Toast.LENGTH_SHORT).show()
                }
                loader.dismiss()

            }
        }
    }
}