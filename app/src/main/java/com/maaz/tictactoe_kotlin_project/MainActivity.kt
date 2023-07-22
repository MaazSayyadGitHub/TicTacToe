package com.maaz.tictactoe_kotlin_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.os.HandlerCompat.postDelayed
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // image & text will be invisible first and then come from top and bottom.
        logo.translationY = -1000f
        txtName.translationY = 1000f // value in float

        // get image from top to center
        logo.animate().translationY(0f).duration = 2000
        // get text back from bottom to center
        txtName.animate().translationY(0f).duration = 2000


        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, WelcomeActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)


    }
}