package com.example.criminalintent

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_crime.*
import java.util.*

class CrimeFragment : Fragment(){
    var crime: Crime? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val crimeID = arguments?.getSerializable(ARG_CRIME_ID) as UUID
        crime = CrimeLab.getCrime(crimeID)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        crime_title.setText(crime?.title)
        crime_title.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                crime?.title = s.toString()
            }

        })

        crime_date.text = Date().toString()
        crime_date.isEnabled = false

        crime_solved.isChecked = crime?.solved ?: false
        crime_solved.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener{
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                crime?.solved = isChecked
            }

        })
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_crime,
            container, false)

        return view
    }

    companion object{
        private const val ARG_CRIME_ID = "ARG_CRIME_ID"
        fun newInstance(crimeID: UUID): CrimeFragment{
            return CrimeFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_CRIME_ID, crimeID)
                }
            }
        }
    }
}