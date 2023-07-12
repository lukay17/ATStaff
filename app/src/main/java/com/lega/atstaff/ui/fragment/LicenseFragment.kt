package com.lega.atstaff.ui.fragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.lega.atstaff.ATStaffApp
import com.lega.atstaff.ATStaffApp.Companion.prefs
import com.lega.atstaff.R
import com.lega.atstaff.core.base.BaseFragmentDb
import com.lega.atstaff.core.base.recycler.BaseRvAdapter
import com.lega.atstaff.databinding.FragmentLicenseBinding
import com.lega.atstaff.domain.models.Licenses
import com.lega.atstaff.domain.models.Titles
import com.lega.atstaff.ui.util.CustomSnackBar
import com.lega.atstaff.ui.vm.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LicenseFragment : BaseFragmentDb<FragmentLicenseBinding, DetailViewModel>() {

    override fun getLayout(): Int = R.layout.fragment_license
    override val viewModel: DetailViewModel by viewModels()
    val TAG:String = "LicenseFragement"
    var snackBar: CustomSnackBar = CustomSnackBar()

    private val adapterLicense by lazy {
        BaseRvAdapter<Licenses>(R.layout.item_license_list){ licenses ->
            licenses?.let {
                snackBar.Image(requireView(), it.entity, 2)
            }
        }
    }

    override fun eventListeners() {
        dataBinding.licenseRV.adapter = adapterLicense
    }

    override fun initViewModels() {
        viewModel.loadlicenseList(prefs.getId())
    }

    override fun observeViewModels() {
        viewModel.licenseList.observe(viewLifecycleOwner) {
            adapterLicense.items = it
        }
    }

}