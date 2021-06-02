package com.example.pecode_testapp.data

import androidx.fragment.app.Fragment
import com.example.pecode_testapp.MainActivity

object FragmentList{
    var fragments = mutableListOf<Fragment>()

    fun add(fragment: Fragment){
        fragments.add(fragment)
    }

    fun delete(fragment: Fragment){
        fragments.remove(fragment)
    }

    fun update(){
        val main = MainActivity()
        main.updateActivity()
    }

    fun switchToPage(newPagePosition: Int) {
        MainActivity.viewPager.currentItem = newPagePosition
    }
}