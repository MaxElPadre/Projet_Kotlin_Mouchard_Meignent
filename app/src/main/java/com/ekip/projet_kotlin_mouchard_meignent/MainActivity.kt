package com.ekip.projet_kotlin_mouchard_meignent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ekip.network.AnswersListResponse
import com.ekip.network.QuestionsAPI
import com.ekip.network.QuestionsNetwork
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //Use Case Exemple
    val quizHelper = QuizHelper()
    val scoring: String = quizHelper.getScoring(5).displayScoreResult()

}

fun getQuestions()= runBlocking {
    launch {
        val value = QuestionsNetwork.retrofit.getQuestions(10)
    }
}




class CustomException(val customMessage: String = "Wrong enumerator value") : Exception()

class QuizHelper {
    private fun isGoodUserResponse(userResponse: Int, answerResponse: AnswersListResponse) = when(userResponse) {
        1 -> answerResponse.answer_a_correct
        2 -> answerResponse.answer_b_correct
        3 -> answerResponse.answer_c_correct
        4 -> answerResponse.answer_d_correct
        5 -> answerResponse.answer_e_correct
        6 -> answerResponse.answer_f_correct
        else -> CustomException("userResponse is unknown")
    }

    fun getScoring(goodAnswer: Int) : Scoring = when(goodAnswer) {
        9, 10 -> Scoring.EXCELLENT
        7, 8 -> Scoring.GREAT
        4, 5, 6 -> Scoring.MEDIUM
        1, 2, 3 -> Scoring.BAD
        else -> Scoring.BAD
    }
}