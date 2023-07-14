package com.example.bottomnavigation

import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.bottomnavigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("sundu", "activity oncreate")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView
        Log.e("sundu", "activity binding view over")
        //1.寻找出路由控制器对象，它是路由跳转的唯一入口，找到宿主NavHostFragment
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment
        //2.自定义FragmentNavigator，mobile_navigation.xml文件中的fragment标识改为SumFragmentNavigator的sumFragment
        val fragmentNavigator = SumFragmentNavigator(this, navHostFragment.childFragmentManager, navHostFragment.id)
        //3.注册到Navigator里面，这样才找得到
        navController.navigatorProvider.addNavigator(fragmentNavigator)
        //4.设置Graph，需要将activity_main.xml文件中的app:navGraph="@navigation/mobile_navigation"移除
        navController.setGraph(R.navigation.mobile_navigation)

//       restoreState(navController)

        normal(navController)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        val appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
//            )
//        )
//        setupActionBarWithNavController(navController, appBarConfiguration)
//        navView.setupWithNavController(navController)
    }

    fun normal(navController:NavController){
        binding.root.findViewById<View>(R.id.home).setOnClickListener {
            navController.navigate(R.id.navigation_fragment_a,null)
        }
        binding.root.findViewById<View>(R.id.texta).setOnClickListener {

            navController.navigate(R.id.navigation_fragment_b)
        }
        binding.textb.setOnClickListener {
            navController.navigate(R.id.navigation_fragment_c)
        }
        binding.textc.setOnClickListener {
            navController.navigate(R.id.navigation_fragment_d,null)
        }
    }

    fun singleTop(navController:NavController){
        binding.root.findViewById<View>(R.id.home).setOnClickListener {
            navController.navigate(R.id.navigation_home,null)
        }
        binding.root.findViewById<View>(R.id.texta).setOnClickListener {
            var navOptions = NavOptions.Builder().setRestoreState(true)
                .setLaunchSingleTop(true) .build()
            navController.navigate(R.id.navigation_fragment_a,null,navOptions)
        }
        binding.textb.setOnClickListener {
            navController.navigate(R.id.navigation_fragment_b)
        }
        binding.textc.setOnClickListener {
            navController.navigate(R.id.navigation_fragment_c,null)
        }
        binding.textd.setOnClickListener {


        }
    }

    fun popUpToId(navController:NavController){
        binding.root.findViewById<View>(R.id.home).setOnClickListener {
            navController.navigate(R.id.navigation_home,null)
        }
        binding.root.findViewById<View>(R.id.texta).setOnClickListener {
            navController.navigate(R.id.navigation_fragment_a,null)
        }
        binding.textb.setOnClickListener {
            navController.navigate(R.id.navigation_fragment_b)
        }
        binding.textc.setOnClickListener {
            navController.navigate(R.id.navigation_fragment_c,null)
        }
        binding.textd.setOnClickListener {
            var navOptions = NavOptions.Builder().setRestoreState(true)
                .setPopUpTo(R.id.navigation_fragment_a, inclusive = false, saveState = false).build()
            navController.navigate(R.id.navigation_fragment_a,null,navOptions)

        }
    }

    fun popUpToInclusive(navController:NavController){
        binding.root.findViewById<View>(R.id.home).setOnClickListener {
            navController.navigate(R.id.navigation_home,null)
        }
        binding.root.findViewById<View>(R.id.texta).setOnClickListener {
            navController.navigate(R.id.navigation_fragment_a,null)
        }
        binding.textb.setOnClickListener {
            navController.navigate(R.id.navigation_fragment_b)
        }
        binding.textc.setOnClickListener {
            navController.navigate(R.id.navigation_fragment_c,null)
        }
        binding.textd.setOnClickListener {
            var navOptions = NavOptions.Builder().setRestoreState(true)
                .setPopUpTo(R.id.navigation_fragment_a, inclusive = true, saveState = false).build()
            navController.navigate(R.id.navigation_fragment_a,null,navOptions)

        }
    }

    fun restoreState(navController:NavController){
        binding.root.findViewById<View>(R.id.home).setOnClickListener {
            navController.navigate(R.id.navigation_fragment_a,null)
        }
        binding.root.findViewById<View>(R.id.texta).setOnClickListener {
            navController.navigate(R.id.navigation_fragment_b,null)
        }
        binding.textb.setOnClickListener {
            navController.navigate(R.id.navigation_fragment_c)
        }
        binding.textc.setOnClickListener {
            var navOptions = NavOptions.Builder()
                .setPopUpTo(R.id.navigation_fragment_b, inclusive = true, true)
                .build()
            navController.navigate(R.id.navigation_fragment_d,null,navOptions)
        }
        binding.textd.setOnClickListener {
            var navOptions = NavOptions.Builder()
                .setRestoreState(true)
                .build()
            navController.navigate(R.id.navigation_fragment_b,null,navOptions)

        }
    }

    override fun onStart() {
        super.onStart()
        Log.e("sundu", "activity onStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("sundu", "activity onRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("sundu", "activity onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("sundu", "activity onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("sundu", "activity onstop")
    }
}