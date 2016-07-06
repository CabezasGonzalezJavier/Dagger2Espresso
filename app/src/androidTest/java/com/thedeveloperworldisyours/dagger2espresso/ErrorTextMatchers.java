package com.thedeveloperworldisyours.dagger2espresso;

import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.view.View;
import android.widget.TextView;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

/**
 * Created by javierg on 06/07/16.
 */
public class ErrorTextMatchers {
    private ErrorTextMatchers() {
        // do not instance
    }

    @NonNull
    public static Matcher<View> withErrorText(final String text) {
        return withErrorText(Matchers.is(text));
    }

    @NonNull
    private static Matcher<View> withErrorText(final Matcher<String> stringMatcher) {
        return new BoundedMatcher<View, TextView>(TextView.class) {

            @Override
            public void describeTo(Description description) {
                description.appendText("with error text:");
                stringMatcher.describeTo(description);
            }

            @Override
            protected boolean matchesSafely(TextView item) {
                return stringMatcher.matches(item.getError().toString());
            }
        };
    }

    @NonNull
    public static Matcher<View> withErrorText(@StringRes final int resourceId) {
        return new BoundedMatcher<View, TextView>(TextView.class) {
            private String resourceName = null;
            private String expectedText = null;

            @Override
            public void describeTo(Description description) {
                description.appendText("with error text from resource id: ");
                description.appendValue(resourceId);
                if (null != resourceName) {
                    description.appendText("[");
                    description.appendText(resourceName);
                    description.appendText("]");
                }
                if (null != expectedText) {
                    description.appendText(" value: ");
                    description.appendText(expectedText);
                }
            }

            @Override
            protected boolean matchesSafely(TextView item) {
                if (null == expectedText) {
                    try {
                        expectedText = item.getResources().getString(resourceId);
                        resourceName = item.getResources().getResourceEntryName(resourceId);
                    } catch (Resources.NotFoundException ignored) {
                        // view could be from a context unaware of the resource id
                    }
                }
                return null != expectedText && expectedText.equals(item.getError());
            }
        };
    }
}
