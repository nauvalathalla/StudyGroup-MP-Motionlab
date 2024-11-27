package com.android.w1_android

import android.content.Intent
import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class homeactivity : AppCompatActivity() {
    private val TAR = "HOME activity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_homeactivity)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val outbutton = findViewById<ImageButton>(R.id.imageButton2)

        outbutton.setOnClickListener{
            val gotoMain = Intent(this, MainActivity::class.java)
            startActivity(gotoMain)

            Toast.makeText(this, "Berhasil Keluar", Toast.LENGTH_SHORT).show()


        }

    }
}