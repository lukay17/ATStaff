package com.lega.atstaff.core.base.recycler

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.lega.atstaff.core.base.BaseViewModel
import androidx.databinding.library.baseAdapters.BR

class BaseViewHolderBinding(val viewmodel: BaseViewModel?, val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item:Any?){
        binding.setVariable(BR.viewModel,viewmodel)
        binding.setVariable(BR.item, item)
        //binding.setVariable(4,viewmodel)
        //binding.setVariable(2, item)
        binding.executePendingBindings()
    }
}