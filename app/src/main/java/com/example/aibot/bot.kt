package com.example.aibot

import android.annotation.SuppressLint
import android.media.Image
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.aibot.R.id

class bot : AppCompatActivity() {
    private var num : Boolean = true
    val player: Char = 'X'
    val opponent:Char = 'O'
    var gameOver = false
    var name: String = ""
    var game: String = ""
    var newTurn: Boolean = false
    private var board = Array(3){ arrayOfNulls<Char>(3) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bot)
        name = intent.getStringExtra("n1").toString()
        game = intent.getStringExtra("game").toString()
        //initialize()
      //  lock(set)
    }
//    private fun initialize(){
//        for(i in 0..2){
//            for(j in 0..2){
//                board[i][j] = ' '
//            }
//        }
//    }
//    fun miniMax(depth: Int, isMaximizing: Boolean): Int {
//        val score = hasWon()
//        if (score == 10) return score - depth
//        if (score == -10) return score + depth
//        if (isDraw()) return 0
//        return if (isMaximizing) {
//            var best = Int.MIN_VALUE
//            for (i in 0..2) {
//                for (j in 0..2) {
//                    if (board[i][j] == ' ') {
//                        board[i][j] = player
//                        best = Math.max(best, miniMax( depth + 1, !isMaximizing))
//                        board[i][j] = ' '
//                    }
//                }
//            }
//            best
//        } else {
//            var best = Int.MAX_VALUE
//            for (i in 0..2) {
//                for (j in 0..2) {
//                    if (board[i][j] == '_') {
//                        board[i][j] = opponent
//                        best = Math.min(best, miniMax(depth + 1, !isMaximizing))
//                        board[i][j] = ' '
//                    }
//                }
//            }
//            best
//        }
//    }
//    fun isDraw(): Boolean{
//        if(hasWon()!=0) return false
//        for(i in 0..2){
//            for(j in 0..2){
//                if(board[i][j]==' ') return false
//            }
//        }
//        return true
//    }
//    fun bestMove(): Move {
//        val m = Move(-1, -1)
//        var score = Int.MAX_VALUE
//        for (i in 0..2) {
//            for (j in 0..2) {
//                if (board[i][j] == ' ') {
//                    board[i][j] = opponent
//                    val value = miniMax( 0, true)
//                    board[i][j] = ' '
//                    if (value < score) {
//                        score = value
//                        m.i = i
//                        m.j = j
//                    }
//                }
//            }
//        }
//        return m
//    }
//    private fun makeMove(){
//        val m = bestMove()
//        val i=m.i
//        val j=m.j
//        newTurn = false
//        if(isDraw()) return
//        if(hasWon()!=0) return
//        if(i==-1 || j==-1) return
//        board[i][j] = opponent
//        if(i==0){
//            if(j==0){
//                val cross = findViewById<ImageView>(id.imageView2)
//                if(num)
//                    cross.setImageResource(R.drawable.cross)
//                else cross.setImageResource(R.drawable.zero)
//              //  cross.isEnabled = false
//            }
//            if(j==1) {
//                val cross = findViewById<ImageView>(id.imageView4)
//                if(num)
//                    cross.setImageResource(R.drawable.cross)
//                else cross.setImageResource(R.drawable.zero)
//            //    cross.isEnabled = false
//            }
//            if(j==2){
//                val cross = findViewById<ImageView>(id.imageView3)
//                if(num)
//                    cross.setImageResource(R.drawable.cross)
//                else cross.setImageResource(R.drawable.zero)
//            //    cross.isEnabled = false
//            }
//        }
//        else if(i==1){
//            if(j==0) {
//                val cross = findViewById<ImageView>(id.imageView5)
//                if(num)
//                    cross.setImageResource(R.drawable.cross)
//                else cross.setImageResource(R.drawable.zero)
//            //    cross.isEnabled = false
//            }
//            if(j==1) {
//                val cross = findViewById<ImageView>(id.imageView6)
//                if(num)
//                    cross.setImageResource(R.drawable.cross)
//                else cross.setImageResource(R.drawable.zero)
//            //    cross.isEnabled = false
//            }
//            if(j==2) set8(View(this));
//        }
//        else if(i==2){
//            if(j==0) {
//                val cross = findViewById<ImageView>(id.imageView8)
//                if(num)
//                    cross.setImageResource(R.drawable.cross)
//                else cross.setImageResource(R.drawable.zero)
//             //   cross.isEnabled = false
//            }
//            if(j==1) {
//                val cross = findViewById<ImageView>(id.imageView9)
//                if(num)
//                    cross.setImageResource(R.drawable.cross)
//                else cross.setImageResource(R.drawable.zero)
//            //    cross.isEnabled = false
//            }
//            if(j==2){
//                val cross = findViewById<ImageView>(id.imageView10)
//                if(num)
//                    cross.setImageResource(R.drawable.cross)
//                else cross.setImageResource(R.drawable.zero)
//            //    cross.isEnabled = false
//            }
//        }
//        val x=5;
//        num = true
//    }
//    private fun hasWon() : Int{
//        for(i in 0..2){
//            if(board[i][0] == board[i][1] && board[i][0] == board[i][2]) {
//                if (board[i][0] == player) return 10;
//                else if (board[i][0] == opponent) return -10;
//            }
//        }
//        for(i in 0..2) {
//            if (board[0][i] == board[1][i] && board[0][i] == board[2][i]) {
//                if (board[0][i] == player) return 10;
//                else if (board[0][i] == opponent) return -10;
//            }
//        }
//        if(board[0][0] == board[1][1] && board[0][0] == board[2][2]){
//                if(board[0][0] == player) return 10;
//                else if(board[0][0] == opponent) return -10;
//        }
//        if(board[0][2]==board[1][1] && board[0][2] == board[2][0]){
//                if(board[0][2]==player) return 10;
//                else if(board[0][2]==opponent) return -10;
//        }
//        return 0;
//    }
//    fun lock(){
//        for(v in set){
//            v.isEnabled = false
//        }
//    }
//    fun lock(set: HashSet<ImageView>){
//        for(v in set){
//            v.isEnabled = true
//        }
//    }
}
class Move(var i: Int, var j: Int)