package com.moonpi.swiftnotes.app


import android.app.Activity
import android.support.test.InstrumentationRegistry
import android.support.test.rule.ActivityTestRule
import com.moonpi.swiftnotes.util.getDevice
import org.junit.Rule
import java.io.File


abstract class AbstractApplication<T : Activity>(val activity: Class<T>) {

    @get:Rule
    var activityRule: ActivityTestRule<T> = object : ActivityTestRule<T>(activity, false, false) {

        override fun beforeActivityLaunched() {
            super.beforeActivityLaunched()
            val appDir = InstrumentationRegistry.getTargetContext().filesDir.parentFile
            if (appDir.exists()) {
                val children = appDir.list()
                for (s in children) {
                    if (s != "lib") {
                        File(appDir, s).deleteRecursively()
                    }
                }
            }

        }
    }

    open fun open() {
        activityRule.launchActivity(null)
    }

    fun pressBack() {
        getDevice().pressBack()
    }
}