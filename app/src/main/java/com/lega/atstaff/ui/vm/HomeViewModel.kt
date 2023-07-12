package com.lega.atstaff.ui.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.lega.atstaff.core.base.BaseViewModel
import com.lega.atstaff.core.base.SingleEvent
import com.lega.atstaff.domain.models.Personal
import com.lega.atstaff.domain.usecase.GetListPersonalUseCase
import com.lega.atstaff.domain.usecase.GetPersonalUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val personalListUseCase: GetListPersonalUseCase,
    private val personalIdUseCase: GetPersonalUseCase
) : BaseViewModel() {

    private val _personalList = MutableLiveData<List<Personal>>()
    val personalList: LiveData<List<Personal>> get() = _personalList
    private val _persona = MutableLiveData<Personal>()
    val persona get() = _persona

    fun loadPersonalList() {
        viewModelScope.launch {
            personalListUseCase.execute(Unit)
                .onStart { _loading.value = true }
                .onCompletion { _loading.value = false }
                .catch { _error.value = SingleEvent(it) }
                .collect { _personalList.value = it }
        }
    }

    fun emptyPersonalList(){
        _personalList.value = mutableListOf()
    }

    fun getPersonalId(userId: Int) {
        viewModelScope.launch {
            personalIdUseCase.execute(GetPersonalUseCase.Params(userId))
                .onStart {  _loading.value = true }
                .onCompletion { _loading.value = false }
                .catch {  _error.value = SingleEvent(it)  }
                .collect{ _persona.value = it}
        }
    }
}