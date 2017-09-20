package com.reggar.summvvm.feature.main

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import com.github.ajalt.timberkt.Timber
import com.reggar.summvvm.common.extensions.add
import com.reggar.summvvm.common.rx.SchedulerProvider
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class MainViewModel @Inject constructor(schedulerProvider: SchedulerProvider) : ViewModel() {
    var total = ObservableField("0")
    var isTotalVisible = ObservableBoolean(true)

    private var summandValues = HashMap<Int, Int>()
    private var isFlashing = false
    private val timer: Observable<Long> = Observable.interval(500, TimeUnit.MILLISECONDS, schedulerProvider.computation())
    private val disposables = CompositeDisposable()

    init {
        recalculateTotal()
        timer.subscribe({
            if (isFlashing) {
                isTotalVisible.set(it % 2 == 0L)
            }
        }, { error ->
            Timber.w(error) { "An error occurred." }
        }).add(disposables)
    }

    fun onSummandValueChanged(itemPosition: Int, value: CharSequence) {
        summandValues.put(itemPosition, value.toString().toIntOrNull() ?: 0)
        recalculateTotal()
    }

    fun onTotalClicked() {
        if (isFlashing) {
            isFlashing = false
            isTotalVisible.set(true)
        } else {
            isFlashing = true
        }
    }

    override fun onCleared() {
        disposables.clear()
        super.onCleared()
    }

    private fun recalculateTotal() {
        total.set(summandValues.values.sum().toString())
    }
}