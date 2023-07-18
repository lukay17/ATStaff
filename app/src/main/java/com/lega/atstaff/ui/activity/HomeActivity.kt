package com.lega.atstaff.ui.activity

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.navArgs
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.lega.atstaff.ATStaffApp
import com.lega.atstaff.R
import com.lega.atstaff.core.extension.loadImg
import com.lega.atstaff.databinding.ActivityHomeBinding
import com.lega.atstaff.ui.fragment.HomeFragmentDirections
import com.lega.atstaff.ui.fragment.LoginFragmentDirections
import com.lega.atstaff.ui.util.CustomSnackBar
import dagger.hilt.android.AndroidEntryPoint
import de.hdodenhof.circleimageview.CircleImageView

@AndroidEntryPoint
class HomeActivity  : AppCompatActivity() {

    private lateinit var drawer: DrawerLayout

    private lateinit var binding: ActivityHomeBinding

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController

    private val TAG: String = "MainActivity"
    val args: HomeActivityArgs by navArgs()
    var snackBar: CustomSnackBar = CustomSnackBar()

    val directions = HomeFragmentDirections

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        if (args?.user != null) {
            snackBar.Image(binding.navView, "Welcome ", 2)
        }

        val navView = findViewById<NavigationView>(R.id.nav_view);

        val header: View = navView.getHeaderView(0)
        val name: TextView = header.findViewById(R.id.name_navHeader)
        name.text = args.user?.user
        val email: TextView = header.findViewById(R.id.email_navHeader)
        email.text = args.user?.email
        val imageView: CircleImageView = header.findViewById(R.id.img_navHeader)
        imageView.loadImg(args.user?.img)

        navController = findNavController(R.id.nav_host_fragment)

        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.homeFragment),
            binding.drawerLayout
        )

        setupClickListener()

        var ab: ActionBar? = supportActionBar
        if(ab != null){
            ab.setHomeAsUpIndicator(R.drawable.ic_menu)
            ab.setDisplayHomeAsUpEnabled(true)
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

    private fun setupClickListener() {
        binding.navView.setNavigationItemSelectedListener { menuItem -> // Toggle the checked state of menuItem.
            menuItem.isChecked = !menuItem.isChecked
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    navController.navigate(R.id.to_homeFragment)
                }
                R.id.nav_profile -> {
                    navController.navigate(R.id.to_updateFragment)
                }
                R.id.nav_logOut ->{
                    val builder = AlertDialog.Builder(this)
                    builder.setMessage("Are you sure close application?")
                        .setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, which ->
                            ATStaffApp.prefs.wipeUser()
                            System.exit(0)
                            val intent = Intent(Intent.ACTION_MAIN)
                            intent.addCategory(Intent.CATEGORY_HOME)
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                            startActivity(intent)
                            //activity?.finish()
                        })
                        .setNegativeButton("No", DialogInterface.OnClickListener { dialog, which ->
                            dialog.dismiss()
                        })
                    builder.show()
                }
            }
            //snackBar.Image(binding.navView, menuItem.title.toString() + " Selected", 3)
            closeDrawer()
            true
        }
    }

    private fun closeDrawer() {
        binding.drawerLayout.closeDrawer(GravityCompat.START)
    }
}

