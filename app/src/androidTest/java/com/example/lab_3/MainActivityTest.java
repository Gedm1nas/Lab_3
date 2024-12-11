package com.example.lab_3;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import com.example.lab_3.MainActivity;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void simpleAddition_shouldDisplayCorrectResult() {
        Espresso.onView(withId(R.id.button_2)).perform(ViewActions.click());
        Espresso.onView(withId(R.id.button_add)).perform(ViewActions.click());
        Espresso.onView(withId(R.id.button_3)).perform(ViewActions.click());
        Espresso.onView(withId(R.id.button_equal)).perform(ViewActions.click());

        Espresso.onView(withId(R.id.resultTextView)).check(ViewAssertions.matches(withText("5.0")));
    }


    @Test
    public void subtraction_shouldDisplayCorrectResult() {
        Espresso.onView(withId(R.id.button_7)).perform(ViewActions.click());
        Espresso.onView(withId(R.id.button_subtract)).perform(ViewActions.click());
        Espresso.onView(withId(R.id.button_3)).perform(ViewActions.click());
        Espresso.onView(withId(R.id.button_equal)).perform(ViewActions.click());

        Espresso.onView(withId(R.id.resultTextView)).check(ViewAssertions.matches(withText("4.0")));
    }

    @Test
    public void multiplication_shouldDisplayCorrectResult() {
        Espresso.onView(withId(R.id.button_4)).perform(ViewActions.click());
        Espresso.onView(withId(R.id.button_multiply)).perform(ViewActions.click());
        Espresso.onView(withId(R.id.button_6)).perform(ViewActions.click());
        Espresso.onView(withId(R.id.button_equal)).perform(ViewActions.click());

        Espresso.onView(withId(R.id.resultTextView)).check(ViewAssertions.matches(withText("24.0")));
    }

    @Test
    public void division_shouldDisplayCorrectResult() {
        Espresso.onView(withId(R.id.button_1)).perform(ViewActions.click());
        Espresso.onView(withId(R.id.button_0)).perform(ViewActions.click());
        Espresso.onView(withId(R.id.button_divide)).perform(ViewActions.click());
        Espresso.onView(withId(R.id.button_5)).perform(ViewActions.click());
        Espresso.onView(withId(R.id.button_equal)).perform(ViewActions.click());

        Espresso.onView(withId(R.id.resultTextView)).check(ViewAssertions.matches(withText("2.0")));
    }

    @Test
    public void divisionByZero_shouldDisplayError() {
        Espresso.onView(withId(R.id.button_5)).perform(ViewActions.click());
        Espresso.onView(withId(R.id.button_divide)).perform(ViewActions.click());
        Espresso.onView(withId(R.id.button_0)).perform(ViewActions.click());
        Espresso.onView(withId(R.id.button_equal)).perform(ViewActions.click());

        // Assert that the error message is displayed (adjust the matcher as needed)
        Espresso.onView(withId(R.id.resultTextView)).check(ViewAssertions.matches(withText("Error")));
    }

    @Test
    public void clearButton_shouldResetCalculator() {
        Espresso.onView(withId(R.id.button_1)).perform(ViewActions.click());
        Espresso.onView(withId(R.id.button_2)).perform(ViewActions.click());
        Espresso.onView(withId(R.id.button_clear)).perform(ViewActions.click());

        Espresso.onView(withId(R.id.resultTextView)).check(ViewAssertions.matches(withText("0")));
    }

    @Test
    public void changeSign_shouldChangeSign() {
        Espresso.onView(withId(R.id.button_5)).perform(ViewActions.click());
        Espresso.onView(withId(R.id.button_change_sign)).perform(ViewActions.click());

        Espresso.onView(withId(R.id.resultTextView)).check(ViewAssertions.matches(withText("-5.0")));
    }


}