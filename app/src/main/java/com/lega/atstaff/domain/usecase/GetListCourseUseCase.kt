package com.lega.atstaff.domain.usecase

import com.lega.atstaff.core.base.FlowUseCase
import com.lega.atstaff.core.di.IoDispatcher
import com.lega.atstaff.domain.models.Courses
import com.lega.atstaff.domain.repository.PersonalRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetListCourseUseCase @Inject constructor(
    @IoDispatcher dispatcher: CoroutineDispatcher,
    private val personalRespository: PersonalRepository
): FlowUseCase<GetListCourseUseCase.Params, List<Courses>>(dispatcher) {

    override fun execute(params: Params): Flow<List<Courses>> =
        personalRespository.getListCourse(params.userId)

    data class Params(val userId:Int)
}
