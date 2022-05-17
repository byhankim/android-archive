package com.bhk.aac.mvvmrunningapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bhk.aac.mvvmrunningapp.R
import com.bhk.aac.mvvmrunningapp.databinding.FragmentRunBinding
import com.bhk.aac.mvvmrunningapp.databinding.FragmentSetupBinding
import com.bhk.aac.mvvmrunningapp.databinding.FragmentStatisticsBinding

class SetupFragment: Fragment() {

    private var _binding: FragmentSetupBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSetupBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with (binding) {
            tvContinue.setOnClickListener {
                findNavController().navigate(R.id.action_setupFragment_to_runFragment)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}