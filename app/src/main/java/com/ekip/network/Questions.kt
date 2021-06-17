package com.ekip.network

data class AnswersList(
    val answer_a: String,
    val answer_b: String,
    val answer_c: String,
    val answer_d: String,
    val answer_e: String,
    val answer_f: String
)

data class AnswersListResponse(
    val answer_a_correct: Boolean,
    val answer_b_correct: Boolean,
    val answer_c_correct: Boolean,
    val answer_d_correct: Boolean,
    val answer_e_correct: Boolean,
    val answer_f_correct: Boolean
)

data class Tag(val name: String)

enum class DifficultyLevel {
    Easy, Medium, Hard
}
data class Question(
    val question: String,
    val description: String,
    val multiple_correct_answers: Boolean,
    val explanation: String,
    val difficulty: DifficultyLevel,
    val tip: String,
    val tags: Array<Tag>,
    val answers: AnswersList,
    val correct_answers: AnswersListResponse,
    val category: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Question

        if (question != other.question) return false
        if (description != other.description) return false
        if (multiple_correct_answers != other.multiple_correct_answers) return false
        if (explanation != other.explanation) return false
        if (difficulty != other.difficulty) return false
        if (tip != other.tip) return false
        if (!tags.contentEquals(other.tags)) return false
        if (answers != other.answers) return false
        if (correct_answers != other.correct_answers) return false
        if (category != other.category) return false

        return true
    }

    override fun hashCode(): Int {
        var result = question.hashCode()
        result = 31 * result + description.hashCode()
        result = 31 * result + multiple_correct_answers.hashCode()
        result = 31 * result + explanation.hashCode()
        result = 31 * result + difficulty.hashCode()
        result = 31 * result + tip.hashCode()
        result = 31 * result + tags.contentHashCode()
        result = 31 * result + answers.hashCode()
        result = 31 * result + correct_answers.hashCode()
        result = 31 * result + category.hashCode()
        return result
    }
}
