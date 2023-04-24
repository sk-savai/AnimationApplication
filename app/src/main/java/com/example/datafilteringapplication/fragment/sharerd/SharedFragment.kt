package com.example.datafilteringapplication.fragment.sharerd

import android.annotation.SuppressLint
import android.os.Bundle
import android.transition.TransitionInflater
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.datafilteringapplication.R
import com.example.datafilteringapplication.databinding.FragmentSharedBinding
import java.nio.file.Files.move


class SharedFragment : Fragment() {
    private lateinit var binding: FragmentSharedBinding

    @SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_shared,container,false)
        val animation=TransitionInflater.from(requireContext()).inflateTransition(
            android.R.transition.move
        )

        sharedElementEnterTransition=animation


        animation.duration=1000
        sharedElementReturnTransition=animation
        return binding.root
    }


}