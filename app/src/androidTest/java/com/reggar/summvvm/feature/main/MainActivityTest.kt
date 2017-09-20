package com.reggar.summvvm.feature.main

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.replaceText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.reggar.summvvm.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @Rule @JvmField val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun onSummandsChanged_calculateSum() {
        /* Given */

        /* When */
        onView(withId(R.id.edittext_summand1))
                .perform(replaceText("1"))
        onView(withId(R.id.edittext_summand2))
                .perform(replaceText("2"))
        onView(withId(R.id.edittext_summand3))
                .perform(replaceText("3"))
        onView(withId(R.id.edittext_summand4))
                .perform(replaceText("4"))
        onView(withId(R.id.edittext_summand5))
                .perform(replaceText("5"))
        onView(withId(R.id.edittext_summand6))
                .perform(replaceText("6"))

        /* Then */
        onView(withId(R.id.textview_total))
                .check(matches(ViewMatchers.withText("21"))) // 1 + 2 + 3 + 4 + 5 + 6 = 21
    }
}
