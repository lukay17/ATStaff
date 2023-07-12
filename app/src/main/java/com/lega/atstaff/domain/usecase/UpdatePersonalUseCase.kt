package com.lega.atstaff.domain.usecase

import com.lega.atstaff.core.base.FlowUseCase
import com.lega.atstaff.core.di.IoDispatcher
import com.lega.atstaff.domain.models.Personal
import com.lega.atstaff.domain.repository.PersonalRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UpdatePersonalUseCase  @Inject constructor(
    @IoDispatcher dispatcher: CoroutineDispatcher,
    private val personalRespository: PersonalRepository
): FlowUseCase<UpdatePersonalUseCase.Params, String>(dispatcher) {

    override fun execute(params: Params): Flow<String> =
        personalRespository.updatePersonal(params.id, params.name, params.dni, params.nationality, params.organization, params.position, params.twitter, params.facebook, params.linkedin, params.phone)

    data class Params(val id: String, val name: String, val dni:String, val nationality: String, val organization: String, val position: String, val twitter: String, val facebook: String, val linkedin:String, val phone:String)
}

