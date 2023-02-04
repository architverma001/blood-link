package com.example.blood_link

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class amount_desire : AppCompatActivity() {
    private lateinit var name: EditText
    private lateinit var age: EditText
    private lateinit var sex: EditText
    private lateinit var address: EditText
    private lateinit var phone: EditText
    private lateinit var donated: EditText
    private lateinit var bloodgroup: EditText

    private lateinit var mDbRef: DatabaseReference
    private lateinit var mAuth: FirebaseAuth
    private lateinit var loader: ProgressDialog

    private lateinit var submit: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_amount_desire)

        mAuth = FirebaseAuth.getInstance()
        mDbRef =  FirebaseDatabase.getInstance().getReference()

        var curruser = mAuth.currentUser?.uid


        name = findViewById(R.id.edt_rec_name)
        age = findViewById(R.id.edt_rec_age)
        sex = findViewById(R.id.edt_rec_sex)
        address = findViewById(R.id.edt_rec_address)
        phone = findViewById(R.id.edt_rec_phone)
        donated = findViewById(R.id.edt_rec_donated)
        bloodgroup = findViewById(R.id.edt_rec_bloodgroup)
        submit = findViewById(R.id.rec_dess)

        submit.setOnClickListener {
            if(name.text.isEmpty()){
                name.setError("Required")
            }

            else if(age.text.isEmpty()){
                age.setError("Required")
            }

            else if(sex.text.isEmpty()){
                sex.setError("Required")
            }
            else if(address.text.isEmpty()){
                address.setError("Required")
            }

            else if(phone.text.isEmpty()){
                phone.setError("Required")
            }

            else if(donated.text.isEmpty()){
                donated.setError("Required")
            }

            else if(bloodgroup.text.isEmpty()){
                bloodgroup.setError("Required")
            }

            else if(sex.text.toString()!="M"){
                if(sex.text.toString()!="F"){
                    sex.setError("Fill M or F only")
                }
            }



           else if(bloodgroup.text.toString()!="A+" && bloodgroup.text.toString()!="A-"&&bloodgroup.text.toString()!="B+"

                &&bloodgroup.text.toString()!="B-"&&bloodgroup.text.toString()!="AB+"&&bloodgroup.text.toString()!="AB-"
                &&
                bloodgroup.text.toString()!="O+"&&bloodgroup.text.toString()!="O-")
                bloodgroup.setError("Write all capitals without gap or correct Blood group(with sign)")

            else{

                loader = ProgressDialog(this)
                loader.setTitle("Logging in")
                loader.setMessage("Please wait")
                loader.show()
                val na_me = name.text.toString()
                val a_ge = age.text.toString()
                val s_ex = sex.text.toString()
                val add_ress = address.text.toString()
                val ph_one = phone.text.toString()
                val rec_ = donated.text.toString()
                val bg = bloodgroup.text.toString()


//                 mDbRef.child("recivers").child(curruser.toString()).push().setValue(receiver_data(na_me,a_ge,s_ex,add_ress,ph_one,rec_,bg,"0",curruser))
//                     .addOnSuccessListener {
//                        Toast.makeText(this,"data added successfully",Toast.LENGTH_LONG).show()
//                         onBackPressed()
//                     }.addOnFailureListener {
//                         Toast.makeText(this,"data addition failed successfully",Toast.LENGTH_LONG).show()
//                     }
//
//
//                mDbRef.child("reciversHos").child("k").push().setValue(receiver_data(na_me,a_ge,s_ex,add_ress,ph_one,rec_,bg,"0",curruser))
//                    .addOnSuccessListener {
//
//
//                    }.addOnFailureListener {
//
//                    }

                    var Aposx = 0
                    var Bposx = 0
                    var Oposx = 0
                    var ABposx = 0
                    var Anegx = 0
                    var Bnegx = 0
                    var ABnegx = 0
                    var Onegx = 0


                    if(bg=="A+"){
                        Aposx = 1
                    }
                    if(bg=="B+"){
                        Bposx = 1
                    }
                    if(bg=="AB+"){
                        ABposx = 1
                    }
                    if(bg=="O+"){
                        Oposx = 1
                    }
                    if(bg=="A-"){
                        Anegx = 1
                    }
                    if(bg=="B-"){
                        Bnegx = 1
                    }
                    if(bg=="AB-"){
                        ABnegx = 1
                    }
                    if(bg=="O-"){
                        Onegx = 1
                    }







                mDbRef.child("recivers").child(curruser.toString()).push().setValue(receiver_data(na_me,a_ge,s_ex,add_ress,ph_one,rec_,bg,"0",curruser))
                    .addOnSuccessListener {
                        Toast.makeText(this,"data added successfully",Toast.LENGTH_LONG).show()
                        onBackPressed()
                    }.addOnFailureListener {
                        Toast.makeText(this,"data addition failed successfully",Toast.LENGTH_LONG).show()
                    }


                mDbRef.child("reciversHos").child("k").push().setValue(receiver_data(na_me,a_ge,s_ex,add_ress,ph_one,rec_,bg,"0",curruser))
                    .addOnSuccessListener {


                    }.addOnFailureListener {

                    }



            }
            }
        }

    }
