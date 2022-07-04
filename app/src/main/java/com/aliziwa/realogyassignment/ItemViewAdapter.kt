package com.aliziwa.realogyassignment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.aliziwa.domain.entity.QueryData
import com.aliziwa.realogyassignment.databinding.ItemListContentBinding

class ItemViewAdapter(
    private val values: List<QueryData>,
    private val itemDetailFragmentContainer: View?
) :
    RecyclerView.Adapter<ItemViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding =
            ItemListContentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.titleView.text = item.characterName
        holder.contentView.text = item.description

        with(holder.itemView) {
            tag = item
            setOnClickListener { itemView ->
                val bundle = Bundle()
                bundle.putSerializable(
                    ItemDetailFragment.QUERY_DATA,
                    item
                )
                if (itemDetailFragmentContainer != null) {
                    itemDetailFragmentContainer.findNavController()
                        .navigate(R.id.fragment_item_detail, bundle)
                } else {
                    itemView.findNavController().navigate(R.id.show_item_detail, bundle)
                }
            }
        }
    }

    override fun getItemCount() = values.size

    inner class ViewHolder(binding: ItemListContentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val titleView: TextView = binding.titleView
        val contentView: TextView = binding.content
    }

}
