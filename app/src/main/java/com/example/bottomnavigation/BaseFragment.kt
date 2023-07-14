package com.example.bottomnavigation

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
open class BaseFragment : Fragment() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val name = object{}.javaClass.enclosingMethod.name
        log(name)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val name = object{}.javaClass.enclosingMethod.name
        log(name)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val name = object{}.javaClass.enclosingMethod.name
        log(name)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val name = object{}.javaClass.enclosingMethod.name
        log(name)
    }

    override fun onStart() {
        super.onStart()
        val name = object{}.javaClass.enclosingMethod.name
        log(name)
    }


    override fun onResume() {
        super.onResume()
        val name = object{}.javaClass.enclosingMethod.name
        log(name)
    }

    override fun onPause() {
        super.onPause()
        val name = object{}.javaClass.enclosingMethod.name
        log(name)
    }
    override fun onStop() {
        super.onStop()
        val name = object{}.javaClass.enclosingMethod.name
        log(name)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        val name = object{}.javaClass.enclosingMethod.name
        log(name)
    }

    override fun onDestroy() {
        super.onDestroy()
        val name = object{}.javaClass.enclosingMethod.name
        log(name)
    }

    override fun onDetach() {
        super.onDetach()
        val name = object{}.javaClass.enclosingMethod.name
        log(name)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val name = object{}.javaClass.enclosingMethod.name
        log(name)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        val name = object{}.javaClass.enclosingMethod.name
        log(name)
    }

    fun log(scroup:String){
        Log.e("sundu","${this::class.java.name} --> $scroup")
    }
}