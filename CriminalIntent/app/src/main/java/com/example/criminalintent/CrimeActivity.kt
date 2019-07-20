package com.example.criminalintent

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import java.util.*

class CrimeActivity : SingleFragmentActivity() {
    override fun createFragment(): Fragment {
        val crimeID = intent.getSerializableExtra(EXTRA_CRIME_ID) as UUID
        return CrimeFragment.newInstance(crimeID)
    }

    companion object{
        private const val EXTRA_CRIME_ID = "EXTRA_CRIME_ID"
        fun newIntent(context: Context, crimeID: UUID): Intent {
            val intent = Intent(context, CrimeActivity::class.java)
            intent.putExtra(EXTRA_CRIME_ID, crimeID)
            return intent
        }
    }
}
