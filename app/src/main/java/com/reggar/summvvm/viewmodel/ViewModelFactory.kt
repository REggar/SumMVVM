package com.reggar.summvvm.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.github.ajalt.timberkt.Timber
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

/**
 * A factory to be injected into Activities/View/Fragments where VM's are required.
 * Taken from https://github.com/googlesamples/android-architecture-components/tree/master/GithubBrowserSample and converted to Kotlin.
 */
@Singleton class ViewModelFactory @Inject constructor(
        private val creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {

    init {
        Timber.d { "new VM factory created." }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        var creator: Provider<ViewModel>? = creators[modelClass]
        if (creator == null) {
            for ((key, value) in creators) {
                if (modelClass.isAssignableFrom(key)) {
                    creator = value
                    break
                }
            }
        }
        if (creator == null) {
            throw IllegalArgumentException("Unknown model class $modelClass")
        }
        try {
            return creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
}
