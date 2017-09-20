package com.reggar.summvvm.feature.main

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import javax.inject.Inject

class MainViewModel @Inject constructor() : ViewModel() {
    var total = ObservableField("0")
    var isTotalFlashing = ObservableBoolean(false)

    private var summandValues = HashMap<Int, Int>()

    init {
        recalculateTotal()
    }

    fun onSummandValueChanged(itemPosition: Int, value: CharSequence) {
        summandValues.put(itemPosition, value.toString().toIntOrNull() ?: 0)
        recalculateTotal()
    }

    fun onTotalClicked() {
        isTotalFlashing.set(!isTotalFlashing.get())
    }

    private fun recalculateTotal() {
        total.set(summandValues.values.sum().toString())
    }
}