package com.thedeveloperworldisyours.dagger2espresso;

import android.os.SystemClock;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;

import com.thedeveloperworldisyours.dagger2espresso.ui.MainActivity;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by javierg on 06/07/16.
 */
public class MainTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void checkSucessfulImage() {
        onView(withId(R.id.activity_main_image_view))
                .check(matches(EspressoTestsMatchers.noDrawable()));
        onView(ViewMatchers.withId(R.id.activity_main_button))
                .perform(ViewActions.click());
        SystemClock.sleep(3000);
        onView(withId(R.id.activity_main_image_view))
                .check(matches(isDisplayed()));
    }
}
