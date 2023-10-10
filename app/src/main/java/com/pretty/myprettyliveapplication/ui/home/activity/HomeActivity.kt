package com.pretty.myprettyliveapplication.ui.home.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.pretty.myprettyliveapplication.R
import com.pretty.myprettyliveapplication.databinding.ActivityHomeBinding
import com.pretty.myprettyliveapplication.ui.home.fragment.ExploreFragment
import com.pretty.myprettyliveapplication.ui.home.fragment.HomeFragment
import com.pretty.myprettyliveapplication.ui.home.fragment.InboxFragment
import com.pretty.myprettyliveapplication.ui.home.fragment.SelectLiveFragment
import com.pretty.myprettyliveapplication.ui.home.fragment.UserFragment

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadFragment(HomeFragment())

        binding.bottomNav.setOnItemSelectedListener {
            return@setOnItemSelectedListener when (it.itemId) {
                R.id.home -> {
                    loadFragment(HomeFragment())
                    true
                }

                R.id.explore -> {
                    loadFragment(ExploreFragment())
                    true
                }

                R.id.live -> {
                    loadFragment(SelectLiveFragment())
                    true
                }

                R.id.message -> {
                    loadFragment(InboxFragment())
                    true
                }

                R.id.user -> {
                    loadFragment(UserFragment())
                    true
                }

                else -> false // Return false for unknown item IDs
            }
        }

    }
    private fun loadFragment(fragment: Fragment) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.commit()

    }
}

