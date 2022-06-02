package com.amlavati.digikraft.ui.two

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.amlavati.digikraft.R
import com.amlavati.digikraft.databinding.FragmentItemListBinding
import com.amlavati.digikraft.model.Feature
import com.amlavati.digikraft.networking.RetrofitService
import com.amlavati.digikraft.repository.DataSourceRepository
import com.amlavati.digikraft.viewmodel.BikeStationsViewModel
import com.amlavati.digikraft.viewmodel.BikeStationsViewModelFactory

/**
 * Created by Sudarshan Bhatt on 02-06-2022
 * All rights reserved to https://www.amlavati.com
 */

class BikeStationsListFragment : Fragment(), CellClickListener {

    private var _binding: FragmentItemListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var viewModel: BikeStationsViewModel
    private val adapter = BikeStationsAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentItemListBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.recyclerBikeStations.adapter = adapter
        val retrofitService = RetrofitService.retrofitService
        val repository = DataSourceRepository(retrofitService)

        viewModel = ViewModelProvider(
            this,
            BikeStationsViewModelFactory(repository)
        )[BikeStationsViewModel::class.java]

        observerViewModel()

        return view
    }

    private fun observerViewModel() {


        viewModel.getBikeStationList("pub_transport", "stacje_rowerowe")

        viewModel.bikeStations.observe(viewLifecycleOwner) {
            adapter.updateData(it)
        }


        viewModel.errorMessage.observe(viewLifecycleOwner) {
            Toast.makeText(activity, it, Toast.LENGTH_SHORT).show()

        }

        viewModel.loading.observe(viewLifecycleOwner) {
            if (it) {
                binding.progressDialog.visibility = View.VISIBLE
            } else {
                binding.progressDialog.visibility = View.GONE
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCellClickListener(data: Feature) {
        val bundle = Bundle()
        bundle.putParcelable(BikeStationsDetailFragment.ARG_ITEM_ID, data)
        findNavController().navigate(R.id.show_item_detail, bundle)
    }
}