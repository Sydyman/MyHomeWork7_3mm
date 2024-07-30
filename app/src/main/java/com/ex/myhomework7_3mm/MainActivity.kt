package com.ex.myhomework7_3mm

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.ex.myhomework7_3mm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val productList = listOf("BMW 5серии m5", "BMW 3серии M3", "BMW  GTR", "MERSEDES-BENZ W124 E500")
        val adapter = ProductAdapter(productList) { product ->

            openSubCategoryFragment(product)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

    private fun openSubCategoryFragment(product: String) {
        val fragment = SubCategoryFragment.newInstance(product)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}
