package com.example.helpinghand
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.helpinghand.databinding.ActivityNgoPageBinding
import kotlinx.android.synthetic.main.activity_donate.*

class Donate : AppCompatActivity() {
    var option:String="GOONJ"
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_donate)
        option
        textView1.text=option
        donate.setOnClickListener {
            Toast.makeText(this,"You have successfully doanted the amount", Toast.LENGTH_LONG).show()
            val intent= Intent(this,NgoPage::class.java)
            finish()
            startActivity(intent)
        }

    }
}