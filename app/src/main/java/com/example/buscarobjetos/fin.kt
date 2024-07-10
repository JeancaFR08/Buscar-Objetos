package com.example.buscarobjetos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class fin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fin)
    }

    fun pantallaCarga(imagen: View){
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}