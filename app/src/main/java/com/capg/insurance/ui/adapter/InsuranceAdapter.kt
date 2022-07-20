package com.capg.insurance.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.capg.insurance.R

class InsuranceAdapter : RecyclerView.Adapter<InsuranceAdapter.InsuranceHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): InsuranceHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.insurance_item, parent, false)
        return InsuranceHolder(itemView)
    }


    class InsuranceHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        init {

        }
    }

    override fun onBindViewHolder(holder: InsuranceHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}