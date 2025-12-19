package ru.iteco.fmhandroid.ui.pageObject;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.data.Helper.waitId;

import android.view.View;

import androidx.test.espresso.ViewAction;
import androidx.test.espresso.ViewInteraction;

import org.hamcrest.Matchers;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.Data;

public class AuthorizationPage {
    private static ViewInteraction authHeader = onView(withText("Authorization"));
    private static ViewInteraction loginField = onView((allOf(withHint("Login"), isDescendantOfA(withId(R.id.login_text_input_layout)))));
    private static ViewInteraction passwordField = onView((allOf(withHint("Password"), isDescendantOfA(withId(R.id.password_text_input_layout)))));
    private static int signInButtonID = R.id.enter_button;
    private static ViewInteraction signInButton = onView(withId(R.id.enter_button));
    private static ViewInteraction profileIcon = onView(withId(R.id.authorization_image_button));
    private static ViewInteraction logOutButton = onView(withText("Log out"));
    private View decorView;

    public void signInButtonCheckVisibility() {
        onView(isRoot()).perform(waitId((signInButtonID), 10000));
    }


    public void logOutFromProfile() {
        profileIcon.perform(click());
        logOutButton.perform(click());

    }

    public void succefullAuthorization()
    {
        loginField.check(matches(isDisplayed())).perform(typeText(Data.validLogin), closeSoftKeyboard());
        passwordField.check(matches(isDisplayed())).perform(typeText(Data.validPassword), closeSoftKeyboard());
        signInButton.perform(click());
    }




    public void failAuthorizationWithWrongLogin()
    {
        loginField.perform(typeText(Data.nonValidLogin), closeSoftKeyboard());
        passwordField.perform(typeText(Data.validPassword), closeSoftKeyboard());
        signInButton.perform(click());
    }

    public void failAuthorizationWithWrongPassword()
    {
        loginField.perform(typeText(Data.validLogin), closeSoftKeyboard());
        passwordField.perform(typeText(Data.nonValidPassword), closeSoftKeyboard());
        signInButton.perform(click());
    }

    public void failAuthorizationWithEmptyFields()
    {
        signInButton.perform(click());
    }

    public void authErrorMesDisplay() {
        onView(withText(R.string.error));
    }



}
