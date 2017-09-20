package com.reggar.summvvm.feature.main

import com.reggar.summvvm.BaseTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.util.concurrent.TimeUnit

class MainViewModelTest : BaseTest() {

    lateinit var viewModel: MainViewModel

    override fun setUp() {
        super.setUp()
        viewModel = MainViewModel(testSchedulerProvider)
    }

    @Test
    fun onSummandUpdated_totalIsUpdated() {
        /* Given */

        /* When */
        viewModel.onSummandValueChanged(0, "10")
        viewModel.onSummandValueChanged(1, "5")

        /* Then */
        assertThat(viewModel.total.get()).isEqualTo("15")
    }

    @Test
    fun onSummandChangedOverriden_totalIsUpdated() {
        /* Given */

        /* When */
        viewModel.onSummandValueChanged(0, "10")
        viewModel.onSummandValueChanged(0, "7")

        /* Then */
        assertThat(viewModel.total.get()).isEqualTo("7")
    }

    @Test
    fun onSummandChangedToInvalid_treatAsZero() {
        /* Given */

        /* When */
        viewModel.onSummandValueChanged(0, "10")
        viewModel.onSummandValueChanged(1, ":(")

        /* Then */
        assertThat(viewModel.total.get()).isEqualTo("10")
    }

    @Test
    fun onTotalClicked_initially_isFlashingOn() {
        /* Given */

        /* When */
        viewModel.onTotalClicked()
        testScheduler.advanceTimeBy(0, TimeUnit.MILLISECONDS)

        /* Then */
        assertThat(viewModel.isTotalVisible.get()).isEqualTo(true)
    }

    @Test
    fun onTotalClicked_after1ms_isFlashingOff() {
        /* Given */

        /* When */
        viewModel.onTotalClicked()
        testScheduler.advanceTimeBy(1, TimeUnit.MILLISECONDS)

        /* Then */
        assertThat(viewModel.isTotalVisible.get()).isEqualTo(true)
    }

    @Test
    fun onTotalClicked_after500ms_isFlashingOn() {
        /* Given */

        /* When */
        viewModel.onTotalClicked()
        testScheduler.advanceTimeBy(500, TimeUnit.MILLISECONDS)

        /* Then */
        assertThat(viewModel.isTotalVisible.get()).isEqualTo(true)
    }

    @Test
    fun onTotalClicked_after1000ms_isFlashingOff() {
        /* Given */

        /* When */
        viewModel.onTotalClicked()
        testScheduler.advanceTimeBy(1000, TimeUnit.MILLISECONDS)

        /* Then */
        assertThat(viewModel.isTotalVisible.get()).isEqualTo(false)
    }
}