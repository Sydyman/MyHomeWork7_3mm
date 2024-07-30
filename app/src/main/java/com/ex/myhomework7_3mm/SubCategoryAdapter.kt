package com.ex.myhomework7_3mm

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ex.myhomework7_3mm.databinding.ItemSubCategoryBinding

class SubCategoryAdapter(
    private val subCategoryList: List<String>,
    private val clickListener: (String) -> Unit
) : RecyclerView.Adapter<SubCategoryAdapter.SubCategoryViewHolder>() {

    inner class SubCategoryViewHolder(private val binding: ItemSubCategoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(subCategory: String) {
            binding.subCategoryName.text = subCategory
            binding.root.setOnClickListener {
                clickListener(subCategory)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubCategoryViewHolder {
        val binding = ItemSubCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SubCategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SubCategoryViewHolder, position: Int) {
        holder.bind(subCategoryList[position])
    }

    override fun getItemCount() = subCategoryList.size
}
