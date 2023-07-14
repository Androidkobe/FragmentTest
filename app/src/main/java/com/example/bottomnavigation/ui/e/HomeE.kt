package com.example.bottomnavigation.ui.a

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import androidx.navigation.fragment.NavHostFragment
import com.example.bottomnavigation.R
import com.example.bottomnavigation.databinding.FragmentEBinding

class HomeE : Fragment() {

    private var _binding: FragmentEBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private var t = false

    private var clickT = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(BViewModel::class.java)

        _binding = FragmentEBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = this@HomeE.toString()
        }
        if (!t) {
            lifecycle.addObserver(object : LifecycleEventObserver {
                override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
                    Log.e("sundu", source.toString() + " ${event.toString()}")
                }

            })
            t = true
        }


        root.setOnClickListener {
            if (!clickT){
                return@setOnClickListener
            }
        // 获取NavController
        val navController = NavHostFragment.findNavController(this@HomeE)
        navController.navigate(R.id.navigation_notifications)
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}