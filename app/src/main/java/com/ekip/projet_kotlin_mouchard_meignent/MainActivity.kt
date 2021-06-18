package com.ekip.projet_kotlin_mouchard_meignent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var buttonSQL : Button
    private lateinit var buttonCode : Button
    private lateinit var buttonLinux : Button
    private lateinit var buttonDocker : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonSQL = findViewById(R.id.buttonSQL)
        buttonCode = findViewById(R.id.buttonCode)
        buttonLinux = findViewById(R.id.buttonLinux)
        buttonDocker = findViewById(R.id.buttonDocker)

        val intent = Intent(this,QuestionActivity::class.java)

        buttonSQL.setOnClickListener {
            intent.putExtra("category", "SQL")
            startActivity(intent)
        }

        buttonCode.setOnClickListener {
            intent.putExtra("category", "Code")
            startActivity(intent)
        }

        buttonLinux.setOnClickListener {
            intent.putExtra("category", "Linux")
            startActivity(intent)
        }

        buttonDocker.setOnClickListener {
            intent.putExtra("category", "Docker")
            startActivity(intent)
        }
    }
}