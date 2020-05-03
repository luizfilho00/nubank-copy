package br.com.nubankcopy

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

class MenuAdapter : ListAdapter<MenuItem, MenuViewHolder>(
    object : DiffUtil.ItemCallback<MenuItem>() {
        override fun areItemsTheSame(oldItem: MenuItem, newItem: MenuItem) =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: MenuItem, newItem: MenuItem) =
            oldItem == newItem

    }
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MenuViewHolder.inflate(parent)

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

