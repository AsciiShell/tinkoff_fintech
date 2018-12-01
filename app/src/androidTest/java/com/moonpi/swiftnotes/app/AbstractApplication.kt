package com.moonpi.swiftnotes.app


import android.app.Activity
import android.support.test.rule.ActivityTestRule
import com.moonpi.swiftnotes.MainActivity
import com.moonpi.swiftnotes.util.getDevice
import org.junit.Rule

abstract class AbstractApplication<T : Activity>(val activity: Class<T>) {
    @get:Rule
    var activityRule = ActivityTestRule(MainActivity::class.java, false, false)

    open fun open() {
        activityRule.launchActivity(null)
    }

    fun pressBack() {
        getDevice().pressBack()
    }
}