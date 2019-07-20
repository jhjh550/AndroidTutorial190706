package com.example.criminalintent

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import kotlinx.android.synthetic.main.activity_crime_pager.*
import java.util.*

class CrimePagerActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crime_pager)

        val crimeID = intent.getSerializableExtra(EXTRA_CRIME_ID) as UUID
        crimeViewPager.adapter = CrimeViewPagerAdapter(supportFragmentManager)
        for(i in 0..CrimeLab.crimes.size){
            if(CrimeLab.crimes[i].uuid == crimeID){
                crimeViewPager.currentItem = i
                break
            }
        }
    }

    class CrimeViewPagerAdapter(fm: FragmentManager): FragmentStatePagerAdapter(fm){
        override fun getItem(position: Int): Fragment {
            val crimeId = CrimeLab.crimes[position].uuid
            return CrimeFragment.newInstance(crimeId)
        }

        override fun getCount(): Int {
            return CrimeLab.crimes.size
        }
    }

    companion object{
        private const val EXTRA_CRIME_ID = "EXTRA_CRIME_ID"

        fun newIntent(context: Context, crimeID: UUID): Intent {
            val intent = Intent(context, CrimePagerActivity::class.java)
            intent.putExtra(EXTRA_CRIME_ID, crimeID)
            return intent
        }
    }
}