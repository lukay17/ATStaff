package com.lega.atstaff.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.lega.atstaff.ATStaffApp.Companion.prefs
import com.lega.atstaff.R
import com.lega.atstaff.core.base.BaseFragmentDb
import com.lega.atstaff.databinding.FragmentLoginBinding
import com.lega.atstaff.domain.models.User
import com.lega.atstaff.ui.activity.HomeActivity
import com.lega.atstaff.ui.util.CustomToast
import com.lega.atstaff.ui.vm.LoginViewModel
import com.lega.atstaff.ui.util.CustomSnackBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragmentDb<FragmentLoginBinding, LoginViewModel>() {

    override fun getLayout(): Int = R.layout.fragment_login
    override val viewModel: LoginViewModel by viewModels()
    var snackBar: CustomSnackBar = CustomSnackBar()

    override fun eventListeners() {
        dataBinding.backPage.setOnClickListener {
            val directions = LoginFragmentDirections.toWaitFragment()
            Navigation.findNavController(it).navigate(directions)
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() { }
        })
    }

    override fun setBindingLayout() {
        super.setBindingLayout()
        dataBinding.viewModel = viewModel
    }

    override fun observeViewModels() {
        viewModel.user.observe(viewLifecycleOwner, ::loginSucess)
    }

    override fun initViewModels() {
        super.initViewModels()
    }
    override fun showError(message: String?) {
        snackBar.Image(requireView(), message.toString(), 2)
    }

    private fun loginSucess(user: User?) {
        if (user?.user != null && user?.user.trim().isEmpty()) {
            CustomToast.Danger(requireContext(),
                "Incorrect Username and / or Password, Please Verify and Try Again",
                1).show()
        } else {
            user?.id_personal?.let { prefs.saveId(it) }
            prefs.saveName(user?.user.toString())
            prefs.saveVIP(true)
            val directions = LoginFragmentDirections.toHomeActivity(user)
            navigate(directions)
        }
    }

    /*override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() { }
        })
    }*/

}