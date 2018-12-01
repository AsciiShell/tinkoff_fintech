package com.moonpi.swiftnotes.test

import android.os.Environment
import org.junit.Before
import org.junit.BeforeClass
import java.io.File


open class AbstractTest<T>(val app: T) {
    companion object {
        @BeforeClass
        @JvmStatic
        fun setup() {
            val oldResults = File(Environment.getExternalStorageDirectory().absolutePath + "/allure-results")
            if (oldResults.exists())
                oldResults.deleteRecursively()
        }
    }

    @Before
    fun clearAppData() {
        try {
            //      (context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager).clearApplicationUserData()

        } catch (exception: Exception) {
            exception.printStackTrace()
        }
    }
}