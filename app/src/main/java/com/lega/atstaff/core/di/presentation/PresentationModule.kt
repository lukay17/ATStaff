package com.lega.atstaff.core.di.presentation

import com.lega.atstaff.core.di.IoDispatcher
import com.lega.atstaff.presentation.core.LoadingDelegate
import com.lega.atstaff.presentation.core.LoadingDelegateViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class PresentationModule {

    @Provides
    @Singleton
    fun provideEventsApp(@IoDispatcher workerScope: CoroutineScope): LoadingDelegateViewModel {
        return LoadingDelegate(workerScope)
    }
}
