package com.ekip.projet_kotlin_mouchard_meignent

import android.os.Bundle
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.ekip.network.Question
import com.ekip.network.QuestionsNetwork
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

lateinit var questions : List<Question>
lateinit var checkBoxA : CheckBox
lateinit var checkBoxB : CheckBox
lateinit var checkBoxC : CheckBox
lateinit var checkBoxD : CheckBox
lateinit var checkBoxE : CheckBox
lateinit var checkBoxF : CheckBox

lateinit var textQuestion : TextView
lateinit var textDescription : TextView


class QuestionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        val b = intent.extras
        val category = b!!.getString("category")

        if (category != null) {
            getQuestions(category)
        }

        checkBoxA = findViewById(R.id.checkBoxA)
        checkBoxB = findViewById(R.id.checkBoxB)
        checkBoxC = findViewById(R.id.checkBoxC)
        checkBoxD = findViewById(R.id.checkBoxD)
        checkBoxE = findViewById(R.id.checkBoxE)
        checkBoxF = findViewById(R.id.checkBoxF)

        checkBoxA.text = questions[0].answers.answer_a
        checkBoxB.text = questions[0].answers.answer_b
        checkBoxC.text = questions[0].answers.answer_c
        checkBoxD.text = questions[0].answers.answer_d
        checkBoxE.text = questions[0].answers.answer_e
        checkBoxF.text = questions[0].answers.answer_f

        textQuestion = findViewById(R.id.textQuestion)
        textQuestion.text = questions[0].question

        textDescription = findViewById(R.id.textDescription)
        textDescription.text = questions[0].description
    }
}

fun getQuestions(category: String)= runBlocking {
    launch {
        val value = QuestionsNetwork.retrofit.getQuestionsByCategory("8NnF2FISZg81RgPhM40wXzQpDBVNLtKc6h9WwwgY", category)
        questions = value
    }
}