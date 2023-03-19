package com.example.aibot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var mode = 0
    var n11: String = ""
    var n22: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val finalMsg = findViewById<TextView>(R.id.finalMsg)
        val playButton = findViewById<Button>(R.id.playButton)
        val n1 = findViewById<EditText>(R.id.name1)
        val n2 = findViewById<EditText>(R.id.name2)
        setViews(finalMsg,n1,n2)
        val x = findViewById<Button>(R.id.playButton)
        x.isClickable = false
        x.visibility = View.GONE
    }


    fun setViews(finalMsg: View, n1:View, n2:View){
        finalMsg.visibility = View.GONE
        n1.visibility = View.GONE
        n2.visibility = View.GONE

    }
    private fun play(){
        val button1 = findViewById<Button>(R.id.mp)
        val button2 = findViewById<Button>(R.id.bot)
        var intent = Intent(this, multiplayer::class.java)
        if(button1.isClickable){
            intent = Intent(this, multiplayer::class.java)
            n11 = findViewById<EditText>(R.id.name1).editableText.toString()
            n22 = findViewById<EditText>(R.id.name2).editableText.toString()
            intent.putExtra("name1",n11)
            intent.putExtra("name2",n22)
            button2.isClickable = true
        }
        else if(button2.isClickable){
            n11 = findViewById<EditText>(R.id.name1).editableText.toString()
            intent = Intent(this, SinglePlayer::class.java)
            button1.isClickable = true
        }
        intent.putExtra("game",mode.toString())
        startActivity(intent)
    }
    fun playWithBot(view: View) {
        val button2 = findViewById<Button>(R.id.mp)
        button2.isClickable = false
        val finalMsg = findViewById<TextView>(R.id.finalMsg)
        finalMsg.visibility = View.VISIBLE
        val n1 = findViewById<EditText>(R.id.name1)
        finalMsg.visibility = View.GONE
        finalMsg.text = "Your game with Bot will start soon"
        n1.visibility = View.VISIBLE
        n1.hint = "Enter your name (Optional)"
        n11 = findViewById<EditText>(R.id.name1).editableText.toString()

        play()
    }
    fun multiplayer(view: View){
        val button1 = findViewById<Button>(R.id.bot)
        button1.isClickable = false
        val finalMsg = findViewById<TextView>(R.id.finalMsg)
        finalMsg.visibility = View.VISIBLE
        val n1 = findViewById<EditText>(R.id.name1)
        finalMsg.visibility = View.GONE
        val n2 = findViewById<EditText>(R.id.name2)
        finalMsg.text = "Game mode selected is multiplayer"
        n1.visibility = View.GONE
        n1.hint = "who's the first"
        n2.visibility = View.GONE
        n2.hint = "who's second"
        play()
    }
}