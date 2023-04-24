package com.example.datafilteringapplication.fragment.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.datafilteringapplication.R
import com.example.datafilteringapplication.databinding.FragmentHomeBinding
import com.example.datafilteringapplication.databinding.FragmentSplashBinding


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)
        return binding.root

    }


}