package com.amlavati.digikraft.ui.two

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.amlavati.digikraft.R
import com.amlavati.digikraft.databinding.FragmentItemDetailBinding
import com.amlavati.digikraft.model.Feature
import com.amlavati.digikraft.util.UNI_TAG
import com.amlavati.digikraft.util.debugLogger
import com.amlavati.digikraft.util.exceptionLogger
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

/**
 * Created by Sudarshan Bhatt on 02-06-2022
 * All rights reserved to https://www.amlavati.com
 */
class BikeStationsDetailFragment : Fragment(), OnMapReadyCallback {

    //TODO : we can use shared view model for fragments.
    // and then instead of passing data in bundle ,
    // only item index will be passed and data will be taken from view model

    private var data: Feature? = null

    private var _binding: FragmentItemDetailBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var mMap: GoogleMap


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            if (it.containsKey(ARG_ITEM_ID)) {
                data = it.getParcelable(ARG_ITEM_ID)
                debugLogger(UNI_TAG, data?.geometry?.type)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentItemDetailBinding.inflate(inflater, container, false)
        val rootView = binding.root
        binding.itemDetailContainer.visibility
        try {
            val mapFragment = childFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
            mapFragment.getMapAsync(this)
        } catch (e: Exception) {
            exceptionLogger(UNI_TAG, "error", e)
        }
        updateContent()

        return rootView
    }

    private fun updateContent() {

    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        data?.let {
            // Add a marker to show location and move the camera
            val marker = LatLng(data!!.geometry.coordinates[0], data!!.geometry.coordinates[1])
            mMap.addMarker(MarkerOptions().position(marker))
            mMap.moveCamera(CameraUpdateFactory.newLatLng(marker))
            with(binding.btm2) {
                data?.apply {
                    tvId.text = id
                    tvLabel.text = properties.label
                    //   tvDistance.text = "600 mtr"
                    tvType.text = type
                    tvAvailableBikes.text = properties.bikes
                    tvAvailablePlaces.text = properties.free_racks
                }
            }
        }

    }

    companion object {
        const val ARG_ITEM_ID = "item_data"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}