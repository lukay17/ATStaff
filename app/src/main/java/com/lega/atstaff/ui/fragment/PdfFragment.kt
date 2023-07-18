package com.lega.atstaff.ui.fragment

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.lega.atstaff.R
import com.lega.atstaff.core.base.BaseFragmentDb
import com.lega.atstaff.databinding.FragmentPdfBinding
import com.lega.atstaff.ui.util.CustomSnackBar
import com.lega.atstaff.ui.vm.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint
import com.pdfview.PDFView

@AndroidEntryPoint
class PdfFragment : BaseFragmentDb<FragmentPdfBinding, DetailViewModel>() {

    override fun getLayout(): Int = R.layout.fragment_pdf
    override val viewModel: DetailViewModel by viewModels()
    val TAG:String = "PDFFragement"
    var snackBar: CustomSnackBar = CustomSnackBar()
    val args: PdfFragmentArgs by  navArgs()

    override fun initViewModels() {
        dataBinding.viewPDF.fromAsset(args.pdf).show()
    }
}