package com.tickloop.t33d;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.*;

@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

    @Rule
    public ActivityScenarioRule<LoginActivity> rule = new ActivityScenarioRule<>(LoginActivity.class);


    @Test
    public void test_isLoginActivityInView() {

        onView(withId(R.id.main)).check(matches(isDisplayed()));
    }

    @Test
    public void test_isLoginButtonVisible() {

        onView(withId(R.id.login_button)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
    }

    @Test
    public void test_isLoginSuccess() {
        String username = "mr";
        Integer password = 1234;
        onView(withId(R.id.username)).perform(ViewActions.typeText(username));
        onView(withId(R.id.password)).perform(ViewActions.typeText(password.toString()));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.login_button)).perform(click());
    }
}