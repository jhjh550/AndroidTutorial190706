package com.example.criminalintent

import android.util.Log
import java.util.*

class Crime{
    val uuid = UUID.randomUUID()
    var title: String = ""
    var date: Date = Date()
    var solved: Boolean = false
}
