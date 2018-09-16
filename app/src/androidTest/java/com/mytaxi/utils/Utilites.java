package com.mytaxi.utils;

import android.view.View;
import org.hamcrest.Matcher;
import junit.framework.AssertionFailedError;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;

public class Utilites {


    public static void waitForDisplay(Matcher<View> matcher, long timeoutinms){
        long endTs = System.currentTimeMillis()+timeoutinms;
        while(System.currentTimeMillis() < endTs) {
            try {
                onView(matcher).check(matches(isDisplayed()));
                return;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        throw new AssertionFailedError(matcher.toString()+": matcher is not displayed");
    }
}
