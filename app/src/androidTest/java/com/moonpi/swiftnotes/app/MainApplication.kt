package com.moonpi.swiftnotes.app

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.replaceText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import com.moonpi.swiftnotes.MainActivity
import com.moonpi.swiftnotes.R
import com.moonpi.swiftnotes.util.byContentDesc
import com.moonpi.swiftnotes.util.waitFindObject

class MainApplication : AbstractApplication<MainActivity>(MainActivity::class.java) {

    private val menuDesc = "Ещё"

    fun createNote() {
        onView(withId(R.id.newNote)).perform(click())
    }

    fun checkMainDisplayed() {
        onView(withText(R.string.app_name)).check(matches(isDisplayed()))
    }

    fun checkEditDisplayed() {
        onView(withId(R.id.titleEdit)).check(matches(isDisplayed()))
    }

    fun checkControls() {
        onView(withText(R.string.app_name)).check(matches(isDisplayed()))
        onView(withId(R.id.noNotes)).check(matches(withText(R.string.no_notes_text)))
        onView(withId(R.id.newNote)).check(matches(isDisplayed()))
    }

    fun checkNewNoteDefault() {
        onView(withId(R.id.titleEdit)).check(matches(withHint(R.string.note_title)))
        onView(withId(R.id.bodyEdit)).check(matches(withHint(R.string.title_edit_notes_activity)))
    }

    fun checkSaveDialog() {
        onView(withText(R.string.dialog_save_changes)).check(matches(isDisplayed()))
        onView(withText(R.string.yes_button)).check(matches(isDisplayed()))
        onView(withText(R.string.no_button)).check(matches(isDisplayed()))
    }

    fun saveDialogConfirm(action: Boolean) {
        if (action)
            onView(withText(R.string.yes_button)).perform(click())
        else
            onView(withText(R.string.no_button)).perform(click())
    }

    fun fillTitle(text: String) {
        onView(withId(R.id.titleEdit)).perform(replaceText(text))
    }

    fun fillNoteBody(text: String) {
        onView(withId(R.id.bodyEdit)).perform(replaceText(text))
    }

    fun checkTitle(text: String) {
        onView(withId(R.id.titleEdit)).check(matches(withText(text)))
    }

    fun checkNoteBody(text: String) {
        onView(withId(R.id.bodyEdit)).check(matches(withText(text)))
    }

    fun checkNoteExists(title: String, body: String) {
        onView(withId(R.id.titleView)).check(matches(withText(title)))
        onView(withId(R.id.bodyView)).check(matches(withText(body)))
    }

    fun openMenu() {
        byContentDesc(menuDesc).waitFindObject().click()
    }

    fun checkMainMenu() {
        onView(withText(R.string.action_backup)).check(matches(isDisplayed()))
        onView(withText(R.string.action_restore)).check(matches(isDisplayed()))
        onView(withText(R.string.action_rate_app)).check(matches(isDisplayed()))
    }

    fun checkEditMenu() {
        onView(withText(R.string.action_font_size)).check(matches(isDisplayed()))
        onView(withText(R.string.action_hide_body)).check(matches(isDisplayed()))
    }
}
