package com.example.pecode_testapp.view

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RemoteViews
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import com.example.pecode_testapp.MainActivity
import com.example.pecode_testapp.R
import com.example.pecode_testapp.data.FragmentList

class FragmentHome : Fragment() {

    private lateinit var addBtn: AppCompatButton
    private lateinit var deleteBtn: AppCompatButton
    private lateinit var notificationBtn: AppCompatButton
    private lateinit var pageNumber: TextView
    lateinit var notificationManager: NotificationManager
    lateinit var notificationChannel: NotificationChannel
    lateinit var builder: Notification.Builder
    private val channelId = "com.example.pecode_testapp.view"
    private val desc = "Test notification"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        deleteBtn = view.findViewById(R.id.minus_btn)
        if (FragmentList.fragments.size == 1){
            deleteBtn.visibility = View.INVISIBLE
        }

        pageNumber = view.findViewById(R.id.page_number)
        pageNumber.text = FragmentList.fragments.size.toString()

        addBtn = view.findViewById(R.id.plus_btn)

        addBtn.setOnClickListener {
            val fragment = FragmentHome()
            FragmentList.add(fragment)
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.viewPager, fragment)
                commit()
            }
            FragmentList.update()
            FragmentList.switchToPage(FragmentList.fragments.size - 1)
            Log.i("TAG", FragmentList.fragments.size.toString())
        }
        deleteBtn.setOnClickListener {

        }

        val intent = Intent(requireContext(), MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(requireContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        val notificationLayout  = RemoteViews(context?.packageName, R.layout.notif_layout)
        notificationLayout.setTextViewText(R.id.notification_title, "Notification " + FragmentList.fragments.size)
        notificationLayout.setTextViewText(R.id.notification_text, "You create a notification")

        notificationManager = getSystemService(requireContext(), NotificationManager::class.java) as NotificationManager
        notificationBtn = view.findViewById(R.id.notification_btn)
        notificationBtn.setOnClickListener {
            notificationChannel = NotificationChannel(channelId, desc, NotificationManager.IMPORTANCE_HIGH)
            notificationChannel.enableLights(true)
            notificationChannel.lightColor = Color.GREEN
            notificationChannel.enableVibration(false)
            notificationManager.createNotificationChannel(notificationChannel)

            builder = Notification.Builder(requireContext(), channelId)
                .setContent(notificationLayout)
                .setLargeIcon(BitmapFactory.decodeResource(this.resources,R.drawable.notif_icon))
                .setSmallIcon(R.drawable.notif_icon)
                .setContentIntent(pendingIntent)

            notificationManager.notify(1, builder.build())
        }
    }
}