package com.example.aibot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.math.min

class SinglePlayer : AppCompatActivity() {

    var map = hashMapOf<Int,ImageView>()
    var board = Array(3){CharArray(3)}
    val player = 'X'
    val opponent = 'O'
    var play: Boolean = true
    var n: String = ""
    var ended: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_player)

        n = intent.getStringExtra("name1").toString()
        if(n.length==0) n = "X"
        initialize()
        for((key,value) in map){
            value.isClickable = true
        }

    }
//    override fun onBackPressed() {
//        //clearDetails()
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
        if(!play)
        makeMove()
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
        if(!play)
        makeMove()
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
        if(!play)
        makeMove()
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
        if(!play)
        makeMove()
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
        if(!play)
        makeMove()
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
        if(!play)
        makeMove()
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
        if(!play)
        makeMove()
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
        if(!play)
            makeMove()
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
        if(!play)
        makeMove()
    }
    private fun display(){
        val score = hasWon()
        val game = findViewById<TextView>(R.id.textView)
        if(score==10){
            game.text = n + " Won"
            ended = true
            pause()
        }
        else if(score==-10){
            game.text="O"+" Won"
            ended = true
            pause()
        }
        else if(draw()){
            game.text = "Game Draw"
            ended = true
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
    private fun makeMove(){
        if(ended) return
        val move = m(-1,-1)
        var depth: Int = Int.MAX_VALUE
        for(i in 0..2){
            for(j in 0..2){
                if(board[i][j]==' '){
                    board[i][j] = opponent
                    var currScore = miniMax(0,true)
                    if(depth>currScore){
                        depth = currScore
                        move.i = i
                        move.j = j
                    }
                    board[i][j] = ' '
                }
            }
        }
        if(move.i==0){
            if(move.j==0) set1(View(this))
            if(move.j==1) set4(View(this))
            if(move.j==2) set7(View(this))
        }
        if(move.i==1){
            if(move.j==0) set2(View(this))
            if(move.j==1) set5(View(this))
            if(move.j==2) set8(View(this))
        }
        if(move.i==2){
            if(move.j==0) set3(View(this))
            if(move.j==1) set6(View(this))
            if(move.j==2) set9(View(this))
        }
    }
    private fun miniMax(depth:Int, x:Boolean): Int{
        val won = hasWon()
        if(won==10) return won-depth
        if(won==-10) return won+depth
        if(draw()) return 0
        if(x){
            var currScore: Int = Int.MIN_VALUE
            for(i in 0..2){
                for(j in 0..2){
                    if(board[i][j]==' '){
                        board[i][j] = player
                        val c = miniMax(depth+1,!x)
                        if(c>currScore) currScore = c
                        board[i][j] = ' '
                    }
                }
            }
            return currScore
        }
        else{
            var currScore: Int = Int.MAX_VALUE
            for(i in 0..2){
                for(j in 0..2){
                    if(board[i][j] == ' '){
                        board[i][j]=opponent
                        val c = miniMax(depth+1,!x)
                        if(c<currScore) currScore = c
                        board[i][j] = ' '
                    }
                }
            }
            return currScore
        }
    }

}
class m{
    var i:Int
    var j:Int
    constructor(i:Int, j:Int){
        this.i = i
        this.j = j
    }
}
