package com.lega.atstaff.ui.fragment

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.google.android.material.tabs.TabLayoutMediator
import com.lega.atstaff.ATStaffApp.Companion.prefs
import com.lega.atstaff.R
import com.lega.atstaff.R.layout
import com.lega.atstaff.core.base.BaseFragmentDb
import com.lega.atstaff.core.base.ViewPageAdapter
import com.lega.atstaff.core.extension.loadImage
import com.lega.atstaff.databinding.FragmentDetailBinding
import com.lega.atstaff.domain.models.Personal
import com.lega.atstaff.ui.util.CustomToast
import com.lega.atstaff.ui.vm.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment: BaseFragmentDb<FragmentDetailBinding, DetailViewModel>() {

    override fun getLayout(): Int = layout.fragment_detail
    override val viewModel: DetailViewModel by viewModels()
    val TAG:String = "DetailFragement"
    val args: DetailFragmentArgs by navArgs()

    val list:List<String> = listOf(
        "Title",
        "Course",
        "License",
        "Visa"
    )

    override fun eventListeners() {
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                val directions = DetailFragmentDirections.toHomeFragment()
                navigate(directions) }
        })

        dataBinding.theEnd.setOnClickListener {
            val builder = AlertDialog.Builder(requireContext())
            builder.setMessage("Are you sure close application?")
                .setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, which ->
                    prefs.wipeUser()
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

        dataBinding.profile.setOnClickListener {
            val directions = DetailFragmentDirections.toUpdateFragment(args.personal)
            navigate(directions)
        }
    }

    override fun initViewModels() {
        with(dataBinding) {
            val drawable = resources.getDrawable(R.drawable.avatar)
            personalImg.loadImage(args.personal.img, drawable)
            personalName.setText(args.personal.name.toString())
            personalOrganization.setText(args.personal.organization.toString())
            personalNationality.setText(args.personal.nationality.toString())
            personalPosition.setText(args.personal.position.toString())
        }

        dataBinding.viewpager.adapter = ViewPageAdapter(this, list, args.personal.id)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        TabLayoutMediator(dataBinding.tabLayout, dataBinding.viewpager){tab,  position->
            tab.text = list[position]
        }.attach()
    }
}

