package com.ekip.projet_kotlin_mouchard_meignent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ekip.network.QuestionsNetwork
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

fun getQuestions()= runBlocking {
    launch {
        val value = QuestionsNetwork.retrofit.getQuestions(10)
    }
}

