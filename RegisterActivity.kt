package com.vincentvu.a312geek.myfirstapp

import android.app.ProgressDialog.show
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.regex.Pattern

class RegisterActivity : AppCompatActivity() {

    lateinit var registerUsername:EditText
    lateinit var registerEmail:EditText
    lateinit var registerPassword: EditText
    lateinit var registerPasswordConfirm: EditText
    lateinit var registerBtn: Button
    val userDataManager: userDataManager = userDataManager(this)
    val INTENT_USER_KEY = "user"
    val LIST_DETAIL_REQUEST_CODE = "123"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        registerUsername = findViewById<EditText>(R.id.register_username)
        registerEmail = findViewById<EditText>(R.id.register_email)
        registerPassword = findViewById<EditText>(R.id.register_password)
        registerPasswordConfirm = findViewById<EditText>(R.id.register_password_pw)
        registerBtn = findViewById<Button>(R.id.btn_register)
        registerBtn.setOnClickListener() {
            registerAccount()
        }

    }


    private fun registerAccount() {

        val registerUsername = registerUsername.text.toString()
        val registerEmail = registerEmail.text.toString()
        val registerPassword = registerPassword.text.toString()
        val registerPasswordConfirm = registerPasswordConfirm.text.toString()
        val listTitleEditText = EditText(this)
        val user = UserList(listTitleEditText.text.toString())

        if (registerUsername.isBlank()) {
            Toast.makeText(this, getString(R.string.blank_message_username), Toast.LENGTH_LONG).show()
        }
        if (registerEmail.isBlank())  {
            Toast.makeText(this, getString(R.string.blank_message_email), Toast.LENGTH_LONG).show()
        }
        if (registerPassword.isBlank())  {
            Toast.makeText(this, getString(R.string.blank_message_password), Toast.LENGTH_LONG).show()
        }
        if (registerPasswordConfirm.isBlank())  {
            Toast.makeText(this, getString(R.string.blank_message_password), Toast.LENGTH_LONG).show()
        }
        if (registerUsername.length<7) {
            Toast.makeText(this, getString(R.string.short_message_username), Toast.LENGTH_LONG).show()
        }
        if (registerPassword.length<7) {
            Toast.makeText(this, getString(R.string.short_message_password), Toast.LENGTH_LONG).show()
        }
        if (isEmailValid(registerEmail)==false) {
            Toast.makeText(this, getString(R.string.invalid_email), Toast.LENGTH_LONG).show()
        }

        userDataManager.saveUser(user)
        showUserProfile()
    }

    private fun isEmailValid(email:String): Boolean {
        return Pattern.compile(
                "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]|[\\w-]{2,}))@"
                        + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                        + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        + "[0-9]{1,2}|25[0-5]|2[0-4][0-9]))|"
                        + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
        ).matcher(email).matches()
    }

    private fun showUserProfile{
        val userProfileIntent = Intent(this, UserProfileActivity::class.java)
        userProfileIntent.putExtra(INTENT_USER_KEY, user)

        startActivity(userProfileIntent)
    }
}
