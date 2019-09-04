package com.dev.simplemvp.presenter

import com.dev.simplemvp.model.User

open class MainActivityPresenter(val view :View) {

     var user : User = User()

    fun updateFullName(name:String){
        user.fullName = name
        view.updateUseInfoTextView(user.toString())
    }

    fun updateEmail(email:String){
        user.email = email
        view.updateUseInfoTextView(user.toString())
    }

    interface View{
        fun updateUseInfoTextView(info:String)
        fun showProgressBar()
        fun hindProgressBar()
    }
}