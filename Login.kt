package com.vincentvu.a312geek.myfirstapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Login : AppCompatActivity() {

    internal lateinit var loginUsername:EditText
    internal lateinit var loginPassword:EditText
    internal lateinit var loginButton:Button
    internal lateinit var SignUpButton:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginUsername = findViewById<EditText>(R.id.login_username);
        loginPassword = findViewById<EditText>(R.id.login_password);
        loginButton = findViewById<Button>(R.id.btn_login_login);
        SignUpButton = findViewById<Button>(R.id.btn_sign_up);
        loginButton.setOnClickListener() {
            loginSuccess()
        }
        SignUpButton.setOnClickListener() {
            SignUpPage()
        }
    }

        private fun loginSuccess() {

            val loginUsername = loginUsername.text.toString()
            val loginPassword = loginPassword.text.toString()


            if (loginUsername.isBlank()) {
                Toast.makeText(this, getString(R.string.blank_message_username), Toast.LENGTH_LONG).show()
            }

            if (loginPassword.isBlank()) {
                Toast.makeText(this, getString(R.string.blank_message_password), Toast.LENGTH_LONG).show()
            }

            if (loginUsername.length<7) {
                Toast.makeText(this, getString(R.string.short_message_username), Toast.LENGTH_LONG).show()
            }

            if (loginPassword.length<7) {
                Toast.makeText(this, getString(R.string.short_message_password), Toast.LENGTH_LONG).show()
            }
        }

        private fun SignUpPage(){




        }



}
