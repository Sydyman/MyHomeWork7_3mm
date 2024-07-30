package com.ex.myhomework7_3mm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ex.myhomework7_3mm.databinding.FragmentSubCategoryBinding

class SubCategoryFragment : Fragment() {

    companion object {
        private const val ARG_PRODUCT = "product"

        fun newInstance(product: String) = SubCategoryFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_PRODUCT, product)
            }
        }
    }

    private var _binding: FragmentSubCategoryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSubCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val product = arguments?.getString(ARG_PRODUCT)

        val subCategoryList = getSubCategoriesForProduct(product)
        val adapter = SubCategoryAdapter(subCategoryList) { subCategory ->

            openDescriptionFragment(subCategory)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter
    }

    private fun getSubCategoriesForProduct(product: String?): List<String> {
        return listOf("bmw e34", "bmw e30", "bmw e46 m3 gtr", "просто легенда")
    }

    private fun openDescriptionFragment(subCategory: String) {
        val fragment = DescriptionFragment.newInstance(subCategory)
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
