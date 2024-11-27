package com.android.w1_android

import android.content.Intent
import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    private val TAG = "login activity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        val usernameEditText = findViewById<TextInputLayout>(R.id.username)
        val passwordEditText = findViewById<TextInputLayout>(R.id.password)

        val loginbutton = findViewById<Button>(R.id.button)

        loginbutton.setOnClickListener {
            val username = usernameEditText.editText?.text.toString()
            val password = passwordEditText.editText?.text.toString()

            //login

            if (username.isEmpty() || password.isEmpty()) {

                Toast.makeText(
                    this,
                    "Usermame atau Password tidak boleh kosong",
                    Toast.LENGTH_SHORT
                ).show()
                Log.e(TAG, "login gagal")

            } else if (username == "admin" && password == "12345") {
                Toast.makeText(this, "Berhasil", Toast.LENGTH_SHORT).show()

                val gotoHome = Intent(this, homeactivity::class.java)
                startActivity(gotoHome)
                finish()
                Log.i(TAG, "Login berhasil: Username = $username")

            } else {
                // Jika username atau password salah
                Toast.makeText(this, "Username atau Password salah", Toast.LENGTH_SHORT).show()
                Log.e(TAG, "Login gagal: Username atau password salah")


            }
        }
    }
}

