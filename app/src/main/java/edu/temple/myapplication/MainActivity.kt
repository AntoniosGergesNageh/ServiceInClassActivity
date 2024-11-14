package edu.temple.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var timerTextView: TextView
    var timerBinder: TimerService.TimerBinder? = null
    var isconnected = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        timerTextView = findViewById(R.id.textView)
        val button = findViewById<Button>(R.id.startButton)
        button.setOnClickListener {
            if (isconnected && button.text == "Start") {
                timerBinder?.start(100)
                button.text = "Pause"

            } else if (isconnected && button.text == "Pause") {
                timerBinder?.pause()
                button.text = "Start"
            }
        }

        findViewById<Button>(R.id.stopButton).setOnClickListener {
            timerBinder?.stop()
        }
    }


}
