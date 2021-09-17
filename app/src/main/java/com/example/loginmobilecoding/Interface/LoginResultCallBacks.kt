package com.example.loginmobilecoding.Interface


interface LoginResultCallBacks {
    fun onSuccess(message:String,str:String)
    fun onError(message: String)
    fun onSuccessbutton()
    fun onErrorbutton()
}