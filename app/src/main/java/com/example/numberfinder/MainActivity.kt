package com.example.numberfinder

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val secret = (0..100).random()
        button.setOnClickListener {
            var guess: Int = ((inputUtente.text).toString()).toInt()
            if (guess == secret) {
                resultCheckString.text = "Complimenti. Hai indovinato il numero segreto!!!"
                numero_segreto.text = secret.toString()
                play_again.isVisible = true
                yes_play_button.isVisible = true
                no_play_button.isVisible = true
                yes_play_button.setOnClickListener {
                    val intent = intent
                    finish()
                    startActivity(intent)
                }
                no_play_button.setOnClickListener {
                    play_again.isVisible = false
                    yes_play_button.isVisible = false
                    no_play_button.isVisible = false
                    resultCheckString.text = "GRAZIE PER AVER GIOCATO, A PRESTO!"
                }
            } else {
                if (guess > secret) {
                    resultCheckString.text = "Mi dispiace, il numero segreto e' minore di quello inserito."
                } else {
                    resultCheckString.text = "Mi dispiace, il numero segreto e' maggiore di quello inserito."
                }
            }
        }
    }
}