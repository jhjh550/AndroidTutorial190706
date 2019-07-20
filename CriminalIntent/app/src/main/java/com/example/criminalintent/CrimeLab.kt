package com.example.criminalintent

import java.util.*

object CrimeLab{
    val crimes = mutableListOf<Crime>()

    init {
        for(i in 1..100){
            var crime = Crime()
            crime.title = "범죄 #"+i
            crime.solved = i%2 == 0
            crimes.add(crime)
        }
    }

    fun getCrime(id: UUID): Crime?{
        for(crime in crimes){
            if(crime.uuid.equals(id))
                return crime
        }
        return null
    }
}