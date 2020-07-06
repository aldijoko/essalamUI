package com.example.essalamui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.essalamui.beranda.view.BerandaActivity

class MainActivity : AppCompatActivity() {
    private val SPLASH_TIME_OUT = 3000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /* Register layout */
        //setContentView(R.layout.activity_registrasi)

        setContentView(R.layout.layout_splash)
        Handler().postDelayed(
            {
                val i = Intent(this, BerandaActivity::class.java)
                startActivity(i)
                finish()
            }, SPLASH_TIME_OUT
        )
    }
}