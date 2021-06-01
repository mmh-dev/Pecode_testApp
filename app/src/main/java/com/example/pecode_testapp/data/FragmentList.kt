package com.example.pecode_testapp.data

import androidx.fragment.app.Fragment

object FragmentList{
    var fragments = mutableListOf<Fragment>()

    fun add(fragment: Fragment){
        fragments.add(fragment)
    }

    fun delete(fragment: Fragment){
        fragments.remove(fragment)
    }
}