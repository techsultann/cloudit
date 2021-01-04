package com.techsultan.cloudit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

@Suppress("DEPRECATION")
class splash_screen : AppCompatActivity() {

    private val splashTime : Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed( {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, splashTime)
    }
}