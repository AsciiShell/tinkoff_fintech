package com.moonpi.swiftnotes.app

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.matcher.ViewMatchers
import com.moonpi.swiftnotes.MainActivity
import com.moonpi.swiftnotes.R

class MainApplication : AbstractApplication<MainActivity>(MainActivity::class.java) {

    fun createNote() {
        onView(ViewMatchers.withId(R.id.newNote)).perform(ViewActions.click())
    }
}
