package com.example.pecode_testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.pecode_testapp.data.FragmentCallback
import com.example.pecode_testapp.data.FragmentList
import com.example.pecode_testapp.data.ViewPagerAdapter
import com.example.pecode_testapp.view.FragmentHome

private lateinit var viewPager: ViewPager2
private lateinit var adapter: ViewPagerAdapter

class MainActivity : AppCompatActivity(), FragmentCallback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.viewPager)

        FragmentList.add(FragmentHome())

        adapter = ViewPagerAdapter(FragmentList.fragments, this)
        viewPager.adapter = adapter

    }

    override fun goto(pos: Int) {

    }
}