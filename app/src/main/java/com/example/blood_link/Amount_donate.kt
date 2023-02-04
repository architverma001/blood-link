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

class Amount_donate : AppCompatActivity() {
    private lateinit var name:EditText
    private lateinit var age:EditText
    private lateinit var sex:EditText
    private lateinit var address:EditText
    private lateinit var phone:EditText
    private lateinit var donated:EditText
    private lateinit var bloodgroup:EditText
    private lateinit var mDbRef: DatabaseReference
    private lateinit var mAuth: FirebaseAuth
    private lateinit var loader: ProgressDialog
    private lateinit var disease:EditText
    private lateinit var submit:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_amount_donate)


        name = findViewById(R.id.edt_don_name)
        age = findViewById(R.id.edt_don_age)
        sex = findViewById(R.id.edt_don_sex)
        address = findViewById(R.id.edt_don_address)
        phone = findViewById(R.id.edt_don_phone)
        donated = findViewById(R.id.edt_don_donated)
        bloodgroup = findViewById(R.id.edt_don_bloodgroup)
        disease = findViewById(R.id.edt_don_disease)
        submit = findViewById(R.id.don_dess)
        mAuth = FirebaseAuth.getInstance()
        mDbRef =  FirebaseDatabase.getInstance().getReference()

        var curruser = mAuth.currentUser?.uid

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
           else if(disease.text.isEmpty()){
                disease.setError("required")
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
                val pho_ne = phone.text.toString()
                val don_ated = donated.text.toString()
                val bld = bloodgroup.text.toString()
                val dis = disease.text.toString()





                var Aposx = 0f
                var Bposx = 0f
                var Oposx = 0f
                var ABposx = 0f
                var Anegx = 0f
                var Bnegx = 0f
                var ABnegx = 0f
                var Onegx = 0f



                var Aposxy = 0f
                var Bposxy = 0f
                var Oposxy = 0f
                var ABposxy = 0f
                var Anegxy = 0f
                var Bnegxy = 0f
                var ABnegxy = 0f
                var Onegxy = 0f


                if(bld=="A+"){
                    Aposx = 1f
                }
                if(bld=="B+"){
                    Bposx = 1f
                }
                if(bld=="AB+"){
                    ABposx = 1f
                }
                if(bld=="O+"){
                    Oposx = 1f
                }
                if(bld=="A-"){
                    Anegx = 1f
                }
                if(bld=="B-"){
                    Bnegx = 1f
                }
                if(bld=="AB-"){
                    ABnegx = 1f
                }
                if(bld=="O-"){
                    Onegx = 1f
                }








                mDbRef.child("Doners").child(curruser.toString()).push().setValue(donor_data(na_me,a_ge,s_ex,add_ress,pho_ne,don_ated,bld,dis,"9",curruser.toString()))
                .addOnSuccessListener {
                    onBackPressed()
                    loader.dismiss()
                    Toast.makeText(this,"data added successfully", Toast.LENGTH_LONG).show()
                }.addOnFailureListener {
                    Toast.makeText(this,it.toString(), Toast.LENGTH_LONG).show()
                }


                mDbRef.child("DonersHos").child("k").push().setValue(donor_data(na_me,a_ge,s_ex,add_ress,pho_ne,don_ated,bld,dis,"9",curruser.toString()))
                    .addOnSuccessListener {

                    }.addOnFailureListener {

                    }
                loader.dismiss()

            }
        }
    }
}