package ru.iteco.fmhandroid.ui.pageObject;

import static androidx.core.view.ViewKt.isVisible;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.isNotClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isNotEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;

import static ru.iteco.fmhandroid.ui.data.Helper.waitId;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.ViewAssertion;
import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class MainPage {
    private static final ViewInteraction mainPageText = onView(withId(R.id.all_news_text_view));
    private static int mainPageTextID = R.id.all_news_text_view;
    private static final ViewInteraction appMainMenuButton = onView(withId(R.id.main_menu_image_button));

    private static final ViewInteraction appMenuItemMain = onView(withText("Main"));
    private static final ViewInteraction appMenuItemNews= onView(withText("News"));
    private static final ViewInteraction appMenuItemAbout = onView(withText("About"));
    private static final ViewInteraction ourMissionIcon = onView(withId(R.id.our_mission_image_button));
    private static final ViewInteraction showAllNews = onView((allOf(withId(R.id.all_news_text_view), withText("ALL NEWS"))));

//    public void checkVisibilityOfMainPage() throws InterruptedException {
//        for (int i = 0; i < 10; i++) {
//            try {
//                onView(withId(R.id.all_news_text_view)).check(matches(isDisplayed()));
//                break;
//            } catch (NoMatchingViewException e) {
//                Thread.sleep(5000);
//                // ПЕРЕПИСАТЬ ЗАДЕРЖКУ В НОРМАЛЬНОМ ВИДЕ, ИЗ-ЗА ЕЕ ОТСУТСТВИЯ НЕ УСПЕВАЕТ ПРОГРУЗИТЬСЯ ЭЛЕМЕНТ
//            }
//        }
//    }

    public void checkVisibilityOfMainPage() {
        onView(isRoot()).perform(waitId((mainPageTextID), 10000));
    }

    public void clickAppMenuBar() {
        appMainMenuButton.perform(click());
    }

    public void checkVisibilityOfAppMenuBarItems() {
        appMenuItemMain.check(matches(isDisplayed()));
        appMenuItemNews.check(matches(isDisplayed()));
        appMenuItemAbout.check(matches(isDisplayed()));
    }

    public void clickAboutItem() {
        appMenuItemAbout.perform(click());
    }

    public void clickNewsItem() {
        appMenuItemNews.perform(click());
    }

    public void clickOurMissionIcon() {
        ourMissionIcon.perform(click());
    }
    public void clickShowAllNews() {
        showAllNews.perform(click());
    }


}

//onView(isRoot()).perform(waitId((mainPageTextID), 10000));
