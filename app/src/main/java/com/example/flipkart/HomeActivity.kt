package com.example.flipkart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.transition.Visibility
import com.example.flipkart.Fragments.AccountFragment
import com.example.flipkart.Fragments.CartFragment
import com.example.flipkart.Fragments.GroceryFragment
import com.example.flipkart.Fragments.HomeFragment
import com.example.flipkart.Fragments.NotificationFragment
import com.example.flipkart.Fragments.categoriesFragment
import com.example.flipkart.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(HomeFragment())



        binding.groceryBtn.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, GroceryFragment())
                .commit()
        }

        binding.flipkartHomeBtn.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment())
                .commit()
        }

        binding.BottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> replaceFragment(HomeFragment())
                R.id.categories -> replaceFragment(categoriesFragment())
                R.id.notifications -> replaceFragment(NotificationFragment())
                R.id.account -> replaceFragment(AccountFragment())
                R.id.cart->replaceFragment(CartFragment())
                else->{

                }
            }
            true
        }


    }
    private fun replaceFragment(fragment: Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container,fragment)
        fragmentTransaction.commit()
    }

}