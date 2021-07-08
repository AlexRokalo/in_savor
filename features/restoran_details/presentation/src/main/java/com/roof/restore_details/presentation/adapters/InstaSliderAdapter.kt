package com.roof.restore_details.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.roof.core.ui_kit.ext.load
import com.roof.restore_details.presentation.R
import com.roof.restore_details.presentation.databinding.ItemImageSliderBinding
import com.smarteist.autoimageslider.SliderViewAdapter


class InstaSliderAdapter : SliderViewAdapter<InstaSliderAdapter.SliderAdapterVH>() {

    private val items = mutableListOf<String>()

    override fun getCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup): SliderAdapterVH {
        val inflate = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_image_slider, null)
        return SliderAdapterVH(inflate)
    }

    fun updateList(items: List<String>) {
        this.items.clear()
        this.items.addAll(items)

        notifyDataSetChanged()
    }

    fun deleteItem(position: Int) {
        items.removeAt(position)
        notifyDataSetChanged()
    }

    fun addItem(item: String) {
        items.add(item)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(viewHolder: SliderAdapterVH, position: Int) {
        viewHolder.onBind(items[position])
    }

    class SliderAdapterVH(private val view: View) : SliderViewAdapter.ViewHolder(view) {

        private lateinit var sliderBinding: ItemImageSliderBinding

        fun onBind(item: String) {
            sliderBinding = ItemImageSliderBinding.bind(view)
            sliderBinding.sliderImage.load(item)
        }

    }
}