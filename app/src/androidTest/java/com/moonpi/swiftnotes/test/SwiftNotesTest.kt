package com.moonpi.swiftnotes.test

import android.support.test.filters.LargeTest
import android.support.test.runner.AndroidJUnit4
import com.moonpi.swiftnotes.app.MainApplication
import org.junit.Test
import org.junit.runner.RunWith
import ru.tinkoff.allure.android.deviceScreenshot
import ru.tinkoff.allure.annotations.DisplayName
import ru.tinkoff.allure.step


@RunWith(AndroidJUnit4::class)
@LargeTest
@DisplayName("SwiftNotes tests")
class SwiftNotesTest : AbstractTest<MainApplication>(MainApplication()) {

    @Test
    @DisplayName("Navigation case (1)")
    fun navigateTest() {
        app.open()
        step("Launching application") {
            app.checkMainDisplayed()
            deviceScreenshot("Application is launched")
        }
        step("Assert controls") {
            app.checkControls()
            deviceScreenshot("Controls on layout")
        }
        step("Assert default note values") {
            app.createNote()
            app.checkNewNoteDefault()
            deviceScreenshot("Default note")
        }
        step("Save dialog") {
            // Close keyboard
            app.pressBack()
            app.pressBack()
            app.checkSaveDialog()
            deviceScreenshot("Save dialog")
        }
        step("Press NO") {
            app.saveDialogConfirm(false)
            app.checkMainDisplayed()
            deviceScreenshot("Main page")
        }
    }

    private val newTitleText = "Заметка 1"
    private val newNoteText = "Тестовая запись 1"

    @Test
    @DisplayName("Create note case(2)")
    fun createTest() {
        app.open()
        step("Create note") {
            app.createNote()
            app.checkEditDisplayed()
            deviceScreenshot("New note")
        }
        step("Fill note") {
            app.fillTitle(newTitleText)
            app.fillNoteBody(newNoteText)
            app.checkTitle(newTitleText)
            app.checkNoteBody(newNoteText)
            deviceScreenshot("Note is filled")
        }
        step("Save dialog") {
            // Close keyboard
            app.pressBack()
            app.pressBack()
            app.checkSaveDialog()
            deviceScreenshot("Save dialog")
        }
        step("Press YES") {
            app.saveDialogConfirm(true)
            app.checkMainDisplayed()
            app.checkNoteExists(newTitleText, newNoteText)
            deviceScreenshot("Main page")
        }
    }

    @Test
    @DisplayName("Menu items case(3)")
    fun menuTest() {
        app.open()
        step("Open main menu") {
            app.openMenu()
            app.checkMainMenu()
            deviceScreenshot("Main menu items")
            // Hide menu
            app.pressBack()
        }
        step("Open note creation dialog") {
            app.createNote()
            app.checkEditDisplayed()
            deviceScreenshot("New note")
        }
        step("Open edit menu") {
            app.openMenu()
            app.checkEditMenu()
            deviceScreenshot("Edit menu items")
            // Hide menu
            app.pressBack()
        }
    }
}