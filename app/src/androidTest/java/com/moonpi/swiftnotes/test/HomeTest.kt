package com.moonpi.swiftnotes.test

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.moonpi.swiftnotes.MainActivity
import com.moonpi.swiftnotes.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.tinkoff.allure.android.deviceScreenshot
import ru.tinkoff.allure.annotations.DisplayName
import ru.tinkoff.allure.step

@RunWith(AndroidJUnit4::class)
@DisplayName("Первые шаги Espresso")
class ExampleEspressoKotlinTest {
    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)
    val mStringToBetyped = "Espresso test"
    @Test
    @DisplayName("Простой тест")
    fun simpleTest() {
        step("Заполняем текстовое поле") {
            onView(withId(R.id.newNote)).perform(click())
            onView(withId(R.id.titleEdit)).perform(typeText(mStringToBetyped))
            deviceScreenshot("input text")
        }
    }
}