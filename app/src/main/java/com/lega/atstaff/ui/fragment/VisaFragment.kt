package com.lega.atstaff.ui.fragment

import androidx.fragment.app.viewModels
import com.lega.atstaff.ATStaffApp
import com.lega.atstaff.ATStaffApp.Companion.prefs
import com.lega.atstaff.R
import com.lega.atstaff.core.base.BaseFragmentDb
import com.lega.atstaff.core.base.recycler.BaseRvAdapter
import com.lega.atstaff.databinding.FragmentVisaBinding
import com.lega.atstaff.domain.models.Courses
import com.lega.atstaff.domain.models.Visas
import com.lega.atstaff.ui.util.CustomSnackBar
import com.lega.atstaff.ui.vm.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VisaFragment : BaseFragmentDb<FragmentVisaBinding, DetailViewModel>() {

    override fun getLayout(): Int = R.layout.fragment_visa
    override val viewModel: DetailViewModel by viewModels()
    val TAG:String = "VisaFragement"
    var snackBar: CustomSnackBar = CustomSnackBar()

    private val adapterVisa by lazy {
        BaseRvAdapter<Visas>(R.layout.item_visa_list){ visa ->
            visa?.let {
                snackBar.Image(requireView(), it.country, 2)
            }
        }
    }

    override fun initViewModels() {
        arguments?.getInt("Id")?.let { viewModel.loadvisaList(it) }
        dataBinding.visaRV.adapter?.notifyDataSetChanged()
        dataBinding.visaRV.adapter = adapterVisa
    }

    override fun observeViewModels() {
        viewModel.visaList.observe(viewLifecycleOwner) {
            adapterVisa.items = it
        }
    }
}