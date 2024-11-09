package com.subhajeet.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class AvengersActivity : AppCompatActivity() {

    var titleName: String? = "Avengers"
    lateinit var sharedPreferences: SharedPreferences
    lateinit var btnLogout : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)
        setContentView(R.layout.activity_avengers)
        println("onCreate called")

        btnLogout = findViewById(R.id.btnLogout)


        titleName = sharedPreferences.getString("Title","The Avengers")
        title = titleName

        btnLogout.setOnClickListener {
            sharedPreferences.edit().clear().apply()
            val intent = Intent(this@AvengersActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

}

