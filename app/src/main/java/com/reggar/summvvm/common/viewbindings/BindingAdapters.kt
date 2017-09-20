package com.reggar.summvvm.common.viewbindings

import android.databinding.BindingAdapter
import android.view.View
import android.view.animation.AnimationUtils
import com.reggar.summvvm.R

object BindingAdapters {

    @JvmStatic @BindingAdapter("isFlashing")
    fun setIsFlashing(view: View, isFlashing: Boolean) {
        val animation = view.animation
        if (isFlashing && animation == null) {
            view.startAnimation(AnimationUtils.loadAnimation(view.context, R.anim.blink).apply {
                setInterpolator { if (it < 0.5f) 0f else 1f } // I would use a less ugly interpolator, but this matches the on/off 500ms requirement.
            })
        } else if (animation != null) {
            animation.cancel()
            view.animation = null
        }
    }
}