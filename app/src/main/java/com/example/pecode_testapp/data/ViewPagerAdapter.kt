package com.example.pecode_testapp.data

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(
    private val fragments: MutableList<Fragment>,
    fragmentManager: FragmentManager
) : FragmentPagerAdapter(fragmentManager) {
    override fun getCount(): Int {
        return fragments.size
    }

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }
}