package com.thedeveloperworldisyours.dagger2espresso;

import android.os.SystemClock;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;

import com.thedeveloperworldisyours.dagger2espresso.ui.LoginActivity;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;

/**
 * Created by javierg on 06/07/16.
 */
public class LoginTest {
    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule = new ActivityTestRule(LoginActivity.class);

    @Test
    public void checkEmptyUser() {
        onView(ViewMatchers.withId(R.id.activity_login_button))
                .perform(ViewActions.click());

        onView(ViewMatchers.withId(R.id.activity_login_username))
                .check(ViewAssertions.matches(ErrorTextMatchers.withErrorText(R.string.activity_login_username_error)));
    }

    @Test
    public void checkEmptyPassword() {
        onView(ViewMatchers.withId(R.id.activity_login_button))
                .perform(ViewActions.click());

        onView(ViewMatchers.withId(R.id.activity_login_password))
                .check(ViewAssertions.matches(ErrorTextMatchers.withErrorText(R.string.activity_login_password_error)));
    }

    @Test
    public void checkVisibleProgressBar() {
        onView(ViewMatchers.withId(R.id.activity_login_username))
                .perform(ViewActions.typeText("Cabezas"));
        SystemClock.sleep(100);
        onView(ViewMatchers.withId(R.id.activity_login_password))
                .perform(ViewActions.typeText("dfdsfdsdfasf"));
        SystemClock.sleep(1000);
        onView(ViewMatchers.withId(R.id.activity_login_button))
                .perform(ViewActions.click());
        SystemClock.sleep(3000);
        onView(ViewMatchers.withId(R.id.activity_login_progress))
                .check(doesNotExist());
    }
}
