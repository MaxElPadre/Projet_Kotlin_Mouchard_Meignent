package com.ekip.projet_kotlin_mouchard_meignent

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.ekip.network.Question
import com.ekip.network.QuestionsNetwork
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


class QuestionActivity : AppCompatActivity() {
    private lateinit var questions : List<Question>
    private lateinit var checkBoxA : CheckBox
    private lateinit var checkBoxB : CheckBox
    private lateinit var checkBoxC : CheckBox
    private lateinit var checkBoxD : CheckBox
    private lateinit var checkBoxE : CheckBox
    private lateinit var checkBoxF : CheckBox



    private lateinit var buttonValidate : Button
    private lateinit var buttonNewQuestion: Button

    private lateinit var textQuestion : TextView
    private lateinit var textDescription : TextView
    private lateinit var textScoringResult : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        val b = intent.extras
        val category = b?.getString("category")

        if (category != null) {
            getQuestions(category)
        }

        checkBoxA = findViewById(R.id.checkBoxA)
        checkBoxB = findViewById(R.id.checkBoxB)
        checkBoxC = findViewById(R.id.checkBoxC)
        checkBoxD = findViewById(R.id.checkBoxD)
        checkBoxE = findViewById(R.id.checkBoxE)
        checkBoxF = findViewById(R.id.checkBoxF)
        buttonValidate = findViewById(R.id.buttonValidate)
        buttonNewQuestion = findViewById(R.id.buttonNewQuestion)
        textScoringResult = findViewById(R.id.textScoringResult)

        buttonNewQuestion.visibility = View.GONE
        textScoringResult.visibility = View.GONE
        
        questions[0].answers.answer_a?.let {
            checkBoxA.visibility = View.VISIBLE
            checkBoxA.text = it
        }

        questions[0].answers.answer_b?.let {
            checkBoxB.visibility = View.VISIBLE
            checkBoxB.text = it
        }

        questions[0].answers.answer_c?.let {
            checkBoxC.visibility = View.VISIBLE
            checkBoxC.text = it
        }

        questions[0].answers.answer_d?.let {
            checkBoxD.visibility = View.VISIBLE
            checkBoxD.text = it
        }

        questions[0].answers.answer_e?.let {
            checkBoxE.visibility = View.VISIBLE
            checkBoxE.text = it
        }

        questions[0].answers.answer_f?.let {
            checkBoxF.visibility = View.VISIBLE
            checkBoxF.text = it
        }

        textQuestion = findViewById(R.id.textQuestion)
        textQuestion.text = questions[0].question

        textDescription = findViewById(R.id.textDescription)
        textDescription.text = questions[0].description

        val checkboxes = arrayOf(checkBoxA, checkBoxB, checkBoxC, checkBoxD, checkBoxE, checkBoxF)

        val quizHelper = QuizHelper()
        var scoring : Scoring = quizHelper.getScoring(false)

        buttonValidate.setOnClickListener {

            for (i in checkboxes.indices) {
                val currentCheckbox: CheckBox = checkboxes[i]

                if(quizHelper.isGoodUserResponse(i, questions[0].correct_answers)) {
                    if(currentCheckbox.isChecked) {
                        scoring = quizHelper.getScoring(true)
                    }
                    currentCheckbox.setTextColor(Color.parseColor("#00FF00"))
                } else if(currentCheckbox.isChecked) {
                    scoring = quizHelper.getScoring(false)
                    currentCheckbox.setTextColor(Color.parseColor("#FF0000"))
                }
            }

            textScoringResult.visibility = View.VISIBLE
            textScoringResult.text = scoring.displayScoreResult()

            buttonNewQuestion.visibility = View.VISIBLE
            buttonValidate.visibility = View.GONE
        }

        buttonNewQuestion.setOnClickListener {
            finish()
            startActivity(intent)
        }
    }

    private fun getQuestions(category: String)= runBlocking {
        launch {
            val value = QuestionsNetwork.retrofit.getQuestionsByCategory("8NnF2FISZg81RgPhM40wXzQpDBVNLtKc6h9WwwgY", category)
            questions = value
        }
    }
}

