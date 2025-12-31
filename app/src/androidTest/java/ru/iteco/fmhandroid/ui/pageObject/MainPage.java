package ru.iteco.fmhandroid.ui.pageObject;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.data.Helper.waitId;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;

public class MainPage {
    private static final ViewInteraction mainPageText = onView(withId(R.id.all_news_text_view));
    private static int mainPageTextID = R.id.all_news_text_view;
    private static final ViewInteraction appMainMenuButton = onView(withId(R.id.main_menu_image_button));

    private static final ViewInteraction appMenuItemMain = onView(withText("Main"));
    private static final ViewInteraction appMenuItemNews = onView(withText("News"));
    private static final ViewInteraction appMenuItemAbout = onView(withText("About"));
    private static final ViewInteraction ourMissionIcon = onView(withId(R.id.our_mission_image_button));
    private static final ViewInteraction showAllNews = onView((allOf(withId(R.id.all_news_text_view), withText("ALL NEWS"))));

    public void checkVisibilityOfMainPage() {
        Allure.step("Проверка видимости MainPage");
        onView(isRoot()).perform(waitId((mainPageTextID), 10000));
    }

    public void clickAppMenuBar() {
        Allure.step("Нажатие на AppBar");
        appMainMenuButton.perform(click());
    }

    public void checkVisibilityOfAppMenuBarItems() {
        Allure.step("Проверка видимости элементов AppMenu");
        appMenuItemMain.check(matches(isDisplayed()));
        appMenuItemNews.check(matches(isDisplayed()));
        appMenuItemAbout.check(matches(isDisplayed()));
    }

    public void clickAboutItem() {
        Allure.step("Нажатие на кнопку перехода в раздел About");
        appMenuItemAbout.perform(click());
    }

    public void clickNewsItem() {
        Allure.step("Нажатие на кнопку перехода в раздел News");
        appMenuItemNews.perform(click());
    }

    public void clickOurMissionIcon() {
        Allure.step("Нажатие на кнопку перехода в раздел с цитатами");
        ourMissionIcon.perform(click());
    }

    public void clickShowAllNews() {
        Allure.step("Нажатие на кнопку перехода в раздел News чреез ALL NEWS");
        showAllNews.perform(click());
    }
}

