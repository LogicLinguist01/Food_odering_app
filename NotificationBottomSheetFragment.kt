package com.example.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.splash.adapter.NotificationAdapter
import com.example.splash.databinding.FragmentNotificationBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class NotificationBottomSheetFragment : BottomSheetDialogFragment() {

private lateinit var binding: FragmentNotificationBottomSheetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentNotificationBottomSheetBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        val notifcation = listOf(" Order has been cancel"," order placed", "Order has been delivered")
        val notificationIcons = listOf(R.drawable.baseline_cancel_24, R.drawable.baseline_cancel_24, R.drawable.baseline_cancel_24)
        val adapter = NotificationAdapter( java.util.ArrayList(notifcation), ArrayList(notificationIcons))

        binding.notificationBottomSheetAdapter.adapter = adapter
        binding.notificationBottomSheetAdapter.layoutManager = LinearLayoutManager(requireContext())

        return binding.root
    }

    companion object {

    }
}