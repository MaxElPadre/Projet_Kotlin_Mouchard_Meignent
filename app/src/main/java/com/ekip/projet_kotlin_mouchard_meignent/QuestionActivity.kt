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

        val checkboxes = arrayOf(checkBoxA, checkBoxB, checkBoxC, checkBoxD, checkBoxE, checkBoxF)

        val quizHelper = QuizHelper()
        var scoring : Scoring = quizHelper.getScoring(false)

        buttonValidate.setOnClickListener {
            for (checkbox in checkboxes) {

                    when(checkbox.id) {
                        R.id.checkBoxA -> {
                            if(quizHelper.isGoodUserResponse(1, questions[0].correct_answers)) {
                                if(checkbox.isChecked) {
                                    scoring = quizHelper.getScoring(true)
                                }
                                checkBoxA.setTextColor(Color.parseColor("#00FF00"))
                            } else if(checkbox.isChecked) {
                                scoring = quizHelper.getScoring(false)
                                checkBoxA.setTextColor(Color.parseColor("#FF0000"))
                            }
                        }
                        R.id.checkBoxB -> {
                            if(quizHelper.isGoodUserResponse(2, questions[0].correct_answers)) {
                                if(checkbox.isChecked) {
                                    scoring = quizHelper.getScoring(true)
                                }
                                checkBoxB.setTextColor(Color.parseColor("#00FF00"))
                            } else if(checkbox.isChecked) {
                                scoring = quizHelper.getScoring(false)
                                checkBoxB.setTextColor(Color.parseColor("#FF0000"))
                            }
                        }
                        R.id.checkBoxC -> {
                            if(quizHelper.isGoodUserResponse(3, questions[0].correct_answers)) {
                                if(checkbox.isChecked) {
                                    scoring = quizHelper.getScoring(true)
                                }
                                checkBoxC.setTextColor(Color.parseColor("#00FF00"))
                            } else if(checkbox.isChecked) {
                                scoring = quizHelper.getScoring(false)
                                checkBoxC.setTextColor(Color.parseColor("#FF0000"))
                            }
                        }
                        R.id.checkBoxD -> {
                            if(quizHelper.isGoodUserResponse(4, questions[0].correct_answers)) {
                                if(checkbox.isChecked) {
                                    scoring = quizHelper.getScoring(true)
                                }
                                checkBoxD.setTextColor(Color.parseColor("#00FF00"))
                            } else if(checkbox.isChecked) {
                                scoring = quizHelper.getScoring(false)
                                checkBoxD.setTextColor(Color.parseColor("#FF0000"))
                            }
                        }
                        R.id.checkBoxE -> {
                            if(quizHelper.isGoodUserResponse(5, questions[0].correct_answers)) {
                                if(checkbox.isChecked) {
                                    scoring = quizHelper.getScoring(true)
                                }
                                checkBoxE.setTextColor(Color.parseColor("#00FF00"))
                            } else if(checkbox.isChecked) {
                                scoring = quizHelper.getScoring(false)
                                checkBoxE.setTextColor(Color.parseColor("#FF0000"))
                            }
                        }
                        R.id.checkBoxF -> {
                            if(quizHelper.isGoodUserResponse(6, questions[0].correct_answers)) {
                                if(checkbox.isChecked) {
                                    scoring = quizHelper.getScoring(true)
                                }
                                checkBoxF.setTextColor(Color.parseColor("#00FF00"))
                            } else if(checkbox.isChecked) {
                                scoring = quizHelper.getScoring(false)
                                checkBoxF.setTextColor(Color.parseColor("#FF0000"))
                            }

                        }
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

