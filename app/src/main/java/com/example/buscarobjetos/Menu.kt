package com.example.buscarobjetos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class Menu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
    }

    fun pantallaCarga(imagen: View){
        var intent = Intent(this, Juego::class.java)
        startActivity(intent)
        finish()
    }
}