package com.mytaxi.pages;

import android.view.View;
import org.hamcrest.Matcher;
import com.mytaxi.android_demo.R;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import com.mytaxi.android_demo.activities.MainActivity;
import com.mytaxi.utils.Utilites;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class DriverSearch {

    MainActivity activity = null;
    Matcher<View> textSearchBar = withId(R.id.textSearch);

    public DriverSearch(MainActivity activity) {
        this.activity = activity;
    }

    public DriverSearch searchDriver(String driverName) {
        Utilites.waitForDisplay(this.textSearchBar, 10000);
        onView(textSearchBar).perform(typeText(driverName), closeSoftKeyboard());
        return this;
    }

    public DriverProfile selectDriver(String driverName) {
        onView(withText(driverName))
                .inRoot(withDecorView(not(is(this.activity.getWindow().getDecorView()))))
                .perform(click());
        return new DriverProfile(this.activity);
    }
}
