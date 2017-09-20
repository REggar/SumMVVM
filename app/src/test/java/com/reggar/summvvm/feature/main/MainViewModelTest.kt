package com.reggar.summvvm.feature.main

import com.reggar.summvvm.BaseTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class MainViewModelTest : BaseTest() {

    lateinit var viewModel: MainViewModel

    override fun setUp() {
        super.setUp()
        viewModel = MainViewModel()
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
    fun onTotalClicked_isFlashingToggled() {
        /* Given */

        /* When */
        viewModel.onTotalClicked()

        /* Then */
        assertThat(viewModel.isTotalFlashing.get()).isEqualTo(true)
    }

    @Test
    fun onTotalClickedTwice_isFlashingToggledOff() {
        /* Given */

        /* When */
        viewModel.onTotalClicked()
        viewModel.onTotalClicked()

        /* Then */
        assertThat(viewModel.isTotalFlashing.get()).isEqualTo(false)
    }
}