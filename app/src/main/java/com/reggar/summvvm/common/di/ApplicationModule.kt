package com.reggar.summvvm.common.di

import dagger.Module

/**
 * The Dagger module of the application, containing all application-wide singletons.
 */
@Module(includes = arrayOf(ViewModelModule::class))
class ApplicationModule