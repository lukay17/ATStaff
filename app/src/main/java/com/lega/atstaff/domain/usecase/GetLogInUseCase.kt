package com.lega.atstaff.domain.usecase

import com.lega.atstaff.core.base.FlowUseCase
import com.lega.atstaff.core.di.IoDispatcher
import com.lega.atstaff.domain.models.User
import com.lega.atstaff.domain.repository.LoginRespository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLogInUseCase @Inject constructor(
    @IoDispatcher dispatcher: CoroutineDispatcher,
    private val loginRespository: LoginRespository
): FlowUseCase<GetLogInUseCase.Params, User>(dispatcher) {

    override fun execute(params: Params): Flow<User> =
        loginRespository.logIn(params.username,params.password)

    data class Params(val username:String, val password:String)
}