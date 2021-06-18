package com.ekip.projet_kotlin_mouchard_meignent

import android.os.Bundle
import android.view.View
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

        if(questions[0].answers.answer_a == null) {
            checkBoxA.visibility = View.GONE
        } else {
            checkBoxA.text = questions[0].answers.answer_a
        }

        if(questions[0].answers.answer_b == null) {
            checkBoxB.visibility = View.GONE
        } else {
            checkBoxB.text = questions[0].answers.answer_b
        }

        if(questions[0].answers.answer_c == null) {
            checkBoxC.visibility = View.GONE
        } else {
            checkBoxC.text = questions[0].answers.answer_c
        }

        if(questions[0].answers.answer_d == null) {
            checkBoxD.visibility = View.GONE
        } else {
            checkBoxD.text = questions[0].answers.answer_d
        }

        if(questions[0].answers.answer_e == null) {
            checkBoxE.visibility = View.GONE
        } else {
            checkBoxE.text = questions[0].answers.answer_e
        }

        if(questions[0].answers.answer_f == null) {
            checkBoxF.visibility = View.GONE
        } else {
            checkBoxF.text = questions[0].answers.answer_f
        }

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