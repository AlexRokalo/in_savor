package com.roof.pagination_android.databinding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.roof.pagination.Entity
import com.roof.pagination_android.decoration.StickyHeaderInterface


interface StickyEntity : Entity {
    val partType: PartType
}

enum class PartType {
    HEADER,
    BODY
}

class PaginationStickyHeaderListAdapter<T : StickyEntity>(
    itemCallback: DiffUtil.ItemCallback<T>,
    @LayoutRes val bodyLayoutResId: Int,
    @LayoutRes val headerLayoutResId: Int,
    val bindBody: (item: T, itemView: View, position: Int) -> Unit,
    val bindHeader: (item: T, itemView: View, position: Int) -> Unit
) : PagedListAdapter<T, RecyclerView.ViewHolder>(itemCallback), StickyHeaderInterface {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (PartType.values()[viewType]) {
            PartType.HEADER -> {
                val inflater = LayoutInflater.from(parent.context)
                val view = inflater.inflate(headerLayoutResId, parent, false)
                object : RecyclerView.ViewHolder(view) {}
            }
            PartType.BODY -> {
                val inflater = LayoutInflater.from(parent.context)
                val view = inflater.inflate(bodyLayoutResId, parent, false)
                object : RecyclerView.ViewHolder(view) {}
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        when (PartType.values()[getItemViewType(position)]) {
            PartType.HEADER -> {
                item?.let { bindHeader(it, holder.itemView, position) }
            }
            PartType.BODY -> {
                item?.let { bindBody(it, holder.itemView, position) }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position)?.partType?.ordinal ?: 1
    }

    override fun getHeaderPositionForItem(itemPosition: Int): Int {
        var headerPosition = 0
        var currentPosition = itemPosition
        do {
            if (isHeader(currentPosition)) {
                headerPosition = currentPosition
                break
            }
            currentPosition -= 1
        } while (currentPosition >= 0)
        return headerPosition
    }

    override fun getHeaderLayout(headerPosition: Int): Int {
        return headerLayoutResId
    }

    override fun bindHeaderData(header: View, headerPosition: Int) {
        getItem(headerPosition)?.let { bindHeader(it, header, headerPosition) }
    }

    override fun isHeader(itemPosition: Int): Boolean {
        return if (itemPosition == -1) {
            false
        } else {
            getItem(itemPosition)?.partType == PartType.HEADER
        }
    }
}


class StickyHeaderListAdapter<T : StickyEntity>(
    itemCallback: DiffUtil.ItemCallback<T>,
    @LayoutRes val bodyLayoutResId: Int,
    @LayoutRes val headerLayoutResId: Int,
    val bindBody: (item: T, itemView: View, position: Int) -> Unit,
    val bindHeader: (item: T, itemView: View, position: Int) -> Unit
) : ListAdapter<T, RecyclerView.ViewHolder>(itemCallback), StickyHeaderInterface {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (PartType.values()[viewType]) {
            PartType.HEADER -> {
                val inflater = LayoutInflater.from(parent.context)
                val view = inflater.inflate(headerLayoutResId, parent, false)
                object : RecyclerView.ViewHolder(view) {}
            }
            PartType.BODY -> {
                val inflater = LayoutInflater.from(parent.context)
                val view = inflater.inflate(bodyLayoutResId, parent, false)
                object : RecyclerView.ViewHolder(view) {}
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        when (PartType.values()[getItemViewType(position)]) {
            PartType.HEADER -> {
                item?.let { bindHeader(it, holder.itemView, position) }
            }
            PartType.BODY -> {
                item?.let { bindBody(it, holder.itemView, position) }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position)?.partType?.ordinal ?: 1
    }

    override fun getHeaderPositionForItem(itemPosition: Int): Int {
        var headerPosition = 0
        var currentPosition = itemPosition
        do {
            if (isHeader(currentPosition)) {
                headerPosition = currentPosition
                break
            }
            currentPosition -= 1
        } while (currentPosition >= 0)
        return headerPosition
    }

    override fun getHeaderLayout(headerPosition: Int): Int {
        return headerLayoutResId
    }

    override fun bindHeaderData(header: View, headerPosition: Int) {
        getItem(headerPosition)?.let { bindHeader(it, header, headerPosition) }
    }

    override fun isHeader(itemPosition: Int): Boolean {
        return if (itemPosition == -1) {
            false
        } else {
            getItem(itemPosition)?.partType == PartType.HEADER
        }
    }
}