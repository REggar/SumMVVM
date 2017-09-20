package com.reggar.summvvm

import android.support.annotation.CallSuper
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import com.reggar.summvvm.common.rx.SchedulerProvider
import io.reactivex.schedulers.TestScheduler
import org.junit.Before
import org.mockito.MockitoAnnotations

open class BaseTest {
    protected val testScheduler = TestScheduler()
    protected val testSchedulerProvider = mock<SchedulerProvider> {
        on { ui() } doReturn testScheduler
        on { io() } doReturn testScheduler
        on { computation() } doReturn testScheduler
    }

    @CallSuper
    @Before
    open fun setUp() {
        MockitoAnnotations.initMocks(this)
    }
}
