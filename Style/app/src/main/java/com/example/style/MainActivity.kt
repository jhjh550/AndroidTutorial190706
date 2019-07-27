package com.fieldbear.style

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TableRow
import com.example.style.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val numberClickListener = View.OnClickListener {
            val btn = it as Button
            if(workingTextView.text.equals("0")){
                workingTextView.text = btn.text
            }else{
                workingTextView.append(btn.text)
            }
        }

        var number = 1
        for(i in 2..tableLayout.childCount-2){
            val row = tableLayout.getChildAt(i) as TableRow

            for(k in 0..row.childCount-1){
                val btn = row.getChildAt(k) as Button
                btn.text = number.toString()
                number += 1
                btn.setOnClickListener(numberClickListener)
            }
        }
        val bottomIndex = tableLayout.childCount
        val bottomRow = tableLayout.getChildAt(bottomIndex-1) as TableRow
        val zeroBtn = bottomRow.getChildAt(1) as Button
        zeroBtn.text = "0"
        zeroBtn.setOnClickListener(numberClickListener)

        val deleteBtn = bottomRow.getChildAt(0) as Button
        deleteBtn.text = "delete"
        deleteBtn.setOnClickListener {
            workingTextView.text = "0"
        }

        val enterBtn = bottomRow.getChildAt(2) as Button
        enterBtn.text = "enter"
        enterBtn.setOnClickListener {
            selectedTextView.text = workingTextView.text
            workingTextView.text = "0"
        }

    }
}
