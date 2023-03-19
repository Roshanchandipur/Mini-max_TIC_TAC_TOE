package com.example.aibot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.BoringLayout
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

@Suppress("DEPRECATION")
class multiplayer : AppCompatActivity() {
    var map = hashMapOf<Int,ImageView>()
    var board = Array(3){CharArray(3)}
    val player = 'X'
    val opponent = 'O'
    var play: Boolean = true
    var n1: String = ""
    var n2: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multiplayer)
        n1 = intent.getStringExtra("name1").toString()
        n2 = intent.getStringExtra("name2").toString()
        if(n1.length==0) n1 = "X"
        if(n2.length==0) n2 = "O"
        initialize()

    }
//    override fun onBackPressed() {
//       // clearDetails()
//        super.onBackPressed()
//    }
//    private fun clearDetails(){
//        val b1 = findViewById<Button>(R.id.mp)
//        val b2 = findViewById<Button>(R.id.bot)
//        b1.isClickable=true
//        b2.isClickable=true
//    }
    fun set1(view: View){
        display()
        val img = map.get(1)
        if(img==null) return
        img.isClickable = false
        if(play)
        img.setImageResource(R.drawable.x)
        else img.setImageResource(R.drawable.o)
        board[0][0] = if(play) player else opponent
        play = !play
        display()
    }
    fun set2(view: View){
        display()
        val img = map.get(2)
        if(img==null) return
        img.isClickable = false
        if(play)
            img.setImageResource(R.drawable.x)
        else img.setImageResource(R.drawable.o)
        board[1][0] = if(play) player else opponent
        play = !play
        display()
    }
    fun set3(view: View){
        display()
        val img = map.get(3)
        if(img==null) return
        img.isClickable = false
        if(play)
            img.setImageResource(R.drawable.x)
        else img.setImageResource(R.drawable.o)
        board[2][0] = if(play) player else opponent
        play = !play
        display()
    }
    fun set4(view: View){
        display()
        val img = map.get(4)
        if(img==null) return
        img.isClickable = false
        if(play)
            img.setImageResource(R.drawable.x)
        else img.setImageResource(R.drawable.o)
        board[0][1] = if(play) player else opponent
        display()
        play = !play
    }
    fun set5(view: View){
        display()
        val img = map.get(5)
        if(img==null) return
        img.isClickable = false
        if(play)
            img.setImageResource(R.drawable.x)
        else img.setImageResource(R.drawable.o)
        board[1][1] = if(play) player else opponent
        display()
        play = !play
    }
    fun set6(view: View){
        display()
        val img = map.get(6)
        if(img==null) return
        img.isClickable = false
        if(play)
            img.setImageResource(R.drawable.x)
        else img.setImageResource(R.drawable.o)
        board[2][1] = if(play) player else opponent
        play = !play
        display()
    }
    fun set7(view: View){
        display()
        val img = map.get(7)
        if(img==null) return
        img.isClickable = false
        if(play)
            img.setImageResource(R.drawable.x)
        else img.setImageResource(R.drawable.o)
        board[0][2] = if(play) player else opponent
        play = !play
        display()
    }
    fun set8(view: View){
        display()
        val img = map.get(8)
        if(img==null) return
        img.isClickable = false
        if(play)
            img.setImageResource(R.drawable.x)
        else img.setImageResource(R.drawable.o)
        board[1][2] = if(play) player else opponent
        play = !play
        display()
    }
    fun set9(view: View){
        display()
        val img = map.get(9)
        if(img==null) return
        img.isClickable = false
        if(play)
            img.setImageResource(R.drawable.x)
        else img.setImageResource(R.drawable.o)
        board[2][2] = if(play) player else opponent
        play = !play
        display()
    }

    private fun display(){
        val score = hasWon()
        val game = findViewById<TextView>(R.id.textView)
        if(score==10){
            game.text = n1 + " Won"
            pause()
        }
        else if(score==-10){
            game.text=n2+" Won"
            pause()
        }
        else if(draw()){
            game.text = "Game Draw"
        }
    }
    private fun pause(){
        for((key,value) in map){
            value.isClickable = false
        }
    }
    private fun draw():Boolean{
        val score = hasWon()
        if(score==10 || score==-10) return false
        for(i in 0..2){
            for(j in 0..2){
                if(board[i][j] == ' ') return false
            }
        }
        return true
    }
    private fun hasWon(): Int{
        for(i in 0..2){
            if(board[i][0] == board[i][1] && board[i][0] == board[i][2]) {

                if (board[i][0] == player) return 10;
                else if (board[i][0] == opponent) return -10;

            }
        }
        for(i in 0..2){
            if (board[0][i] == board[1][i] && board[0][i] == board[2][i]) {

                if (board[0][i] == player) return 10;
                else if (board[0][i] == opponent) return -10;

            }
        }
        if(board[0][0] == board[1][1] && board[0][0] == board[2][2]){
            if(board[0][0] == player) return 10;
            else if(board[0][0] == opponent) return -10;
        }
        if(board[0][2]==board[1][1] && board[0][2] == board[2][0]){
            if(board[0][2]==player) return 10;
            else if(board[0][2]==opponent) return -10;
        }
        return 0;
    }

    private fun initialize(){
        for(i in 0..2){
            for(j in 0..2){
                board[i][j]=' '
            }
        }
        map.put(1,findViewById(R.id.imageView))
        map.put(2,findViewById(R.id.imageView13))
        map.put(3,findViewById(R.id.imageView16))
        map.put(4,findViewById(R.id.imageView11))
        map.put(5,findViewById(R.id.imageView14))
        map.put(6,findViewById(R.id.imageView17))
        map.put(7,findViewById(R.id.imageView12))
        map.put(8,findViewById(R.id.imageView15))
        map.put(9,findViewById(R.id.imageView18))
    }
}