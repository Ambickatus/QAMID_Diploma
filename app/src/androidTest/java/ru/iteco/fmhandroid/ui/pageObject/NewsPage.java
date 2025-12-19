package ru.iteco.fmhandroid.ui.pageObject;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItem;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.contrib.RecyclerViewActions.scrollToPosition;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.hasSibling;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertEquals;
import static ru.iteco.fmhandroid.ui.data.Helper.waitId;

import android.view.View;

import androidx.annotation.IdRes;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;

import org.hamcrest.Matcher;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.Data;
import ru.iteco.fmhandroid.ui.data.Helper;

public class NewsPage {
    private static final ViewInteraction sortNewsButton = onView(withId(R.id.sort_news_material_button));
    private static final ViewInteraction filterNewsButton = onView(withId(R.id.filter_news_material_button));
    private static final ViewInteraction editNewsButton = onView(withId(R.id.edit_news_material_button));
    private static final ViewInteraction addNewsButton = onView(withId(R.id.add_news_image_view));
    private static int sortNewsButtonID = R.id.sort_news_material_button;
    private static int filterNewsButtonID = R.id.filter_news_material_button;
    private static int editNewsButtonID = R.id.edit_news_material_button;
    private static int addNewsButtonID = R.id.add_news_image_view;
    /// ////////////////////////////////////////////////////
    private static final ViewInteraction topPartOfCreatingNewsTitle = onView(withId(R.id.custom_app_bar_title_text_view));
    private static final ViewInteraction bottomPartOfCreatingNewsTitle = onView(withId(R.id.custom_app_bar_sub_title_text_view));
    private static int topPartOfCreatingNewsTitleID = R.id.custom_app_bar_title_text_view;
    private static int topPartOfEditingNewsTitleID = R.id.custom_app_bar_title_text_view;
    private static int bottomPartOfCreatingNewsTitleID = R.id.news_item_category_text_auto_complete_text_view;
    private static final ViewInteraction categoryField = onView(withId(R.id.news_item_category_text_auto_complete_text_view));
    private static final ViewInteraction titleField = onView(withId(R.id.news_item_title_text_input_edit_text));
    private static final ViewInteraction publicationDateField = onView(withId(R.id.news_item_publish_date_text_input_edit_text));
    public static int publicationDateFieldID = R.id.news_item_publication_date_text_view;
    private static final ViewInteraction publicationTimeField = onView(withId(R.id.news_item_publish_time_text_input_edit_text));
    private static final ViewInteraction descriptionField = onView(withId(R.id.news_item_description_text_input_edit_text));
    private static final ViewInteraction switcherActivity = onView(withId(R.id.switcher));
    private static final ViewInteraction saveButton = onView(withId(R.id.save_button));
    private static final ViewInteraction cancelButton = onView(withId(R.id.cancel_button));
    public static final ViewInteraction newsRecyclerView = onView(withId(R.id.news_list_recycler_view));
    public static final int newsRecyclerViewID = R.id.news_list_recycler_view;
    public static final int filterNewsHeaderID = R.id.filter_news_title_text_view;
    public static final ViewInteraction categoryFieldInFilterNews = onView(withId(R.id.news_item_category_text_auto_complete_text_view));
    public static final int newsStatusId = R.id.news_item_published_text_view;
    public static final int publicationDateId = R.id.news_item_publication_date_text_view;
    public static final int creationDateId = R.id.news_item_creation_text_view;
    public static final ViewInteraction filterButton = onView(withId(R.id.filter_button));
    public static final int imageCategoryFieldId = R.id.category_icon_image_view;
    public static final ViewInteraction publicationDateStartField = onView(withId(R.id.news_item_publish_date_start_text_input_edit_text));
    public static final ViewInteraction publicationDateEndField = onView(withId(R.id.news_item_publish_date_end_text_input_edit_text));
    public static final ViewInteraction notActiveNewsCheckboxFilter = onView(withId(R.id.filter_news_inactive_material_check_box));
    public static final ViewInteraction activeNewsCheckboxFilter = onView(withId(R.id.filter_news_active_material_check_box));
    private static final Matcher<View> changingNewsButton = allOf(withId(R.id.edit_news_item_image_view), withContentDescription("News editing button"));
    public static final String editButtonPostContentDescription = "News editing button";


    public void checkVisibilityOfNewsPage() {
        onView(isRoot()).perform(waitId((sortNewsButtonID), 10000));
    }

    public void clickEditNewsButton() {
        editNewsButton.perform(click());
    }


    public void checkVisibilityOfCreatingNewsWindow() {
        onView(isRoot()).perform(waitId((topPartOfCreatingNewsTitleID), 10000));

    }

    public void checkVisibilityOfCreatingNewsWindow111() {
        onView(isRoot()).perform(waitId((bottomPartOfCreatingNewsTitleID), 10000));

    }

    public void checkVisibilityOfEditingNewsWindow() {
        onView(isRoot()).perform(waitId((topPartOfEditingNewsTitleID), 10000));

    }

