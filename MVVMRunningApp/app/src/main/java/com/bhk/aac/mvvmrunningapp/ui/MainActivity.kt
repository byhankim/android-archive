package com.bhk.aac.mvvmrunningapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.bhk.aac.mvvmrunningapp.R
import com.bhk.aac.mvvmrunningapp.databinding.ActivityMainBinding
import com.bhk.aac.mvvmrunningapp.db.RunDAO
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint // injection needed @fragments
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)
        }

        with(binding) {
            setSupportActionBar(toolbar)
            val navHostFrag =
                supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
            bottomNavigationView.setupWithNavController(navHostFrag.findNavController())

            // Hide bottomNavView on setup, tracking fragment
            // Always triggered when destination changes w/ Navigation components
            navHostFrag.findNavController().addOnDestinationChangedListener {_, dest, _ ->
                when (dest.id) {
                    R.id.settingsFragment, R.id.runFragment, R.id.statisticsFragment ->
                        bottomNavigationView.visibility = View.VISIBLE
                    else -> bottomNavigationView.visibility = View.GONE
                }
            }
        }

    }
}