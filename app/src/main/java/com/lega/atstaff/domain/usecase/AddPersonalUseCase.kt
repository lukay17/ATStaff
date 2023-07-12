package com.lega.atstaff.domain.usecase

import com.lega.atstaff.core.base.FlowUseCase
import com.lega.atstaff.core.di.IoDispatcher
import com.lega.atstaff.domain.repository.LoginRespository
import com.lega.atstaff.domain.repository.PersonalRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AddPersonalUseCase  @Inject constructor(
    @IoDispatcher dispatcher: CoroutineDispatcher,
    private val userRespository: LoginRespository
): FlowUseCase<AddPersonalUseCase.Params, String>(dispatcher) {

    override fun execute(params: Params): Flow<String> =
        userRespository.registerPersonal(params.name, params.organization, params.nationality, params.email, params.username, params.password)

    data class Params(val name: String, val organization: String, val nationality: String, val email: String, val username: String, val password: String)
}