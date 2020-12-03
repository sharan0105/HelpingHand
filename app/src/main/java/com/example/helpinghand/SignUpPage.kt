package com.example.helpinghand
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sign_up_page.*
class SignUpPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_page)
        btnSubmit.setOnClickListener{
            if(etName.text.isEmpty() || etPassword.text.isEmpty() ||
                etContactNo.text.isEmpty() || etEmail.text.isEmpty())
            {
                Toast.makeText(this,"Please enter all details",Toast.LENGTH_SHORT).show()
            }
            else {
                var dbms = Handler(this)
                var name: String = etName.text.toString()
                var email = etEmail.text.toString()
                var phone = etContactNo.text.toString()
                var pass = etPassword.text.toString()
                if(phone.length!=10)
                {
                    Toast.makeText(this,"Invalid Contact Number",Toast.LENGTH_SHORT).show()
                    etContactNo.setText("")
                }
                else if(!email.contains('@') && !email.contains(".com") && !email.contains(".org"))
                {
                    Toast.makeText(this,"Invalid email id ",Toast.LENGTH_SHORT).show()
                }
                else if (pass.contains(name)) // password similar to name //
                {
                    Toast.makeText(this, "Password not Strong", Toast.LENGTH_SHORT).show()
                    etPassword.setText("")
                }
                else if (!pass.contains('@') && !pass.contains('-') && !pass.contains('_')
                    && !pass.contains('#') && !pass.contains('$')) {
                    Toast.makeText(
                        this,
                        "Password must contain 1 special char and a numeric",
                        Toast.LENGTH_SHORT
                    ).show()
                    etPassword.setText("")
                }
                else if (!pass.contains('1') && !pass.contains('2') && !pass.contains('3')
                    && !pass.contains('0')
                    && !pass.contains('4') && !pass.contains('5') && !pass.contains('6')
                    && !pass.contains('7') && !pass.contains('8') && !pass.contains('9'))
                {
                    Toast.makeText(
                        this,
                        "Password must contain atl least 1 special character  and a numeric",
                        Toast.LENGTH_SHORT
                    ).show()
                    etPassword.setText("")
                }
                else {
                    var obj = User(name, email, phone, pass)
                    var res: Long = dbms.insert(obj)
                    if (res > -1) {
                        Toast.makeText(this, "Succesfully registered", Toast.LENGTH_SHORT).show()
                        etName.setText("")
                        etPassword.setText("")
                        etEmail.setText("")
                        etContactNo.setText("")
                        val intent = Intent(this, MainActivity::class.java)
                        finish()
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}