package com.reggar.summvvm.common.di

import com.reggar.summvvm.feature.main.MainActivity
import com.reggar.summvvm.feature.main.MainModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {
    @ContributesAndroidInjector(modules = arrayOf(MainModule::class))
    abstract fun bindMainActivity(): MainActivity
}