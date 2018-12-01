package com.moonpi.swiftnotes.test

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.runner.AndroidJUnit4
import com.moonpi.swiftnotes.R
import com.moonpi.swiftnotes.app.MainApplication
import org.junit.Test
import org.junit.runner.RunWith
import ru.tinkoff.allure.android.deviceScreenshot
import ru.tinkoff.allure.annotations.DisplayName
import ru.tinkoff.allure.step


@RunWith(AndroidJUnit4::class)
@DisplayName("Первые шаги Espresso")
class SwiftNotesTest : AbstractTest<MainApplication>(MainApplication()) {


    private val mStringToBeTyped = "Espresso test"
    @Test
    @DisplayName("Простой тест")
    fun simpleTest() {
        app.open()
        step("Заполняем текстовое поле") {

            app.createNote()
            onView(withId(R.id.titleEdit)).perform(typeText(mStringToBeTyped))
            deviceScreenshot("input text")
        }
    }
}