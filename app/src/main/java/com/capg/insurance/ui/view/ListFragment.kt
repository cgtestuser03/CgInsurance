package com.capg.insurance.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.capg.insurance.R
import com.capg.insurance.databinding.FragmentListBinding
import com.capg.insurance.ui.adapter.InsuranceAdapter
import com.capg.insurance.ui.viewmodel.InsuranceViewModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private var viewModel: InsuranceViewModel? = null
    private var adapter: InsuranceAdapter? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = InsuranceAdapter()
        viewModel = ViewModelProviders.of(this)[InsuranceViewModel::class.java]
        viewModel!!.init()
//        viewModel!!.getVolumesResponseLiveData().observe(this,
//            Observer<Any?> { volumesResponse ->
//                if (volumesResponse != null) {
//                    adapter.setResults(volumesResponse.getItems())
//                }
//            })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonNext.setOnClickListener {
            findNavController().navigate(R.id.action_ListFragment_to_NewFormFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}