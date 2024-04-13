package com.example.app20

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.app20.databinding.ActivityMainBinding

// App20: Bottom Navigation Bar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        replaceFragmente(HomeFragment())

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.item_Home -> replaceFragmente(HomeFragment())
                R.id.item_Search -> replaceFragmente(SearchFragment())
                R.id.item_Person -> replaceFragmente(AccountFragment())
                R.id.item_Logout -> finish()
                else -> {
                    replaceFragmente(HomeFragment())
                }
            }
            true
        }
    }

    private fun replaceFragmente(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_Layout, fragment)
        fragmentTransaction.commit()
    }
}