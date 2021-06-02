package com.example.pecode_testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.pecode_testapp.data.FragmentList
import com.example.pecode_testapp.data.ViewPagerAdapter
import com.example.pecode_testapp.view.FragmentHome


class MainActivity : AppCompatActivity() {

    companion object{
        lateinit var viewPager: ViewPager
        private lateinit var adapter: ViewPagerAdapter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.viewPager)
        FragmentList.add(FragmentHome())
        adapter = ViewPagerAdapter(FragmentList.fragments, supportFragmentManager)
        viewPager.adapter = adapter

    }

    fun updateActivity() {
        adapter.notifyDataSetChanged()
    }

}