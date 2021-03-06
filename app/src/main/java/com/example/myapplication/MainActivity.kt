package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {



   lateinit var auth: FirebaseAuth




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        auth = Firebase.auth
        val btnLogin = findViewById<Button>(R.id.login_btn)
        val email = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)

        btnLogin.setOnClickListener{
            //stop
            //Toast.makeText(this, "Login Button", Toast.LENGTH_LONG).show()
            val email2 = email.text.toString()
            val pass2 = password.text.toString()

            /*
            calling signInWithEmailAndPassword(email, pass)
            function using Firebase auth object
            On successful response Display a Toast
            */


            auth.signInWithEmailAndPassword(email2, pass2).addOnCompleteListener(this) {
                if(it.isSuccessful) {
                    Toast.makeText(this, "Successfully LoggedIn", Toast.LENGTH_SHORT).show()
                } else
                    Toast.makeText(this, "Log In failed", Toast.LENGTH_SHORT).show()

            }
        }

        val btnSignup = findViewById<Button>(R.id.btnSignup)
        btnSignup.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
    }
}


// to sie przyda przy wyswietlaniu uzytkownikow jak sie polaczy z baza
/*val arrayAdapter: ArrayAdapter<*>
val users = arrayOf(
    "Virat Kohli", "Rohit Sharma", "Steve Smith",
    "Kane Williamson", "Ross Taylor"
)

// access the listView from xml file
var mListView = findViewById<ListView>(R.id.usersListView)
arrayAdapter = ArrayAdapter(this,
android.R.layout.simple_list_item_1, users)
mListView.adapter = arrayAdapter*/