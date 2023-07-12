package com.lega.atstaff.domain.usecase

import com.lega.atstaff.core.base.FlowUseCase
import com.lega.atstaff.core.di.IoDispatcher
import com.lega.atstaff.domain.models.Titles
import com.lega.atstaff.domain.repository.PersonalRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetListTitleUseCase @Inject constructor(
    @IoDispatcher dispatcher: CoroutineDispatcher,
    private val personalRespository: PersonalRepository
): FlowUseCase<GetListTitleUseCase.Params, List<Titles>>(dispatcher) {

    override fun execute(params: Params): Flow<List<Titles>> =
        personalRespository.getListTitle(params.userId)

    data class Params(val userId:Int)
}
