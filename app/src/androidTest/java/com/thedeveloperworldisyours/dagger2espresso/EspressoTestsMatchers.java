package com.thedeveloperworldisyours.dagger2espresso;

import android.view.View;

import org.hamcrest.Matcher;

/**
 * Created by javierg on 06/07/16.
 */
public class EspressoTestsMatchers {
    public static Matcher<View> withDrawable(final int resourceId) {
        return new DrawableMatcher(resourceId);
    }

    public static Matcher<View> noDrawable() {
        return new DrawableMatcher(-1);
    }
}
