package com.reggar.summvvm.common.rx

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * An injectable, testable provider of [Scheduler]'s.
 */
class SchedulerProvider {
    fun ui(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

    fun computation(): Scheduler {
        return Schedulers.computation()
    }

    fun io(): Scheduler {
        return Schedulers.io()
    }
}

