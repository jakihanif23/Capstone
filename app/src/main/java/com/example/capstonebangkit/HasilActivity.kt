package com.example.capstonebangkit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_hasil.*

class HasilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hasil)



        btn_hasil.setOnClickListener{
            this.startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}