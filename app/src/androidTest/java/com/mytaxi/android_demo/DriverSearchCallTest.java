package com.mytaxi.android_demo;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import com.mytaxi.android_demo.activities.MainActivity;
import com.mytaxi.pages.Login;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class DriverSearchCallTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityRule = new ActivityTestRule<>(MainActivity.class);
    private MainActivity mainActivity = null;
    private Login login = null;

    @Before
    public void beforeTest(){
        mainActivity = mainActivityRule.getActivity();
    }

    @Test
    public void testDriverCall() throws Exception{
        login = new Login(mainActivity);
        login.login("crazydog335","venture")
                .driverSearch().searchDriver("sa").selectDriver("Sarah Scott").
                call();
    }
}
