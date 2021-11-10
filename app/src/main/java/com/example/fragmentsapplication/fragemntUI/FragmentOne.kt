package com.example.fragmentsapplication.fragemntUI

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import com.example.fragmentsapplication.R
import kotlinx.android.synthetic.main.fragment_one.*
import java.lang.Exception

class FragmentOne : Fragment() {
    val TAG = "Fragment Life cycle"
    private lateinit var textView:TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i(TAG, "onCreateView called")
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_one, container, false)

        try {
            val bundle = arguments
            val message = bundle!!.getString("key")
            textView = view.findViewById<View>(R.id.tvData) as TextView
            textView.text = message
        }catch (e: Exception){
            e.stackTrace

        }


        return view;
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i(TAG, "onAttach called")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "onCreate called")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.i(TAG, "onActivityCreated called")
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume called")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause called")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop called")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i(TAG, "onDestroyView called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy called")

    }

    override fun onDetach() {
        super.onDetach()
        Log.i(TAG, "onDetach called")

    }

}