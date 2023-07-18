package com.lega.atstaff.ui.fragment

import android.webkit.WebViewClient
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.lega.atstaff.R
import com.lega.atstaff.core.base.BaseFragmentDb
import com.lega.atstaff.databinding.FragmentViewPDFBinding
import com.lega.atstaff.ui.util.CustomSnackBar
import com.lega.atstaff.ui.vm.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ViewPDFFragment : BaseFragmentDb<FragmentViewPDFBinding, DetailViewModel>() {

    override fun getLayout(): Int = R.layout.fragment_view_p_d_f
    override val viewModel: DetailViewModel by viewModels()
    val TAG:String = "ViewPDFFragement"
    var snackBar: CustomSnackBar = CustomSnackBar()
    val args: ViewPDFFragmentArgs by navArgs()

    override fun initViewModels() {
        dataBinding.viewPDF.webViewClient = WebViewClient()
        dataBinding.viewPDF.settings.setSupportZoom(true)
        dataBinding.viewPDF.settings.setJavaScriptEnabled(true)
       dataBinding.viewPDF.loadUrl("https://docs.google.com/gview?embedded=true&url=" + args.pdf)
    }
}
