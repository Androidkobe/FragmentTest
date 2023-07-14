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
import com.example.bottomnavigation.BaseFragment
import com.example.bottomnavigation.R
import com.example.bottomnavigation.databinding.FragmentABinding

class HomeA : BaseFragment() {

    private var _binding: FragmentABinding? = null

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
        Log.e("sundu", "save = onCreateView")
        val homeViewModel =
            ViewModelProvider(this).get(AViewModel::class.java)

        _binding = FragmentABinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            Log.e("sundu","text change $it")
            textView.text = this@HomeA.toString() + "\n" +it
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
            val navController = NavHostFragment.findNavController(this@HomeA)
            navController.navigate(R.id.navigation_fragment_b)
        }
        return root
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        var saveString = savedInstanceState?.getString("key")
        val homeViewModel =
            ViewModelProvider(this).get(AViewModel::class.java)
        (homeViewModel.text as MutableLiveData).postValue(saveString)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("key","\nA")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}