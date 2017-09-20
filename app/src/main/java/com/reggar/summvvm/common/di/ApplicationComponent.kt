package com.reggar.summvvm.common.di

import android.app.Application
import com.reggar.summvvm.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        AndroidInjectionModule::class,
        ApplicationModule::class,
        ActivityBuilderModule::class
))
interface ApplicationComponent {
    fun inject(application: App)

    @Component.Builder interface Builder {
        @BindsInstance fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }
}
