package com.sum.main.navigator

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment

/**
 * 处理Navigation重建问题
 */
class WindowNavHostFragment : NavHostFragment() {
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        val frameLayout = WindowFrameLayout(inflater.context)
//        frameLayout.id = id
//        return frameLayout
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("sundu", "fragment oncreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
        Log.e("sundu", "fragment oncreateview")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("sundu", "fragment onviewcreated")
    }


    override fun onStart() {
        super.onStart()
        Log.e("sundu", "fragment onstart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("sundu", "fragment onresume")
    }
    override fun onPause() {
        super.onPause()
        Log.e("sundu", "fragment onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("sundu", "fragment onstop")
    }

}