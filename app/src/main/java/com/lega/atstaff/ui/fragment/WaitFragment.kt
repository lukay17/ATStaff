package com.lega.atstaff.ui.fragment

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.lega.atstaff.ATStaffApp.Companion.prefs
import com.lega.atstaff.R
import com.lega.atstaff.core.base.BaseFragmentDb
import com.lega.atstaff.databinding.FragmentWaitBinding
import com.lega.atstaff.domain.models.Personal
import com.lega.atstaff.domain.models.User
import com.lega.atstaff.ui.vm.WaitViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WaitFragment : BaseFragmentDb<FragmentWaitBinding, WaitViewModel>() {

    override fun getLayout(): Int = R.layout.fragment_wait
    override val viewModel: WaitViewModel by viewModels()

    override fun eventListeners() {
        dataBinding.btnSign.setOnClickListener {
            val directions = WaitFragmentDirections.toLoginFragment()
            Navigation.findNavController(it).navigate(directions)
        }

        dataBinding.btnRegister.setOnClickListener {
            val directions = WaitFragmentDirections.toRegisterFragment()
            Navigation.findNavController(it).navigate(directions)
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                val builder = AlertDialog.Builder(requireContext())
                builder.setMessage("Are you sure close application?")
                    .setPositiveButton("Yes", DialogInterface.OnClickListener {
                            dialog, which ->
                        val intent = Intent(Intent.ACTION_MAIN)
                        intent.addCategory(Intent.CATEGORY_HOME)
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        startActivity(intent)
                    })
                    .setNegativeButton("No", DialogInterface.OnClickListener{
                            dialog, which ->
                        dialog.dismiss()
                    })
                builder.show()
            }
        })
    }

    override fun observeViewModels() {
        viewModel.user.observe(viewLifecycleOwner, ::accessSucess)
    }

    override fun initViewModels() {
        super.initViewModels()
        if(prefs.getId() > 0){
            viewModel.initUser(prefs.getId())
        }
    }

    private fun accessSucess(user: User?) {
        val directions = WaitFragmentDirections.toHomeActivity(user)
        navigate(directions)
    }
}