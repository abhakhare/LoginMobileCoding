package com.example.loginmobilecoding.View


import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.loginmobilecoding.Interface.LoginResultCallBacks
import com.example.loginmobilecoding.R
import com.example.loginmobilecoding.data.LoginViewModel
import com.example.loginmobilecoding.data.LoginViewModelFactory
import com.example.loginmobilecoding.databinding.ActivityLoginBinding


class LoginActivity: AppCompatActivity() ,LoginResultCallBacks{
    lateinit var activityLoginBinding : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
         activityLoginBinding = DataBindingUtil.setContentView<ActivityLoginBinding>(this, R.layout.activity_login)
         activityLoginBinding.loginviewModel=ViewModelProviders.of(this,
                 LoginViewModelFactory(this)
         ).get(LoginViewModel::class.java)
    }

    override fun onSuccess(message: String, user: String) {
        val toast = Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT)
        toast.show()
        val intent= Intent(applicationContext, HomeActivity::class.java)
        activityLoginBinding.edtEmail.text.clear();
        intent.putExtra("Username", user)
        startActivity(intent)
        activityLoginBinding.edtEmail.text.clear();
        activityLoginBinding.edtPassword.text.clear();
    }
    override fun onSuccessbutton() {
        activityLoginBinding.btnLogin.setBackgroundResource(R.drawable.logintextchange)

    }

    override fun onError(message: String) {
        val toast = Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT)
        toast.show()

    }
    override fun onErrorbutton() {

        activityLoginBinding.btnLogin.setBackgroundResource(R.drawable.logintext)



    }
}