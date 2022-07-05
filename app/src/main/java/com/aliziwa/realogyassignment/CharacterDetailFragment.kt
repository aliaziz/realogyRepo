package com.aliziwa.realogyassignment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import com.aliziwa.domain.entity.QueryData
import com.aliziwa.realogyassignment.databinding.FragmentItemDetailBinding
import com.bumptech.glide.Glide
import com.google.android.material.appbar.CollapsingToolbarLayout

class CharacterDetailFragment : Fragment() {

    private var queryDataItem: QueryData? = null

    lateinit var itemDetailTextView: TextView
    private var characterImageView: ImageView? = null
    private var toolbarLayout: CollapsingToolbarLayout? = null

    private var _binding: FragmentItemDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            if (it.containsKey(QUERY_DATA)) {
                queryDataItem = it.getSerializable(QUERY_DATA) as QueryData
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentItemDetailBinding.inflate(inflater, container, false)
        val rootView = binding.root

        itemDetailTextView = binding.itemDetail
        characterImageView = binding.characterImage

        updateContent()

        return rootView
    }

    private fun updateContent() {
        toolbarLayout?.title = queryDataItem?.characterName

        queryDataItem?.let { queryDataItem ->
            itemDetailTextView.text = queryDataItem.description

            characterImageView?.let { imageView ->
                Glide.with(this)
                    .load(queryDataItem.iconUrl)
                    .placeholder(
                        ResourcesCompat.getDrawable(
                            resources,
                            R.drawable.placeholder_image,
                            null
                        )
                    )
                    .into(imageView)
            }
        }
    }

    companion object {
        const val QUERY_DATA = "query_data"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
