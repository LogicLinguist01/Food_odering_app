package com.example.splash.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.splash.databinding.NotificationitemsBinding

class NotificationAdapter(
    private var notifications: ArrayList<String>,
    private var notificationIcons: ArrayList<Int>
) : RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        val binding = NotificationitemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NotificationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = notifications.size

    inner class NotificationViewHolder(private val binding: NotificationitemsBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) {
            binding.notificationText.text = notifications[position]
            binding.notificationImage.setImageResource(notificationIcons[position])
        }
    }
}
