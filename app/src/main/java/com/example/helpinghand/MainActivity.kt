package com.example.helpinghand
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnLogin.setOnClickListener{
            // what happens when the user clicks on the login button //
            if(etEmail.text.toString().length==0 || etPassword.text.toString().length==0)
            {
                Toast.makeText(this,"Can't login as all details are not" +
                        " entered",Toast.LENGTH_LONG).show()
                etEmail.setText("")
                etPassword.setText("")
            }
            else
            {
                var count=0;
                var email=etEmail.text.toString()
                var pass=etPassword.text.toString()
                var db=Handler(this)
                var values:ArrayList<User> =db.getData()
                var i=0;
                for(i in 0..values.size-1)
                {
                    var data:User=values.get(i)
                    var id=data.email
                    var key=data.pass
                    if(email==id && pass==key)
                    {
                        count=1;
                        Toast.makeText(this,"Login Credentials verified",Toast.LENGTH_SHORT).show()
                        etEmail.setText("")
                        etPassword.setText("")
                        val intent=Intent(this,NgoPage::class.java)
                        startActivity(intent)
                        finish()
                        break;
                    }

                }
                if(count==0)
                {
                    Toast.makeText(this,"Invalid Details",Toast.LENGTH_SHORT).show()
                }
            }
        }
        btnSignUp.setOnClickListener{
            val intent= Intent(this,SignUpPage::class.java)
            startActivity(intent)
        }
    }
}