package com.dev.simplemvp.model

data class User (var fullName :String="",var email:String=""){



    override fun toString(): String {
        return "Full Name : $fullName \nEmail : $email"
    }
}