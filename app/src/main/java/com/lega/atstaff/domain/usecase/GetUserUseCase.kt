package com.lega.atstaff.domain.usecase

import com.lega.atstaff.core.base.FlowUseCase
import com.lega.atstaff.core.di.IoDispatcher
import com.lega.atstaff.domain.models.Personal
import com.lega.atstaff.domain.models.User
import com.lega.atstaff.domain.repository.LoginRespository
import com.lega.atstaff.domain.repository.PersonalRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUserUseCase  @Inject constructor(
    @IoDispatcher dispatcher: CoroutineDispatcher,
    private val userRespository: LoginRespository
): FlowUseCase<GetUserUseCase.Params, User>(dispatcher) {

    override fun execute(params: Params): Flow< User> =
        userRespository.getUserId(params.userId)

    data class Params(val userId:Int)
}
