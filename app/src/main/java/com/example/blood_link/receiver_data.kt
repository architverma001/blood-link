package com.example.blood_link

class receiver_data {

    var name :String?=null
    var age :String?=null
    var sex :String?=null
    var address:String?=null
    var phone:String?=null
    var donated:String?=null
    var bloodgroup:String?=null
    var total:String?=null
    var uid:String?=null

    constructor(){

    }

    constructor(
        name: String?,
        age: String?,
        sex: String?,
        address: String?,
        phone: String?,
        donated: String?,
        bloodgroup: String?,
        total:String?,
        uid:String?
    ) {
        this.name = name
        this.age = age
        this.sex = sex
        this.address = address
        this.phone = phone
        this.donated = donated
        this.bloodgroup = bloodgroup
        this.total = total
        this.uid = uid
    }


}
