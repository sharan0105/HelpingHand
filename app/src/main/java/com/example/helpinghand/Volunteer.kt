package com.example.helpinghand

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_volunteer.*

class Volunteer : AppCompatActivity() {
    var display:String="1) "+"Volunteer must be above 14 years of age"+"\n"+"2) "+"Donation can be in kind or cash"
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volunteer)
        etNgoName.setText("GOONJ")
        etDetails.setText(display)
        btnSubmit.setOnClickListener {
            val intent= Intent(this,NgoPage::class.java)
            Toast.makeText(this,"You have now volunteered for the given NGO",Toast.LENGTH_SHORT).show()
            startActivity(intent)
            finish()
        }
    }
}