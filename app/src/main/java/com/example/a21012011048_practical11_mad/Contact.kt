package com.example.a21012011048_practical11_mad

class Contact (var id:String, var lat:String, var long:String, var name:String, var phone:String,var address:String) {

    companion object {

        var contactArray: List<Contact> = ArrayList()
    }
}