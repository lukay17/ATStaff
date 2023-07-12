package com.lega.atstaff.domain.usecase

import com.lega.atstaff.core.base.FlowUseCase
import com.lega.atstaff.core.di.IoDispatcher
import com.lega.atstaff.domain.models.Courses
import com.lega.atstaff.domain.models.Licenses
import com.lega.atstaff.domain.repository.PersonalRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetListLicenseUseCase @Inject constructor(
    @IoDispatcher dispatcher: CoroutineDispatcher,
    private val personalRespository: PersonalRepository
): FlowUseCase<GetListLicenseUseCase.Params, List<Licenses>>(dispatcher) {

    override fun execute(params: Params): Flow<List<Licenses>> =
        personalRespository.getListLicense(params.userId)

    data class Params(val userId:Int)
}
