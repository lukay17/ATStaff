package com.lega.atstaff.ui.fragment

import android.text.Editable
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.lega.atstaff.R
import com.lega.atstaff.core.base.BaseFragmentDb
import com.lega.atstaff.databinding.FragmentUpdateBinding
import com.lega.atstaff.ui.util.CustomSnackBar
import com.lega.atstaff.ui.util.CustomToast
import com.lega.atstaff.ui.vm.UpdateViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UpdateFragment : BaseFragmentDb<FragmentUpdateBinding, UpdateViewModel>() {

    override fun getLayout(): Int = R.layout.fragment_update
    override val viewModel: UpdateViewModel by viewModels()
    val TAG:String = "UpdateFragement"
    var snackBar: CustomSnackBar = CustomSnackBar()
    val args: UpdateFragmentArgs by navArgs()

    override fun eventListeners() {
        dataBinding.backPage.setOnClickListener {
            val directions = UpdateFragmentDirections.toDetailFragment(args.personal)
            Navigation.findNavController(it).navigate(directions)
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() { }
        })
    }

    override fun initViewModels() {
        if(args.personal.id > 0 && args.personal.id != null){
            viewModel.getPersonalId(args.personal.id)
            viewModel.persona.observe(viewLifecycleOwner, Observer { item ->
                with(dataBinding){
                    //inputId.text = item.id
                }
            })
        }
    }

    override fun setBindingLayout() {
        super.setBindingLayout()
        dataBinding.viewModel = viewModel
    }

    override fun observeViewModels() {
        viewModel.personal.observe(viewLifecycleOwner, ::updateSuccess)

    }

    override fun showError(message: String?) {
        snackBar.Image(requireView(), message.toString(), 2)
    }

    private fun updateSuccess(success: String?) {
        if (success?.toString() == "success") {
            val directions = UpdateFragmentDirections.toDetailFragment(args.personal)
            navigate(directions)
        }else {
            CustomToast.Danger(requireContext(),
                "Unsuccessful Register, Please Try Again",
                1).show()
        }
    }

}