package com.example.a4_8_1_kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.a4_8_1_kotlin.fragment.FirstFragment
import com.example.a4_8_1_kotlin.fragment.SecondFragment

class MainActivity2 : AppCompatActivity(), FirstFragment.FirstListner,
    SecondFragment.SecondListner {
    var firstFragment: FirstFragment? = null
    var secondFragment: SecondFragment? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        initViews()
    }

    fun initViews() {
        firstFragment = FirstFragment()
        secondFragment = SecondFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.firstLayout, firstFragment!!)
            .replace(R.id.seconLayout, secondFragment!!)
            .commit()
    }

    override fun onFirstSend(str: String?) {
        secondFragment?.updateSecondText(str)
    }

    override fun onSeconSend(str: String?) {
        firstFragment?.updateFirstText(str)
    }
}