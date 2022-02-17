package com.example.alarmclock

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.Toast

class Feedback : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedback)

        setSupportActionBar(findViewById(R.id.toolbar))

        val rBar = findViewById<RatingBar>(R.id.ratingBar)
        if (rBar != null) {
            val button = findViewById<Button>(R.id.button)
            button?.setOnClickListener {
                val msg = rBar.rating.toString()
                val s = "Rating is " + msg
                showToast(s)
                /*
                Toast.makeText(this,
                    "Rating is: "+msg, Toast.LENGTH_SHORT).show()
                */

            }
        }
    }

    fun showToast(s : String){
        val customLayout = layoutInflater.inflate(R.layout.toast_layout,  findViewById(R.id.toast_root))

            val toast = Toast(this)
            toast.duration = Toast.LENGTH_LONG
            toast.setGravity(Gravity.BOTTOM, 0, 0)
            val tv = customLayout.findViewById<EditText>(R.id.toast_text)
            tv.setText(s)
            toast.view = customLayout
            toast.show()
    }
}