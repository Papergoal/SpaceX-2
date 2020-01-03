package com.example.spacex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.spacex.infosTest.HistoryFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cards = 10
        for (cardIndex in 1..cards)
        {
            val fragment = HistoryFragment()
            supportFragmentManager.beginTransaction().add(
                flexbox.id, fragment
            ).commit()
        }
    }

}
