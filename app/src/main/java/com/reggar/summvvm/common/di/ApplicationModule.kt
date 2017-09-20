package com.reggar.summvvm.common.di

import com.reggar.summvvm.common.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * The Dagger module of the application, containing all application-wide singletons.
 */
@Module(includes = arrayOf(ViewModelModule::class))
class ApplicationModule {
    @Singleton @Provides
    internal fun provideSchedulerProvider() = SchedulerProvider()
}