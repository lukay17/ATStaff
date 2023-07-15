package com.lega.atstaff.ui.vm

import android.util.Log
import androidx.lifecycle.*
import com.lega.atstaff.core.base.BaseViewModel
import com.lega.atstaff.core.base.SingleEvent
import com.lega.atstaff.core.extension.isEmail
import com.lega.atstaff.core.extension.isEmptyOrNull
import com.lega.atstaff.domain.usecase.AddPersonalUseCase
import com.lega.atstaff.ui.util.CustomSnackBar
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
    var snackBar: CustomSnackBar = CustomSnackBar()

    private val _user = MutableLiveData<String>()
    val user get() = _user

    private val _isNull = MutableLiveData<String>()
    val nulo get() = _isNull

        fun registerUser() {
            if (isEmptyOrNull(name.value?.toString()) == true) {
               _isNull.value = "Name is required"
            } else if (isEmptyOrNull(email.value?.toString()) == true) {
                _isNull.value = "Email is required"
            } else if (isEmptyOrNull(username.value?.toString()) == true){
                _isNull.value = "Username is required"
            }else if (isEmptyOrNull(password.value?.toString()) == true){
                _isNull.value = "Password is required"
            }else if (email.value?.toString()?.isEmail() == false){
                _isNull.value = "Email is incorrect"
            }else{
                viewModelScope.launch {
                    addPersonalUseCase.execute(AddPersonalUseCase.Params(name.value ?: "",
                        organization.value ?: "",
                        nationality.value ?: "",
                        email.value ?: "",
                        username.value ?: "",
                        password.value ?: ""))
                        .onStart { _loading.value = true }
                        .onCompletion { _loading.value = false }
                        .catch { _error.value = SingleEvent(it) }
                        .collect { _user.value = it }
                }
            }

        }
}


