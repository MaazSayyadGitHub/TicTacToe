package com.maaz.tictactoe_kotlin_project

import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.icu.number.IntegerWidth
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.winner_dialog.*

class GameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)


    }

    fun Btn_Click(view: View) {

        var cellId = 0 // button position.
        val buttonSelected =
            view as Button // which ever button is clicked we will get that button like this.

        when (buttonSelected.id) {
            R.id.btn1 ->
                cellId = 1
            R.id.btn2 ->
                cellId = 2
            R.id.btn3 ->
                cellId = 3
            R.id.btn4 ->
                cellId = 4
            R.id.btn5 ->
                cellId = 5
            R.id.btn6 ->
                cellId = 6
            R.id.btn7 ->
                cellId = 7
            R.id.btn8 ->
                cellId = 8
            R.id.btn9 ->
                cellId = 9
        }

        playGame(cellId, buttonSelected)

//        Log.d("Button Click : ", buttonSelected.id.toString())
//        Log.d("Cell Id : ", cellId.toString())
    }


    var activePlayer = 1
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()

    fun playGame(cellID: Int, btnSelected: Button) {
        if (activePlayer == 1) {
            btnSelected.text = "X"
            btnSelected.setBackgroundResource(R.drawable.player1box)

            player1.add(cellID) // this is for we can check who won.
            activePlayer = 2
        } else {
            // activePlayer = 2
            btnSelected.text = "O"
            btnSelected.setBackgroundResource(R.drawable.player2box)

            player2.add(cellID) // this is for we can check who won.
            activePlayer = 1
        }

        // by this selected button will not be click again.
        btnSelected.isEnabled = false

        // it will check one each level who is winner
        if (player1.size == 5 && player2.size == 4){
            drawGame()
        }
        checkWinner()
    }

    private fun drawGame() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.winner_dialog)
        dialog.winnerText.text = "Game Draw! Un Expectedly."
        dialog.exitBtn.setOnClickListener {
            val intent = Intent(this, WelcomeActivity::class.java)
            startActivity(intent)
            finish();
        }

        dialog.playAgainBtn.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            finish();
            startActivity(intent)
        }

        dialog.show()
    }

    fun checkWinner() {
        var winner = -1

        // row 1 winner
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1
        } else if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2
        }

        // row 2 winner
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1
        } else if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2
        }

        // row 3 winner
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1
        } else if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2
        }

        // column 1 winner
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1
        } else if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2
        }

        // column 2 winner
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1
        } else if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2
        }

        // column 3 winner
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1
        } else if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2
        }

        // cross left winner
        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            winner = 1
        } else if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            winner = 2
        }

        // cross right winner
        if (player1.contains(3) && player1.contains(5) && player1.contains(7)) {
            winner = 1
        } else if (player2.contains(3) && player2.contains(5) && player2.contains(7)) {
            winner = 2
        }


        // Showing Dialog on Finish & Winning

        if (winner == 1) {

            val dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setCancelable(false)
            dialog.setContentView(R.layout.winner_dialog)
            dialog.winnerText.text = "Player 1 Win The Game!"
            dialog.exitBtn.setOnClickListener {
                val intent = Intent(this, WelcomeActivity::class.java)
                startActivity(intent)
                finish();
            }

            dialog.playAgainBtn.setOnClickListener {
                val intent = Intent(this, GameActivity::class.java)
                finish();
                startActivity(intent)
            }
            dialog.show()

        } else if (winner == 2) {

            val dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setCancelable(false)
            dialog.setContentView(R.layout.winner_dialog)
            dialog.winnerText.text = "Player 2 Win The Game!"
            dialog.exitBtn.setOnClickListener {
                val intent = Intent(this, WelcomeActivity::class.java)
                startActivity(intent)
                finish();
            }

            dialog.playAgainBtn.setOnClickListener {
                val intent = Intent(this, GameActivity::class.java)
                finish();
                startActivity(intent)
            }

            dialog.show()

        }



            /*
        // winner
        if (winner == 1)
            Toast.makeText(this, "Player One is Winner", Toast.LENGTH_LONG).show()
        else if (winner == 2)
            Toast.makeText(this, "Player Two is Winner", Toast.LENGTH_LONG).show()
         */
    }
}
