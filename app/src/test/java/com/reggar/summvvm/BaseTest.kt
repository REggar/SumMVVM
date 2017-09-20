package com.reggar.summvvm

import android.support.annotation.CallSuper
import org.junit.Before
import org.mockito.MockitoAnnotations

open class BaseTest {
    @CallSuper
    @Before
    open fun setUp() {
        MockitoAnnotations.initMocks(this)
    }
}
