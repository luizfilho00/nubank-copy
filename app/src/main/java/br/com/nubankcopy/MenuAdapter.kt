package br.com.nubankcopy

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.nubankcopy.databinding.ItemMenuBinding

class MenuAdapter : ListAdapter<String, MenuViewHolder>(
    object : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String) =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: String, newItem: String) =
            oldItem == newItem

    }
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MenuViewHolder.inflate(parent)

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        //TODO
    }
}

class MenuViewHolder(binding: ItemMenuBinding) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun inflate(parent: ViewGroup) = MenuViewHolder(
            ItemMenuBinding.inflate(LayoutInflater.from(parent.context))
        )
    }
}

