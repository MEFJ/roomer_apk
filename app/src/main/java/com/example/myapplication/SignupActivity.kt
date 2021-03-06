package com.example.myapplication

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.R
import com.example.myapplication.R.layout.activity_signup
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_signup.*
import org.w3c.dom.Text


class SignupActivity : AppCompatActivity() {
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

           val btnBacktologin = findViewById<Button>(R.id.btnBackToLogin)
          btnBacktologin.setOnClickListener{
            finish();
          }


        val email = findViewById<EditText>(R.id.newEmail)
        //val username = findViewById<EditText>(R.id.newUsername)
        val password = findViewById<EditText>(R.id.newPassword)


        auth = FirebaseAuth.getInstance()

        val btnSignUp = findViewById<Button>(R.id.btnMakeAcc)
        btnSignUp.setOnClickListener {
            val newemail = email.text.toString()
           // val newusername = username.text.toString()
            val newpassword = password.text.toString()

            if (newemail.isBlank() || newpassword.isBlank()) {
                Toast.makeText(this, "Email and Password can't be blank", Toast.LENGTH_SHORT).show()
                finish()
            }

            auth.createUserWithEmailAndPassword(newemail,newpassword).addOnCompleteListener(this){
                if(it.isSuccessful){
                    Toast.makeText(this, "Successfully Singed Up", Toast.LENGTH_SHORT).show()
                    finish();

                }else {
                    Toast.makeText(this, "Singed Up Failed!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}

