package com.app1.quizandroid

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random
import kotlin.random.nextInt

class QuizActivity : AppCompatActivity() {

    var questions = arrayOf("web development", "game development", "web design", "networking")
    lateinit var right_answer:TextView
    lateinit var question_textview:TextView
    lateinit var user_answer:EditText
    lateinit var random:Random
    lateinit var question:String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        right_answer = findViewById(R.id.right_answer)
        question_textview = findViewById(R.id.question_textview)
        user_answer = findViewById(R.id.user_answer)

//        question_textview.text = mixLetters("Word")
        startQuiz()

    }

    fun rightAnswer(){

        right_answer.visibility = View.VISIBLE
        right_answer.setBackgroundColor(Color.GREEN)
        right_answer.text = question

        var handler = Handler()
        handler.postDelayed({
            startQuiz()
        }, 3000)
    }

    fun wrongAnswer(){
        right_answer.visibility = View.VISIBLE
        right_answer.setBackgroundColor(Color.RED)
        right_answer.text = user_answer.text

    }

    fun checkAnswer(view: View){
        if(user_answer.text.toString().equals(question, ignoreCase=true)){
            rightAnswer()
            Toast.makeText(this, "Good Job", Toast.LENGTH_SHORT).show()
        }else{
            wrongAnswer()
            Toast.makeText(this, "Bad Job", Toast.LENGTH_SHORT).show()

        }


    }



    fun startQuiz(){
        right_answer.text = ""
        right_answer.visibility = View.INVISIBLE
        random = Random
        question = questions[random.nextInt(questions.size)]
        question_textview.text = mixLetters(question)
//        question_textview.text = randomNumber.nextInt(5..15).toString()

    }

    fun showAnswer(view: View){
        right_answer.visibility = View.VISIBLE
        right_answer.text = question
    }


    fun changeQuestion(view: View){
        startQuiz()
    }


    fun mixLetters(word: String): String{
        val characters: CharArray = word.toCharArray()
        for (i in characters.indices) {
            val randomIndex = (Math.random() * characters.size).toInt()
            val temp = characters[i]
            characters[i] = characters[randomIndex]
            characters[randomIndex] = temp
        }
        return String(characters)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, MainActivity::class.java))
    }
}
