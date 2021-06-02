package com.example.pecode_testapp.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.example.pecode_testapp.R
import com.example.pecode_testapp.data.FragmentList

class FragmentHome : Fragment() {

    private lateinit var addBtn: AppCompatButton
    private lateinit var deleteBtn: AppCompatButton
    private lateinit var notificationBtn: AppCompatButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        deleteBtn = view.findViewById(R.id.minus_btn)
        deleteBtn.visibility = View.INVISIBLE

        addBtn = view.findViewById(R.id.plus_btn)

        addBtn.setOnClickListener {
            val fragment = Fragment(R.layout.fragment_home)
            FragmentList.add(fragment)
            val fragmentView = fragment.view
            val fragmentPageNumber = fragmentView?.findViewById<TextView>(R.id.page_number)
            fragmentPageNumber?.text = FragmentList.fragments.size.toString()
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.viewPager, fragment)
                commit()
            }
            FragmentList.update()
//            FragmentList.switchToPage(FragmentList.fragments.size - 1)
            Log.i("TAG", FragmentList.fragments.size.toString())
        }
        deleteBtn.setOnClickListener {

        }
        return view
    }
}