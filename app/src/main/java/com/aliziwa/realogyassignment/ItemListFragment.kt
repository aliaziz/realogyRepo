package com.aliziwa.realogyassignment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.aliziwa.domain.entity.QueryData
import com.aliziwa.realogyassignment.databinding.FragmentItemListBinding
import com.aliziwa.realogyassignment.viewmodel.ItemListViewModel
import com.aliziwa.realogyassignment.viewmodel.UIState
import com.aliziwa.realogyassignment.viewmodel.ViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import java.lang.IllegalStateException
import javax.inject.Inject

@AndroidEntryPoint
class ItemListFragment : Fragment() {
    private var _binding: FragmentItemListBinding? = null

    private val binding get() = _binding!!
    private val currentState = "current_state"

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var itemListViewModel: ItemListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        itemListViewModel =
            ViewModelProvider(this, viewModelFactory).get(ItemListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentItemListBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = binding.itemList
        val itemDetailFragmentContainer: View? = view.findViewById(R.id.item_detail_nav_container)

        if (savedInstanceState != null) {
            savedInstanceState.getString(currentState)?.let {  restoredState ->
                updateUIWithState(
                    itemListViewModel.fromStringToState(restoredState),
                    recyclerView,
                    itemDetailFragmentContainer
                )
            }
        } else {
            itemListViewModel.fetchQuery()
        }
        itemListViewModel.data.observe(viewLifecycleOwner) { state ->
            updateUIWithState(state, recyclerView, itemDetailFragmentContainer)
        }
    }

    private fun updateUIWithState(
        state: UIState?,
        recyclerView: RecyclerView,
        itemDetailFragmentContainer: View?
    ) {
        when (state) {
            is UIState.Success -> setupRecyclerView(
                state.data,
                recyclerView,
                itemDetailFragmentContainer
            )
            is UIState.Error -> {
                val errorMessage = if(BuildConfig.DEBUG) state.message
                 else resources.getString(R.string.something_went_wrong)

                Toast.makeText(
                    requireContext(),
                    errorMessage,
                    Toast.LENGTH_SHORT
                ).show()
            }
            UIState.Loading -> Toast.makeText(
                requireContext(),
                "Loading...",
                Toast.LENGTH_SHORT
            ).show()
            else -> throw IllegalStateException("Should not reach here")
        }
    }

    private fun setupRecyclerView(
        queryData: List<QueryData>,
        recyclerView: RecyclerView,
        itemDetailFragmentContainer: View?
    ) {

        recyclerView.adapter = ItemViewAdapter(
            queryData, itemDetailFragmentContainer
        )
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(currentState, itemListViewModel.stateToString())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
