package com.lega.atstaff.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.navArgs
import com.lega.atstaff.R
import com.lega.atstaff.core.extension.viewBinding
import com.lega.atstaff.databinding.ActivityHomeBinding
import com.lega.atstaff.ui.util.CustomSnackBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity  : AppCompatActivity() {

    private lateinit var drawer: DrawerLayout

    private val binding by viewBinding(ActivityHomeBinding::inflate)
    private val TAG: String = "MainActivity"
    val args: HomeActivityArgs by navArgs()
    var snackBar: CustomSnackBar = CustomSnackBar()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding?.root)

        init()
        toolbar()

        if (args?.user != null) {
            //snackBar.Image(binding.navView, "Welcome " + args?.user!!.id_personal, 2)
            snackBar.Image(binding.navView, "Welcome ", 2)
        }
    }

    fun toolbar(){
        val toolbar: Toolbar = findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)
        var ab: ActionBar? = supportActionBar
        if(ab != null){
            ab.setHomeAsUpIndicator(R.drawable.ic_menu)
            ab.setDisplayHomeAsUpEnabled(true)
        }
    }

    fun init(){
        binding.navView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> snackBar.Image(binding.navView, "home", 1)
                R.id.nav_profile -> snackBar.Image(binding.navView, "Profile", 2)
                R.id.nav_logOut -> snackBar.Image(binding.navView, "salir", 2)
            }
            false
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home ->{
                drawer = findViewById(R.id.drawer_layout)
                drawer.openDrawer(GravityCompat.START)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}


