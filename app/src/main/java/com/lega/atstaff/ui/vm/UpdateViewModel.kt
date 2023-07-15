package com.lega.atstaff.ui.vm

import android.util.Log
import androidx.constraintlayout.motion.utils.ViewState
import androidx.lifecycle.*
import com.lega.atstaff.core.base.BaseViewModel
import com.lega.atstaff.core.base.SingleEvent
import com.lega.atstaff.core.extension.isEmptyOrNull
import com.lega.atstaff.domain.models.Personal
import com.lega.atstaff.domain.usecase.GetPersonalUseCase
import com.lega.atstaff.domain.usecase.UpdatePersonalUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UpdateViewModel  @Inject constructor(
    private val updatePersonalUseCase: UpdatePersonalUseCase,
    private val personalIdUseCase: GetPersonalUseCase,
) : BaseViewModel() {

    val TAG:String = "UpdateViewModel"

    val id =  MutableLiveData("")
    val name = MutableLiveData("")
    val dni = MutableLiveData("")
    val nationality = MutableLiveData("")
    val organization = MutableLiveData("")
    val position = MutableLiveData("")
    val twitter = MutableLiveData("")
    val facebook = MutableLiveData("")
    val linkedin = MutableLiveData("")
    val phone = MutableLiveData("")

    private val _persona = MutableLiveData<Personal>()
    val persona get() = _persona

    private val _personal = MutableLiveData<String>()
    val personal get() = _personal

    private val _isNull = MutableLiveData<String>()
    val nulo get() = _isNull

        fun updateProfile() {
            if (isEmptyOrNull(name.value?.toString()) == true) {
                _isNull.value = "Name is required"
            }else {
                viewModelScope.launch {
                    updatePersonalUseCase.execute(UpdatePersonalUseCase.Params(id.value ?: "",
                        name.value ?: "",
                        dni.value ?: "",
                        nationality.value ?: "",
                        organization.value ?: "",
                        position.value ?: "",
                        twitter.value ?: "",
                        facebook.value ?: "",
                        linkedin.value ?: "",
                        phone.value ?: ""))
                        .onStart { _loading.value = true }
                        .onCompletion { _loading.value = false }
                        .catch { _error.value = SingleEvent(it) }
                        .collect { _personal.value = it }
                }
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
}


