package com.example.shopapp.model

class User (
    val firstName: String,
    val lastName: String,
    val email: String,
    var imagPath: String = ""
){
    constructor(trim: String) : this("","","","")
}