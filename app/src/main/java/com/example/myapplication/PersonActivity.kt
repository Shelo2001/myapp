package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class PersonActivity : AppCompatActivity() {
    private lateinit var personInfoTextView: TextView
    private lateinit var passwordChangeButton: Button
    private lateinit var logOutButton: Button

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person)
        personInfoTextView = findViewById(R.id.personInfoTextView)
        passwordChangeButton = findViewById(R.id.goToPasswordChangeButton)
        logOutButton = findViewById(R.id.logOutButton)

        mAuth = FirebaseAuth.getInstance()
        personInfoTextView.text = mAuth.currentUser?.uid



        logOutButton.setOnClickListener {
            mAuth.signOut()
            startActivity(Intent(this, MainActivity::class.java))
            finish()

        }
        passwordChangeButton.setOnClickListener {
            startActivity(Intent(this, passwordChangeButton::class.java))

        }
    }

}