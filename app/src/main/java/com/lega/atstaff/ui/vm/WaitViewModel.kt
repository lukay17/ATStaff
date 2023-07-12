package com.lega.atstaff.ui.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.lega.atstaff.core.base.BaseViewModel
import com.lega.atstaff.core.base.SingleEvent
import com.lega.atstaff.domain.models.Personal
import com.lega.atstaff.domain.models.User
import com.lega.atstaff.domain.usecase.GetPersonalUseCase
import com.lega.atstaff.domain.usecase.GetUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WaitViewModel  @Inject constructor(
    private val getUserUseCase: GetUserUseCase,
    private val personalIdUseCase: GetPersonalUseCase
) : BaseViewModel() {

    val TAG:String = "WaitViewModel"

    private val _user = MutableLiveData<User>()
    val user get() = _user

    private val _persona = MutableLiveData<Personal>()
    val persona get() = _persona

    fun initUser(userId: Int) {
        viewModelScope.launch {
            getUserUseCase.execute(GetUserUseCase.Params(userId))
                .onStart { _loading.value = true }
                .onCompletion { _loading.value = false }
                .catch { _error.value = SingleEvent(it) }
                .collect { _user.value = it }
        }
    }

    fun initPersonal(userId: Int) {
            viewModelScope.launch {
                personalIdUseCase.execute(GetPersonalUseCase.Params(userId))
                    .onStart {  _loading.value = true }
                    .onCompletion { _loading.value = false }
                    .catch {  _error.value = SingleEvent(it)  }
                    .collect{ _persona.value = it}
            }
        }
}