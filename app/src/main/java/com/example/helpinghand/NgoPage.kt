package com.example.helpinghand
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.helpinghand.databinding.ActivityDonateBinding.inflate
import com.example.helpinghand.databinding.ActivityNgoPageBinding
import kotlinx.android.synthetic.main.activity_ngo_page.*

class NgoPage : AppCompatActivity() {
    var selectedNgo:String?="GOONJ"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_ngo_page)//
        val binding=ActivityNgoPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val arrayList_City= arrayListOf<String>("Patiala","Gurgaon","Delhi","Chandigarh","Ludhiana")
        val arrayAdapter_City=ArrayAdapter(applicationContext,R.layout.layout,arrayList_City)
        binding.area.adapter=arrayAdapter_City
        val ArrayList_Gurgaon= arrayListOf<String>("Goonj","UTHAAN","HelpAgeIndia","LEPRA India","Cuddles")
        val ArrayList_Patiala= arrayListOf<String>("Autism India Today","Better Life Foundation","Asha School Patiala",
           "Cancer Council of India", "Dass Charitable Trust")
        val ArrayList_Delhi= arrayListOf<String>("Tarkeybein","Hemophiloa Federation","Maitri India","Armaan Foundation Society"
        ,"ARNAV CHARITABLE TRUST")
        val ArrayList_Chandigarh= arrayListOf<String>("Saathi","Nanhe Kadam","Arrive SAFE","EduCARE India","Noble Foundation")
        val ArrayList_Ludhiana= arrayListOf<String>("ANMOL NGO","Darpan","Guru Angad Dev Sewa Society","Disha Welfare Trust"
        ,"Adeeb International")
        val arrayAdapter_ngo=ArrayAdapter(applicationContext,R.layout.ngodisplay,ArrayList_Patiala)
        binding.ngo.adapter=arrayAdapter_ngo
        binding.area.onItemSelectedListener=object: AdapterView.OnItemSelectedListener
        {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
               if(p2==0)
               {
                   val arrayAdapter_ngo=ArrayAdapter(applicationContext,R.layout.ngodisplay,ArrayList_Patiala)
                   binding.ngo.adapter=arrayAdapter_ngo
                   binding.ngo.onItemSelectedListener=object:AdapterView.OnItemSelectedListener
                   {
                       override fun onItemSelected(parent: AdapterView<*>?, view: View?, pos: Int, id : Long) {
                           selectedNgo=ngo!!.getSelectedItem().toString();
                       }
                       override fun onNothingSelected(p0: AdapterView<*>?) {
                           Toast.makeText(applicationContext,"Please select a city to know various NGO'S that are there",Toast.LENGTH_LONG).show()
                       }
                   }
               }
                else if (p2==1)
               {
                   val arrayAdapter_ngo=ArrayAdapter(applicationContext,R.layout.ngodisplay,ArrayList_Gurgaon)
                   binding.ngo.adapter=arrayAdapter_ngo
                   binding.ngo.onItemSelectedListener=object:AdapterView.OnItemSelectedListener
                   {
                       override fun onItemSelected(parent: AdapterView<*>?, view: View?, pos: Int, id : Long) {
                           selectedNgo=ngo!!.getSelectedItem().toString();
                       }
                       override fun onNothingSelected(p0: AdapterView<*>?) {
                           Toast.makeText(applicationContext,"Please select a city to know various NGO'S that are there",Toast.LENGTH_LONG).show()
                       }
                   }
               }
                else if(p2==2)
               {
                   val arrayAdapter_ngo=ArrayAdapter(applicationContext,R.layout.ngodisplay,ArrayList_Delhi)
                   binding.ngo.adapter=arrayAdapter_ngo
                   binding.ngo.onItemSelectedListener=object:AdapterView.OnItemSelectedListener
                   {
                       override fun onItemSelected(parent: AdapterView<*>?, view: View?, pos: Int, id : Long) {
                           selectedNgo=ngo!!.getSelectedItem().toString();
                       }
                       override fun onNothingSelected(p0: AdapterView<*>?) {
                           Toast.makeText(applicationContext,"Please select a city to know various NGO'S that are there",Toast.LENGTH_LONG).show()
                       }
                   }

               }
                else if(p2==3)
               {
                   val arrayAdapter_ngo=ArrayAdapter(applicationContext,R.layout.ngodisplay,ArrayList_Chandigarh)
                   binding.ngo.adapter=arrayAdapter_ngo
               }
                else
               {
                   val arrayAdapter_ngo=ArrayAdapter(applicationContext,R.layout.ngodisplay,ArrayList_Ludhiana)
                   binding.ngo.adapter=arrayAdapter_ngo

               }

            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(applicationContext,"Please select a city to know various NGO'S that are there",Toast.LENGTH_LONG).show()
            }
        }
        volunteer.setOnClickListener {
            val intent=Intent(applicationContext,Volunteer::class.java)
            startActivity(intent)
        }
        locate.setOnClickListener {
             //Toast.makeText(this,"This functionality has not been implemented yet",Toast.LENGTH_SHORT).show()
         val intent=Intent(this,GooglyMaps::class.java)
            startActivity(intent)
        }
    }
    fun Donate(view:View)
    {
        val nextPage=Intent(applicationContext,Donate::class.java)
        nextPage.putExtra(Constants.name,selectedNgo)
        startActivity(nextPage)
    }


}