package com.lega.atstaff.ui.fragment

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import com.lega.atstaff.R
import com.lega.atstaff.core.base.BaseFragmentDb
import com.lega.atstaff.core.base.recycler.BaseRvAdapter
import com.lega.atstaff.core.extension.loadImage
import com.lega.atstaff.databinding.FragmentHomeBinding
import com.lega.atstaff.domain.models.Personal
import com.lega.atstaff.ui.util.CustomToast
import com.lega.atstaff.ui.util.CustomSnackBar
import com.lega.atstaff.ui.vm.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragmentDb<FragmentHomeBinding, HomeViewModel>() {

    override val viewModel: HomeViewModel by viewModels()
    override fun getLayout(): Int  = R.layout.fragment_home
    var snackBar: CustomSnackBar = CustomSnackBar()
    val TAG:String = "HomeFragement"


    private val adapter by lazy {
        BaseRvAdapter<Personal>(R.layout.item_personal_list){ personal ->
            personal?.let {
                viewModel.getPersonalId(it.id)
            }
        }
    }

    override fun eventListeners() {
        dataBinding.personalRv.adapter = adapter

        dataBinding.filterPersonal.addTextChangedListener {personalFilter ->
            if(dataBinding.filterPersonal.getText().toString().isEmpty()){
                initViewModels()
            }else {
                val personalFiltered = adapter.items.filter { personal ->
                    personal.name.lowercase()
                        .contains(personalFilter.toString().lowercase())
                }
                adapter.updateAdapter(personalFiltered)
            }
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

    override fun initViewModels() {
        viewModel.emptyPersonalList()
        viewModel.loadPersonalList()
    }

    override fun observeViewModels() {
        viewModel.personalList.observe(viewLifecycleOwner){
            adapter.items = it
        }
        viewModel.persona.observe(viewLifecycleOwner, ::personaSucess)
    }

    private fun personaSucess(persona: Personal?) {
        if(persona == null && persona?.id!! < 1){
            CustomToast.Danger(requireContext(),"Error, Please Try Again",1).show()
        }else {
            val directions = HomeFragmentDirections.toDetailFragment(persona)
            navigate(directions)
        }
    }
}
