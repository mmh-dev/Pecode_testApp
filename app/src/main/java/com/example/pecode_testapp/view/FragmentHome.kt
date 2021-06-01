package com.example.pecode_testapp.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.FragmentManager
import com.example.pecode_testapp.R
import com.example.pecode_testapp.data.FragmentList
import javax.security.auth.login.LoginException

private lateinit var addBtn: AppCompatButton
private lateinit var deleteBtn: AppCompatButton
private lateinit var notificationBtn: AppCompatButton

class FragmentHome : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        deleteBtn = view.findViewById(R.id.minus_btn)
        deleteBtn.visibility = View.INVISIBLE
        addBtn = view.findViewById(R.id.plus_btn)
        addBtn.setOnClickListener(View.OnClickListener {
            parentFragmentManager.beginTransaction().apply{
                val fragment = FragmentHome()
                FragmentList.add(fragment)
                fragment.view?.findViewById<AppCompatButton>(R.id.minus_btn)?.visibility = View.VISIBLE
                fragment.view?.findViewById<TextView>(R.id.page_number)?.text = (FragmentList.fragments.size.toString())
                replace(R.id.viewPager, fragment)
                commit()
            }
            Log.i("TAG", FragmentList.fragments.size.toString())
        })
    }
}