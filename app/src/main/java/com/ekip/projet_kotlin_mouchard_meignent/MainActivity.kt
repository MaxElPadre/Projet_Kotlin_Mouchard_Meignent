package com.ekip.projet_kotlin_mouchard_meignent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

lateinit var buttonSQL : Button
lateinit var buttonCode : Button
lateinit var buttonLinux : Button
lateinit var buttonDocker : Button
lateinit var buttonKubernetes : Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        buttonSQL = findViewById(R.id.buttonSQL)
        buttonCode = findViewById(R.id.buttonCode)
        buttonLinux = findViewById(R.id.buttonLinux)
        buttonDocker = findViewById(R.id.buttonDocker)
        buttonKubernetes = findViewById(R.id.buttonKubernetes)

        val intent : Intent =  Intent(this,QuestionActivity::class.java)

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

        buttonKubernetes.setOnClickListener {
            intent.putExtra("category", "Kubernetes")
            startActivity(intent)
        }
    }
}

