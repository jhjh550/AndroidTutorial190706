package com.example.criminalintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class CrimeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crime)

        var fragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container)

        if(fragment == null){
            fragment = CrimeFragment()
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, fragment)
                .commit()
        }
    }
}
