package com.lega.atstaff.domain.usecase

import com.lega.atstaff.core.base.FlowUseCase
import com.lega.atstaff.core.di.IoDispatcher
import com.lega.atstaff.domain.models.Personal
import com.lega.atstaff.domain.repository.PersonalRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetListPersonalUseCase @Inject constructor(
    @IoDispatcher dispatcher: CoroutineDispatcher,
    private val personalRespository: PersonalRepository
): FlowUseCase<Unit, List<Personal>>(dispatcher) {

    override fun execute(params: Unit): Flow<List<Personal>> {
        return personalRespository.getListPersonal()
    }
}