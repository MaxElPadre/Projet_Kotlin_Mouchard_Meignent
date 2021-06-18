package com.ekip.projet_kotlin_mouchard_meignent

import com.ekip.network.AnswersListResponse

class QuizHelper {
     fun isGoodUserResponse(userResponse: Int, answerResponse: AnswersListResponse) : Boolean = when(userResponse) {
        1 -> answerResponse.answer_a_correct
        2 -> answerResponse.answer_b_correct
        3 -> answerResponse.answer_c_correct
        4 -> answerResponse.answer_d_correct
        5 -> answerResponse.answer_e_correct
        6 -> answerResponse.answer_f_correct
         else -> false
    }

    fun getScoring(isGoodResponse: Boolean) : Scoring = when(isGoodResponse) {
        true -> Scoring.EXCELLENT
        false -> Scoring.BAD
        else -> Scoring.WTFBRO
    }

    fun getAverageScoreByGames(listOfScore: List<Int>) : Double = executeOperation(listOfScore.sum(), listOfScore.count(), executeDivision)
}