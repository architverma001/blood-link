package com.example.blood_link

class blood_data {
    var Apos:Float?=0f
    var Bpos:Float?=0f
    var Opos:Float?=0f
    var ABpos:Float?=0f
    var Aneg:Float?=0f
    var Bneg:Float?=0f
    var Oneg:Float?=0f
    var ABneg:Float?=0f

    constructor(){}

    constructor(
        Apos: Float?,
        Bpos: Float?,
        Opos: Float?,
        ABpos:Float?,
        Aneg:Float?,
        Bneg:Float?,
        Oneg: Float?,
        ABneg: Float?
    ) {
        this.Apos = Apos
        this.Bpos = Bpos
        this.Opos = Opos
        this.ABpos = ABpos
        this.Aneg = Aneg
        this.Bneg = Bneg
        this.Oneg = Oneg
        this.ABneg = ABneg
    }
}