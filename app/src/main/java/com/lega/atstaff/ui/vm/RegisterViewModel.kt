package com.lega.atstaff.ui.vm

import android.util.Log
import androidx.lifecycle.*
import com.lega.atstaff.core.base.BaseViewModel
import com.lega.atstaff.core.base.SingleEvent
import com.lega.atstaff.core.extension.combine
import com.lega.atstaff.core.extension.isEmail
import com.lega.atstaff.core.extension.isValidPass
import com.lega.atstaff.domain.models.Personal
import com.lega.atstaff.domain.models.User
import com.lega.atstaff.domain.usecase.AddPersonalUseCase
import com.lega.atstaff.domain.usecase.GetLogInUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel  @Inject constructor(
    private val addPersonalUseCase: AddPersonalUseCase
) : BaseViewModel() {

    val TAG:String = "RegisterViewModel"

    val name = MutableLiveData("")
    val organization = MutableLiveData("")
    val nationality = MutableLiveData("")
    val email = MutableLiveData("")
    val username = MutableLiveData("")
    val password = MutableLiveData("")

    val errorName = liveData<Boolean> {
        if(name.value.toString().isBlank() || name.value.toString().length < 5)
            Log.e(TAG, "PASO POR AQUI")
            return@liveData
    }

    private val _user = MutableLiveData<String>()
    val user get() = _user

        fun registerUser() {
            viewModelScope.launch {
                addPersonalUseCase.execute(AddPersonalUseCase.Params(name.value?:"", organization.value?:"", nationality.value?:"", email.value?:"",username.value?:"",password.value?:""))
                    .onStart { _loading.value = true }
                    .onCompletion { _loading.value = false }
                    .catch { _error.value = SingleEvent(it) }
                    .collect{ _user.value = it}
            }
        }
    }

