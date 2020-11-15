package com.itexus.core.databinding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

fun <E> listAdapter(
    @LayoutRes layoutResId: Int,
    itemCallback: DiffUtil.ItemCallback<E>,
    bindData: (E, View, Int) -> Unit
): ListAdapter<E, RecyclerView.ViewHolder> {
    return object : ListAdapter<E, RecyclerView.ViewHolder>(itemCallback) {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            val itemView = LayoutInflater
                .from(parent.context)
                .inflate(layoutResId, parent, false)
            return object : RecyclerView.ViewHolder(itemView) {}
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            bindData(getItem(position), holder.itemView, position)
        }
    }
}

fun <E> LifecycleOwner.recyclerAdapter(
    @LayoutRes layoutResId: Int,
    items: LiveData<List<E>>,
    bindData: (E, View, Int) -> Unit
): RecyclerView.Adapter<RecyclerView.ViewHolder> {
    val adapter = object : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            val itemView = LayoutInflater
                .from(parent.context)
                .inflate(layoutResId, parent, false)
            return object : RecyclerView.ViewHolder(itemView) {}
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            items.value?.get(position)?.let { bindData(it, holder.itemView, position) }
        }

        override fun getItemCount() = items.value?.count() ?: 0
    }
    items.observe(this, Observer { adapter.notifyDataSetChanged() })
    return adapter
}