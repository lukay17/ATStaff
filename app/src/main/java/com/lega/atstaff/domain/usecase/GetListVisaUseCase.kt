package com.lega.atstaff.domain.usecase

import com.lega.atstaff.core.base.FlowUseCase
import com.lega.atstaff.core.di.IoDispatcher
import com.lega.atstaff.domain.models.Courses
import com.lega.atstaff.domain.models.Licenses
import com.lega.atstaff.domain.models.Visas
import com.lega.atstaff.domain.repository.PersonalRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetListVisaUseCase @Inject constructor(
    @IoDispatcher dispatcher: CoroutineDispatcher,
    private val personalRespository: PersonalRepository
): FlowUseCase<GetListVisaUseCase.Params, List<Visas>>(dispatcher) {

    override fun execute(params: Params): Flow<List<Visas>> =
        personalRespository.getListVisa(params.userId)

    data class Params(val userId:Int)
}
