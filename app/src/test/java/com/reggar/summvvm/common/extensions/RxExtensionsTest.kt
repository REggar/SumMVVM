package com.reggar.summvvm.common.extensions

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.reggar.summvvm.BaseTest
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import org.junit.Test

class RxExtensionsTest : BaseTest() {

    @Test
    fun add_callsCompositeDisposableAdd() {
        /* Given */
        val disposable = mock<Disposable>()
        val compositeDisposable = mock<CompositeDisposable>()

        /* When */
        disposable.add(compositeDisposable)

        /* Then */
        verify(compositeDisposable).add(disposable)
    }
}