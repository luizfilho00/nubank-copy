package br.com.nubankcopy

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.nubankcopy.databinding.ItemMenuBinding

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