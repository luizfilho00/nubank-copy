package br.com.nubankcopy

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.nubankcopy.databinding.ItemDummyBinding

class DummyAdapter : ListAdapter<Dummy, DummyViewHolder>(object : DiffUtil.ItemCallback<Dummy>() {
    override fun areItemsTheSame(oldItem: Dummy, newItem: Dummy): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Dummy, newItem: Dummy): Boolean {
        return oldItem == newItem
    }

}) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DummyViewHolder {
        return DummyViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: DummyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class DummyViewHolder private constructor(
    private val binding: ItemDummyBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(dummy: Dummy) {
        binding.textViewName.text = dummy.name
        binding.textViewDate.text = dummy.date
    }

    companion object {
        fun from(parent: ViewGroup): DummyViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = ItemDummyBinding.inflate(inflater, parent, false)
            return DummyViewHolder(binding)
        }
    }
}