    public void checkVisibilityOfControlPanel() {
        onView(isRoot()).perform(waitId((addNewsButtonID), 10000));
    }

    public void clickAddNewsButton() {
        addNewsButton.perform(click());
    }
    public void clickSortNewsButton() {
        sortNewsButton.perform(click());
    }
    public void clickFilterNewsButton() {
        filterNewsButton.perform(click());
    }
    public void clickFilterButton() {
        filterButton.perform(click());
    }

    public void setNewsCategory(String category) {
        categoryField.check(matches(isDisplayed())).perform(replaceText(category), closeSoftKeyboard());
    }

    public void setNewsTitle(String title) {
        titleField.check(matches(isDisplayed())).perform(replaceText(title), closeSoftKeyboard());
    }

    public void setNewsDescription() {
        descriptionField.check(matches(isDisplayed())).perform(replaceText(Data.creatingPublicationDescription()), closeSoftKeyboard());
    }

    public static void setPublicationDate(int days) {
        publicationDateField.check(matches(isDisplayed())).perform(replaceText(Data.creatingPublicationDate(days)), closeSoftKeyboard());
    }

    public void setPublicationTime(int hours) {
        publicationTimeField.check(matches(isDisplayed())).perform(replaceText(Data.creatingPublicationTime(hours)), closeSoftKeyboard());
    }

    public String setPublicationDateStart(int days) {
        return Data.creatingPublicationDate(days);
    }

    public String setPublicationDateEnd(int days) {
        return Data.creatingPublicationDate(days);
    }

    public void clickSaveNewPostButton() {
        saveButton.perform(click());
    }

    public void clickCancelNewPostButton() {
        cancelButton.perform(click());
    }

    public void changeSwitcherPosition() {
        switcherActivity.perform(click());
    }

    public int countAmountOfNewsElements() {
        return Helper.getRecyclerViewItemCount(R.id.news_list_recycler_view);
    }

    public void searchingNewPostTitle(String neededTitle) {
        newsRecyclerView.check(matches(isDisplayed()))
                .perform(RecyclerViewActions.scrollTo(hasDescendant(withText(neededTitle))));
    }

    public void checkNewPostCategory(String category) {
        categoryField.check(matches(isDisplayed()))
                .check(matches(withText(category)));
    }


    public void checkSearchResultIsDisplayed(String text) {
        Allure.step("Проверить элемент '" + text + "' на видимость");
        ViewInteraction titleView = onView(allOf(withText(text),
                withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        titleView.check(matches(isDisplayed()));
        titleView.check(matches(withText(containsString(text))));
    }

    public String getCreationDateOfThePost(int fieldID, int recyclerViewPos) {
        scrollToItem(recyclerViewPos);
        return Helper.getTextFromNews(fieldID, recyclerViewPos);
    }

    public void scrollToItem(int position) {
        Allure.step("Скролить список новостей до элемента на позиции " + position);
        onView(withId(newsRecyclerViewID)).perform(scrollToPosition(position));
    }

    public void checkVisibilityOfFilterNewslPanel() {
        onView(isRoot()).perform(waitId((filterNewsHeaderID), 10000));
    }

    public void setCategoryFilter(String category) {
        categoryFieldInFilterNews.check(matches(isDisplayed()))
                .perform(replaceText(category), closeSoftKeyboard());
    }

    public void setPublicationDateStartFilter(String startDate) {
        publicationDateStartField.check(matches(isDisplayed()))
                .perform(replaceText(startDate), closeSoftKeyboard());
    }
    public void setPublicationDateEndFilter(String endDate) {
        publicationDateEndField.check(matches(isDisplayed()))
                .perform(replaceText(endDate), closeSoftKeyboard());
    }

    public void checkAllNewsNeededField(String expectedString, @IdRes int recyclerViewId, int viewingNewsFieldId) {
        Allure.step("Проверить, что все элементы в списке новостей в поле: " + expectedString);
        for (int i = 0; i < Helper.getRecyclerViewItemCount(recyclerViewId); i++) {
            scrollToNewsItem(i);
            String actualStatus = Helper.getTextFromNews(viewingNewsFieldId, i);
            assertEquals("Ожидается текст в поле '" + expectedString + "' для элемента " + i,
                    expectedString, actualStatus);
        }
    }


    public void scrollToNewsItem(int position) {
        Allure.step("Прокручиваем к элементу новостей с позицией: " + position);
        newsRecyclerView.perform(scrollToPosition(position))
                .perform(actionOnItemAtPosition(position, scrollTo()))
                .check(matches(isDisplayed()));
    }

    public void filterWithWrongDateErrorMesDisplay() {
        onView(withText(R.string.wrong_news_date_period)).check(matches(isDisplayed()));
    }

    public void clickNotActiveCheckboxFilter() {
        notActiveNewsCheckboxFilter.perform(click());
    }

    public void clickActiveCheckboxFilter() {
        activeNewsCheckboxFilter.perform(click());
    }


    public void clickEditButton(String title) {
        onView(allOf(changingNewsButton, hasSibling(withText(title)))).perform(click());
    }

}
