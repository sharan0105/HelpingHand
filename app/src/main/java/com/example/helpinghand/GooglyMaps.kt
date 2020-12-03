package com.example.helpinghand

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.widget.Autocomplete
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode
import kotlinx.android.synthetic.main.activity_googly_maps.*
import java.lang.Exception

class GooglyMaps : AppCompatActivity() {
    companion object
    {
        private const val LOCATION_REQ=1
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_googly_maps)
        if(!Places.isInitialized())
        {
            Places.initialize(this,"R.string.gmap_api_key")
        }
            val fields= listOf(Place.Field.NAME,Place.Field.ADDRESS)
            val intent:Intent=Autocomplete.IntentBuilder(
                AutocompleteActivityMode.OVERLAY
                ,fields).build(this@GooglyMaps)
        startActivityForResult(intent, LOCATION_REQ)
        }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
         if(requestCode== LOCATION_REQ)
        {
            if(resultCode== RESULT_OK)
            {
                var place:Place=Autocomplete.getPlaceFromIntent(data!!)
                tv1.setText(place.name)
            }
            else
            {
                Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show()
            }

            }
        }
    }
