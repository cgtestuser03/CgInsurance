package com.capg.insurance.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.capg.insurance.R
import com.capg.insurance.data.model.InsuranceModel
import com.capg.insurance.databinding.FragmentHomeBinding
import com.capg.insurance.databinding.FragmentListBinding
import com.capg.insurance.ui.adapter.GridViewAdapter
import com.capg.insurance.ui.adapter.InsuranceAdapter
import com.capg.insurance.ui.viewmodel.InsuranceViewModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private var viewModel: InsuranceViewModel? = null
    private var adapter: InsuranceAdapter? = null
    private var insuranceCategoryList = ArrayList<InsuranceModel>()
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

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setInsuranceListData()
        val adapter = context?.let { GridViewAdapter(insuranceCategoryList, it, "show_list") }
        val layoutManager = LinearLayoutManager(context)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter
        /*binding.buttonNext.setOnClickListener {
            findNavController().navigate(R.id.action_HomeFragment_to_NewFormFragment)
        }*/
    }

    private fun setInsuranceListData(){
        insuranceCategoryList.add(InsuranceModel(R.drawable.ic_icon_trem_insurance, "Term Life Insurance"))
        insuranceCategoryList.add(InsuranceModel(R.drawable.ic_icon_medical_insurance, "Health Insurance"))
        insuranceCategoryList.add(InsuranceModel(R.drawable.ic_icon_investment, "Investment Plans"))
        insuranceCategoryList.add(InsuranceModel(R.drawable.ic_icon_retrun_preminum, "Return of Premium"))
        insuranceCategoryList.add(InsuranceModel(R.drawable.ic_icon_child, "Child Saving Plans"))
        insuranceCategoryList.add(InsuranceModel(R.drawable.ic_icon_car, "Car Insurance"))
        insuranceCategoryList.add(InsuranceModel(R.drawable.ic_icon_return_guarantee, "Guaranteed Returns"))
        insuranceCategoryList.add(InsuranceModel(R.drawable.ic_icon_tax_saving, "Tax Saving Investment"))
        insuranceCategoryList.add(InsuranceModel(R.drawable.ic_icon_home, " Home  Insurance "))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}