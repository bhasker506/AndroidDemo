package com.mytaxi.pages;

import android.view.View;
import org.hamcrest.Matcher;
import com.mytaxi.android_demo.R;
import com.mytaxi.android_demo.activities.MainActivity;
import com.mytaxi.utils.Utilites;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class Login {

    MainActivity activity = null;
    Matcher<View> userNameMatcher = withId(R.id.edt_username);
    Matcher<View> passwdMatcher = withId(R.id.edt_password);
    Matcher<View> loginBTNMatcher = withId(R.id.btn_login);

    public Login(MainActivity activity) {
        this.activity = activity;
    }

    public Login login(String userName, String password) {
        Utilites.waitForDisplay(this.userNameMatcher, 10000);
        onView(this.userNameMatcher).perform(typeText(userName));
        Utilites.waitForDisplay(this.passwdMatcher, 10000);
        onView(this.passwdMatcher).perform(typeText(password));
        Utilites.waitForDisplay(this.loginBTNMatcher, 10000);
        onView(this.loginBTNMatcher).perform(click());
        return this;
    }

    public DriverSearch driverSearch(){
        return new DriverSearch(this.activity);
    }
}
