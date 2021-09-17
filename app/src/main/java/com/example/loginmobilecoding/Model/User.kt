package com.example.loginmobilecoding.Model


import android.text.TextUtils
import android.util.Patterns
import androidx.databinding.BaseObservable
import java.util.regex.Matcher
import java.util.regex.Pattern

class User (private var email: String, private  var password: String): BaseObservable() {


    fun isDataValid():Int{
        if (TextUtils.isEmpty(getEmail()))
            return  0
        else if (!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches())
            return  1
        else if (TextUtils.isEmpty(getPassword()))
            return  2
        else if (getPassword().length<6)
            return 3
        else if (!isValidPassword(getPassword()))
            return 4
        else
            return -1
    }

    private fun isValidPassword(password: String): Boolean {
        val pattern: Pattern
        val matcher: Matcher
        val specialCharacters = "-@%\\[\\}+'!/#$^?:;,\\(\"\\)~`.*=&\\{>\\]<_"
        var   PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN)
        matcher = pattern.matcher(password)
        return matcher.matches()
    }

     fun getPassword(): String{
        return  password
    }

     fun getEmail(): String{
        return  email
    }

    fun setEmail(email: String){
        this.email=email
    }
    fun setPassword(password: String){
        this.password=password
    }

}