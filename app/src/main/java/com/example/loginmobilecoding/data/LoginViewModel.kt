package com.example.loginmobilecoding.data


import android.annotation.SuppressLint
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.lifecycle.ViewModel
import com.example.loginmobilecoding.Interface.LoginResultCallBacks
import com.example.loginmobilecoding.Model.User





class LoginViewModel (private val listener:LoginResultCallBacks):ViewModel(){
    private val user:User



    init {
        this.user = User("","")
    }


    //create function to set Email after user finish enter text
    val emailTextWatcher:TextWatcher
        get()= object:TextWatcher{
        override fun afterTextChanged(s: Editable?) {
            user .setEmail(s.toString())
            var loginCode:Int = user.isDataValid()

            if(loginCode==-1){
                listener.onSuccessbutton()
            }else{

                if (loginCode == 0){
                    listener.onError("Please enter your user name")}
                else if (loginCode == 1){

                    listener.onError("Enter proper user name")}
                listener.onErrorbutton()
            }


        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        }

    }


    //create function to set Password after user finish enter text
    val passwordTextWatcher:TextWatcher
        get()= object:TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                user.setPassword(s.toString())
                 var loginCode:Int = user.isDataValid()
                if(loginCode==-1){
                    listener.onSuccessbutton()
                }else{
                    if (loginCode == 2){
                    listener.onError("Please enter Password")}
                 if (loginCode == 3){
                     listener.onError("Password not meeting the criteria")}
                else if (loginCode == 4){
                    listener.onError("Password not meeting the criteria")}

                    listener.onErrorbutton()
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

        }
    //create function to process Login Button clicked
    fun onLoginClicked(v: View){

        var loginCode:Int = user.isDataValid()
        if (loginCode == 0){
            listener.onError("Please enter your user name")}
        else if (loginCode == 1){

            listener.onError("Enter proper user name")}
        else if (loginCode == 2){

            listener.onError("Please enter Password")}
        else if (loginCode == 3){

            listener.onError("Password not meeting the criteria")}
        else if (loginCode == 4){
            listener.onError("Password not meeting the criteria")}
        else{
            listener.onSuccess("Authentication has been successful",user.getEmail())
        }
    }


}


