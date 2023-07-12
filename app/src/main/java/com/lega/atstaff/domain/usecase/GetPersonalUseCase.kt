package com.lega.atstaff.domain.usecase

import com.lega.atstaff.core.base.FlowUseCase
import com.lega.atstaff.core.di.IoDispatcher
import com.lega.atstaff.domain.models.Personal
import com.lega.atstaff.domain.repository.PersonalRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPersonalUseCase  @Inject constructor(
    @IoDispatcher dispatcher: CoroutineDispatcher,
    private val personalRespository: PersonalRepository
): FlowUseCase<GetPersonalUseCase.Params, Personal>(dispatcher) {

    override fun execute(params: Params): Flow<Personal> =
        personalRespository.getPersoanlId(params.userId)

    data class Params(val userId:Int)
}
