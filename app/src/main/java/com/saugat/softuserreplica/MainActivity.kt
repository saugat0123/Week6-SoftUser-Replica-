package com.saugat.softuserreplica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener {
            try {
                if (etUsername.text.toString() == "softwarica" && etPassword.text.toString()=="coventry")
                {
                    val intent = Intent(this,DashboardActivity::class.java)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this, "Invalid Username or Password!!", Toast.LENGTH_LONG).show()
                }
            }
            catch (ex:Exception){
                Toast.makeText(this, ex.message, Toast.LENGTH_LONG).show()
            }
        }

    }
}