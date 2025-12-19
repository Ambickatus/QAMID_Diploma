package ru.iteco.fmhandroid.ui.test;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.pageObject.AboutPage;
import ru.iteco.fmhandroid.ui.pageObject.AuthorizationPage;
import ru.iteco.fmhandroid.ui.pageObject.MainPage;
import ru.iteco.fmhandroid.ui.pageObject.NewsPage;
import ru.iteco.fmhandroid.ui.pageObject.OurMissionPage;

@RunWith(AllureAndroidJUnit4.class)
public class OurMissionPageTest {
    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule  =
            new ActivityScenarioRule<>(AppActivity.class);

    AuthorizationPage authorizationPage = new AuthorizationPage();
    MainPage mainPage = new MainPage();
    NewsPage newsPage = new NewsPage();
    OurMissionPage ourMissionPage = new OurMissionPage();

    @Before
    public void setUp() {
        try {
            authorizationPage.signInButtonCheckVisibility();
        } catch (Exception e) {
            authorizationPage.logOutFromProfile();
        }
    }

//    @DisplayName("123")
//    @Test
//    public void registeredUserAuth() {
//        authorizationPage.signInButtonCheckVisibility();
//        authorizationPage.succefullAuthorization();
//        mainPage.checkVisibilityOfMainPage();
//    }
}
