package com.mytaxi.pages;

import android.view.View;
import org.hamcrest.Matcher;
import com.mytaxi.android_demo.R;
import com.mytaxi.utils.Utilites;
import com.mytaxi.android_demo.activities.MainActivity;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class DriverProfile {

    MainActivity activity = null;

    Matcher<View> callButton = withId(R.id.fab);

    public DriverProfile(MainActivity activity) {
        this.activity = activity;
    }

    public void call() {
        Utilites.waitForDisplay(this.callButton, 10000);
        onView(callButton).perform(click());
    }
}
