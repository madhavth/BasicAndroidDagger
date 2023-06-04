package com.example.androidappbasic.features.home.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.androidappbasic.databinding.CommentItemBinding
import com.example.androidappbasic.features.home.domain.entities.MyComment

class CommentListAdapter(val callBack: (MyComment) -> Unit = {}) :
    ListAdapter<MyComment, CommentListAdapter.ItemViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            CommentItemBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            ), callBack
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ItemViewHolder(
        private val itemViewBinding: CommentItemBinding, val callBack: (MyComment) -> Unit
    ) : RecyclerView.ViewHolder(itemViewBinding.root) {
        fun bind(item: MyComment) = with(itemViewBinding) {
            tvComment.text = item.body

            root.setOnClickListener {
                callBack(item)
            }
        }
    }
}

class DiffCallback : DiffUtil.ItemCallback<MyComment>() {
    override fun areItemsTheSame(oldItem: MyComment, newItem: MyComment): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: MyComment, newItem: MyComment): Boolean {
        return oldItem == newItem
    }
}