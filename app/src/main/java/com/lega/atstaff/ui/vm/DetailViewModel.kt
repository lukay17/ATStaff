package com.lega.atstaff.ui.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.lega.atstaff.core.base.BaseViewModel
import com.lega.atstaff.core.base.SingleEvent
import com.lega.atstaff.domain.models.*
import com.lega.atstaff.domain.usecase.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel  @Inject constructor(
    private val deletePersonalUseCase: DeletePersonalUseCase,
    private val personalIdUseCase: GetPersonalUseCase,
    private val titleUseCase: GetListTitleUseCase,
    private val courseUseCase: GetListCourseUseCase,
    private val licenseUseCase: GetListLicenseUseCase,
    private val visaUseCase: GetListVisaUseCase
) : BaseViewModel() {

    val TAG:String = "DetailViewModel"

    private val _persona = MutableLiveData<Personal>()
    val persona get() = _persona

    private val _titleList = MutableLiveData<List<Titles>>()
    val titleList: LiveData<List<Titles>> get() = _titleList

    private val _courseList = MutableLiveData<List<Courses>>()
    val courseList: LiveData<List<Courses>> get() = _courseList

    private val _licenseList = MutableLiveData<List<Licenses>>()
    val licenseList: LiveData<List<Licenses>> get() = _licenseList

    private val _visaList = MutableLiveData<List<Visas>>()
    val visaList: LiveData<List<Visas>> get() = _visaList

    fun deletePersonal(userId: Int) {
        viewModelScope.launch {
            deletePersonalUseCase.execute(DeletePersonalUseCase.Params(userId))
                .onStart {  _loading.value = true }
                .onCompletion { _loading.value = false }
                .catch { _error.value = SingleEvent(it)  }
                .collect{  _persona.value = it }
        }
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

    fun loadTitleList(userId: Int) {
        viewModelScope.launch {
            titleUseCase.execute(GetListTitleUseCase.Params(userId))
                .onStart { _loading.value = true }
                .onCompletion { _loading.value = false }
                .catch { _error.value = SingleEvent(it) }
                .collect { _titleList.value = it }
        }
    }

    fun loadCourseList(userId: Int) {
        viewModelScope.launch {
            courseUseCase.execute(GetListCourseUseCase.Params(userId))
                .onStart { _loading.value = true }
                .onCompletion { _loading.value = false }
                .catch { _error.value = SingleEvent(it) }
                .collect { _courseList.value = it }
        }
    }

    fun loadlicenseList(userId: Int) {
        viewModelScope.launch {
            licenseUseCase.execute(GetListLicenseUseCase.Params(userId))
                .onStart { _loading.value = true }
                .onCompletion { _loading.value = false }
                .catch { _error.value = SingleEvent(it) }
                .collect { _licenseList.value = it }
        }
    }

    fun loadvisaList(userId: Int) {
        viewModelScope.launch {
            visaUseCase.execute(GetListVisaUseCase.Params(userId))
                .onStart { _loading.value = true }
                .onCompletion { _loading.value = false }
                .catch { _error.value = SingleEvent(it) }
                .collect { _visaList.value = it }
        }
    }
}