package com.ex.myhomework7_3mm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ex.myhomework7_3mm.databinding.FragmentDescriptionBinding

class DescriptionFragment : Fragment() {

    companion object {
        private const val ARG_SUB_CATEGORY = "sub_category"

        fun newInstance(subCategory: String) = DescriptionFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_SUB_CATEGORY, subCategory)
            }
        }
    }

    private var _binding: FragmentDescriptionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDescriptionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val subCategory = arguments?.getString(ARG_SUB_CATEGORY)
        binding.description.text = "Дерзкая как пуля резкая $subCategory"
        binding.imageView.setImageResource(R.drawable.wp1904900)
        binding.imageView.setImageResource(R.drawable.wp1904900)
        binding.imageView.setImageResource(R.drawable.wp1904900)
        binding.imageView.setImageResource(R.drawable.wp1904900)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
