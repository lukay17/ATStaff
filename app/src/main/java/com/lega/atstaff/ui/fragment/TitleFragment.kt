package com.lega.atstaff.ui.fragment

import androidx.fragment.app.viewModels
import com.lega.atstaff.ATStaffApp.Companion.prefs
import com.lega.atstaff.R
import com.lega.atstaff.core.base.BaseFragmentDb
import com.lega.atstaff.core.base.recycler.BaseRvAdapter
import com.lega.atstaff.databinding.FragmentTilteBinding
import com.lega.atstaff.domain.models.Titles
import com.lega.atstaff.ui.util.CustomSnackBar
import com.lega.atstaff.ui.vm.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TitleFragment : BaseFragmentDb<FragmentTilteBinding, DetailViewModel>() {

    override fun getLayout(): Int = R.layout.fragment_tilte
    override val viewModel: DetailViewModel by viewModels()
    val TAG:String = "TitleFragement"
    var snackBar: CustomSnackBar = CustomSnackBar()

    private val adapterTitle by lazy {
        BaseRvAdapter<Titles>(R.layout.item_title_list){ titles ->
            titles?.let {
                snackBar.Image(requireView(), it.name, 2)
            }
        }
    }

    override fun eventListeners() {
        dataBinding.titleRV.adapter = adapterTitle
    }

    override fun initViewModels() {
        arguments?.getInt("Id")?.let { viewModel.loadTitleList(it) }
    }

    override fun observeViewModels() {
        viewModel.titleList.observe(viewLifecycleOwner) {
            adapterTitle.items = it
        }
    }
}