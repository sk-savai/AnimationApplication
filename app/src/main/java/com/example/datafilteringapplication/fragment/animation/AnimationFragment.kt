package com.example.datafilteringapplication.fragment.animation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.example.datafilteringapplication.R
import com.example.datafilteringapplication.databinding.FragmentAnimationBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class AnimationFragment : Fragment() {

    private lateinit var binding:FragmentAnimationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_animation,container,false)


        binding.btnRotateAfter.setOnClickListener {
            val clockSide=AnimationUtils.loadAnimation(requireContext(),R.anim.rotate_clock)
            binding.ivFireBaseImage.startAnimation(clockSide)
        }


        binding.btnRotateBefore.setOnClickListener {
            val clockSide=AnimationUtils.loadAnimation(requireContext(),R.anim.rotate_anty_clock)
            binding.ivFireBaseImage.startAnimation(clockSide)
        }



        binding.btnFadeInAfter.setOnClickListener {
            val fadeInSide=AnimationUtils.loadAnimation(requireContext(),R.anim.fade_in)
            binding.ivFireBaseFadeInOut.startAnimation(fadeInSide)
            binding.ivFireBaseFadeInOut.isVisible=true
        }



        binding.btnFadeOutBefore.setOnClickListener {
            val fadeOutSide=AnimationUtils.loadAnimation(requireContext(),R.anim.fade_out)
            lifecycleScope.launch {
                delay(1000)
                binding.ivFireBaseFadeInOut.isVisible=false
            }
            binding.ivFireBaseFadeInOut.startAnimation(fadeOutSide)
        }



        binding.btnZoomInAfter.setOnClickListener {
            val zoomInSide=AnimationUtils.loadAnimation(requireContext(),R.anim.zoom_in)
            binding.ivFireBaseZoomInOut.startAnimation(zoomInSide)

        }

        binding.btnZoomOutBefore.setOnClickListener {
            val zoomOutSide=AnimationUtils.loadAnimation(requireContext(),R.anim.zoom_out)
            binding.ivFireBaseZoomInOut.startAnimation(zoomOutSide)

        }

        binding.btnSlideAfter.setOnClickListener {
            val slideAfter=AnimationUtils.loadAnimation(requireContext(),R.anim.slide_after)
            val slideTextAfter=AnimationUtils.loadAnimation(requireContext(),R.anim.text_slide_in)
            binding.ivFireBaseSlide.startAnimation(slideAfter)
            binding.tvSlideAfter.startAnimation(slideTextAfter)

        }
        binding.btnSlideBefore.setOnClickListener {
            val slideBefore=AnimationUtils.loadAnimation(requireContext(),R.anim.slide_before)
            val slideTextBefore=AnimationUtils.loadAnimation(requireContext(),R.anim.text_slide_out)
            binding.ivFireBaseSlide.startAnimation(slideBefore)
            binding.tvSlideAfter.startAnimation(slideTextBefore)

        }

        binding.btnBounce.setOnClickListener {
            val bounce=AnimationUtils.loadAnimation(requireContext(),R.anim.bounce)
            binding.tvBounce.startAnimation(bounce)

        }

        binding.cvSharedImage.setOnClickListener {
            val extras= FragmentNavigatorExtras(
                binding.ivFirebaseDetails to "image_big" ,
                binding.tvName to "user_name" ,
                binding.tvDescription to "user_description"
            )
            findNavController().navigate(R.id.action_menuAnimationFragment_to_sharedFragment,null,null,extras)
        }


        return binding.root

    }


}