package com.deep.app.jetpacknavigation

import android.os.Bundle
import android.view.MenuItem
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.forEachIndexed
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.deep.app.jetpacknavigation.fragment.AnimalDetailFragment
import com.deep.app.jetpacknavigation.fragment.AnimalsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.navigation_dog -> {
                getNavController().navigate(
                    R.id.action_dogs,
                    Bundle().apply {
                        putString(
                            AnimalsFragment.ARG_ANIMAL_FAMILY,
                            AnimalsFragment.ARG_DOGS
                        )
                    })
                return true
            }
            R.id.navigation_cat -> {
                getNavController().navigate(
                    R.id.action_cats,
                    Bundle().apply {
                        putString(
                            AnimalsFragment.ARG_ANIMAL_FAMILY,
                            AnimalsFragment.ARG_CATS
                        )
                    })
                return true
            }
            R.id.navigation_help -> {
                getNavController().navigate(
                    R.id.action_help
                )
                return true
            }
        }
        return false
    }

    private fun getNavController(): NavController {
        return Navigation.findNavController(this, R.id.nav_host_fragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        nav_view.setOnNavigationItemSelectedListener(this)
    }
}

/**
 * @param id the id of the resource to highlight
 * */
private fun BottomNavigationView.setHighlightedItem(@IdRes id: Int) {
    menu.forEachIndexed { index, item ->
        item.isChecked = (item.itemId == id)
    }
}
