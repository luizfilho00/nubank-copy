package br.com.nubankcopy

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.nubankcopy.databinding.ItemMenuBinding

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

class MenuViewHolder(
    private val binding: ItemMenuBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(menuItem: MenuItem) {
        with(binding) {
            imageView.setImageDrawable(root.context.getDrawable(menuItem.icon))
            textView.text = menuItem.text
        }
    }

    companion object {
        fun inflate(parent: ViewGroup) = MenuViewHolder(
            ItemMenuBinding.inflate(LayoutInflater.from(parent.context))
        )
    }
}

