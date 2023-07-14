package com.example.bottomnavigation

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.OnBackPressedCallback
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.bottomnavigation.databinding.ActivityMain2Binding
import com.example.bottomnavigation.databinding.ActivityMainBinding
import com.example.bottomnavigation.ui.a.HomeA
import com.example.bottomnavigation.ui.a.HomeB
import com.example.bottomnavigation.ui.a.HomeC
import com.example.bottomnavigation.ui.a.HomeD

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("sundu", "activity oncreate")
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.add1.setOnClickListener {
            supportFragmentManager.saveBackStack("sundu")
            supportFragmentManager.commit {
                var fragment = HomeA()
                setReorderingAllowed(true)
                replace(R.id.fragment_container,fragment)
            }
        }

        binding.add2.setOnClickListener {
            supportFragmentManager.saveBackStack("sundu")
            supportFragmentManager.commit {
                var fragment = HomeB()
                setReorderingAllowed(true)
                replace(R.id.fragment_container,fragment)
            }
        }
        binding.add3.setOnClickListener {
            supportFragmentManager.commit {
                var fragment = HomeC()
                setReorderingAllowed(true)
                replace(R.id.fragment_container,fragment)
                addToBackStack("sundu2")
            }
        }

        binding.add4.setOnClickListener {
            supportFragmentManager.commit {
                var fragment = HomeD()
                setReorderingAllowed(true)
                replace(R.id.fragment_container,fragment)
                addToBackStack("sundu2")
            }
        }


        binding.savestark1.setOnClickListener {
            supportFragmentManager.saveBackStack("sundu")
        }

        binding.savestark2.setOnClickListener {
            supportFragmentManager.saveBackStack("sundu2")
        }

        binding.stark1.setOnClickListener {
            supportFragmentManager.saveBackStack("sundu2")
            supportFragmentManager.restoreBackStack("sundu")
        }

        binding.stark2.setOnClickListener {
            supportFragmentManager.saveBackStack("sundu")
            supportFragmentManager.restoreBackStack("sundu2")
        }

        onBackPressedDispatcher.addCallback(this,object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                supportFragmentManager.popBackStack()
                binding.add1.post {
                    isEnabled = supportFragmentManager.backStackEntryCount>=1
                }
                Log.e("sundu", "activity back pressed")
            }
        })
    }
}