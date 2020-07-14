package com.example.mongleandroid.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.annotation.UiThread
import com.bumptech.glide.Glide
import com.example.mongleandroid.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val load: ImageView = findViewById(R.id.img_splash_gif) as ImageView
        Glide.with(this).load(R.drawable.splash).into(load)

        startLoading()


    }
    private fun startLoading() {
        val handler = Handler()
        handler.postDelayed(Runnable {
            val intent = Intent(baseContext, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 4000)
    }


}