package com.lega.atstaff.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.lega.atstaff.R
import com.lega.atstaff.core.base.BaseFragmentDb
import com.lega.atstaff.core.extension.isEmail
import com.lega.atstaff.databinding.FragmentRegisterBinding
import com.lega.atstaff.domain.models.User
import com.lega.atstaff.ui.util.CustomSnackBar
import com.lega.atstaff.ui.util.CustomToast
import com.lega.atstaff.ui.vm.RegisterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : BaseFragmentDb<FragmentRegisterBinding, RegisterViewModel>() {

    override fun getLayout(): Int = R.layout.fragment_register
    override val viewModel: RegisterViewModel by viewModels()
    var snackBar: CustomSnackBar = CustomSnackBar()

    override fun eventListeners() {
        dataBinding.signIn.setOnClickListener {
            val directions = RegisterFragmentDirections.toLoginFragment()
            Navigation.findNavController(it).navigate(directions)
        }

        dataBinding.backPage.setOnClickListener {
            val directions = RegisterFragmentDirections.toWaitFragment()
            Navigation.findNavController(it).navigate(directions)
        }
    }

    override fun setBindingLayout() {
        super.setBindingLayout()
        dataBinding.viewModel = viewModel
    }

    override fun observeViewModels() {
        viewModel.user.observe(viewLifecycleOwner, ::registerSuccess)
        viewModel.nulo.observe(viewLifecycleOwner, ::showError)
    }

    override fun showError(message: String?) {
        snackBar.Image(requireView(), message.toString(), 4)
    }

    private fun registerSuccess(success: String?) {
        if (success?.toString() == "success") {
            val directions = RegisterFragmentDirections.toLoginFragment()
            navigate(directions)
        }else {
            CustomToast.Danger(requireContext(),
                "Unsuccessful Register, Please Try Again",
                1).show()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() { }
        })
    }
}

