package ru.iteco.fmhandroid.ui.pageObject;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
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
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.RootMatchers;
import androidx.test.espresso.matcher.ViewMatchers;

import org.hamcrest.Matcher;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.Data;
import ru.iteco.fmhandroid.ui.data.Helper;

public class NewsPage {
    public View decorView;
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
    private static final ViewInteraction postDescr = onView(withId(R.id.news_item_description_text_view));
    public static int postDescrId = R.id.news_item_description_text_view;
    public static int postDescrButtonId = R.id.view_news_item_image_view;
    private static final ViewInteraction postDescrButton = onView(withId(R.id.view_news_item_image_view));
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
    private static final Matcher<View> deletingNewsButton = allOf(withId(R.id.delete_news_item_image_view), withContentDescription("News delete button"));
    public static final String editButtonPostContentDescription = "News editing button";
    public static ViewInteraction cancelAlertDialog = onView(withId(android.R.id.button2));
    public static ViewInteraction okAlertDialog = onView(allOf(withId(android.R.id.button1), withText("OK")));
    public static final ViewInteraction popupCategoryMenu = onView(
            allOf(
                    withId(com.google.android.material.R.id.text_input_end_icon),
                    withContentDescription("Show dropdown menu")));


    public void checkVisibilityOfNewsPage() {
        Allure.step("Проверка видимости страницы NewPage");
        onView(isRoot()).perform(waitId((sortNewsButtonID), 10000));
    }

    public void clickEditNewsButton() {
        Allure.step("Нажатие кнопки редактирования новости");
        editNewsButton.perform(click());
    }


    public void checkVisibilityOfCreatingNewsWindow() {
        Allure.step("Проверка видимости страницы создания новой новости");
        onView(isRoot()).perform(waitId((topPartOfCreatingNewsTitleID), 10000));

    }


    public void checkVisibilityOfEditingNewsWindow() {
        Allure.step("Проверка видимости страницы редактирования новости");
        onView(isRoot()).perform(waitId((topPartOfEditingNewsTitleID), 10000));
    }

    public void checkVisibilityOfControlPanel() {
        Allure.step("Проверка видимости страницы Control Panel");
        onView(isRoot()).perform(waitId((addNewsButtonID), 10000));
    }

    public void clickAddNewsButton() {
        Allure.step("Нажатие кнопки создания новости");
        addNewsButton.perform(click());
    }

    public void clickSortNewsButton() {
        Allure.step("Нажатие кнопки сортировки новостей");
        sortNewsButton.perform(click());
    }

    public void clickFilterNewsButton() {
        Allure.step("Нажатие кнопки фильтрации новостей");
        filterNewsButton.perform(click());
    }

    public void clickFilterButton() {
        Allure.step("Нажатие кнопки применить фильтрацию");
        filterButton.perform(click());
    }

    public void clickPopupCategoriList() {
        Allure.step("Нажатие кнопки для выпадающего списка с категориями");
        popupCategoryMenu.perform(click());
    }

    public void setNewsCategory(String category) {
        Allure.step("Ввод категории новости");
        categoryField.check(matches(isDisplayed())).perform(replaceText(category), closeSoftKeyboard());
    }

    public void setPostRandomCategoryWithPopupList(String randCat) {
        Allure.step("Ввод случайной категории из выпадающего списка");
        clickPopupCategoriList();
        //для работы со всплывающими окнами/списками!!!
        onView(withText(randCat))
                .inRoot(RootMatchers.isPlatformPopup())
                .perform(click());
    }

    public void setNewsTitle(String title) {
        Allure.step("Ввод заголовка новости");
        titleField.check(matches(isDisplayed())).perform(replaceText(title), closeSoftKeyboard());
    }

    public void setNewsDescription(String description) {
        Allure.step("Ввод описания новости");
        descriptionField.check(matches(isDisplayed())).perform(replaceText(description), closeSoftKeyboard());
    }

    public static void setPublicationDate(int days) {
        Allure.step("Ввод даты публикации новости");
        publicationDateField.check(matches(isDisplayed())).perform(replaceText(Data.creatingPublicationDate(days)), closeSoftKeyboard());
    }

    public void setPublicationTime(int hours) {
        Allure.step("Ввод времени публицации новости");
        publicationTimeField.check(matches(isDisplayed())).perform(replaceText(Data.creatingPublicationTime(hours)), closeSoftKeyboard());
    }

    public String setPublicationDateStart(int days) {
        return Data.creatingPublicationDate(days);
    }

    public String setPublicationDateEnd(int days) {
        return Data.creatingPublicationDate(days);
    }

    public void clickSaveNewPostButton() {
        Allure.step("Нажатие кнопки сохранения новой новости");
        saveButton.perform(click());
    }

    public void clickCancelNewPostButton() {
        Allure.step("Нажатие кнопки отмены создания новой новости");
        cancelButton.perform(click());
    }

    public void changeSwitcherPosition() {
        Allure.step("Изменение состояния новости Active / Not active");
        switcherActivity.perform(click());
    }

    public int countAmountOfNewsElements() {
        Allure.step("Подсчет количества отображаемых новостей в RecyclerView");
        return Helper.getRecyclerViewItemCount(R.id.news_list_recycler_view);
    }

    public void searchingNewPostTitle(String neededTitle) {
        Allure.step("Поиск новой опубликованной новости по заголовку");
        newsRecyclerView.check(matches(isDisplayed()))
                .perform(RecyclerViewActions.scrollTo(hasDescendant(withText(neededTitle))));
    }

    public void checkNewPostCategory(String category) {
        Allure.step("Проверка на соответствие категории '" + category + "' новости");
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
        Allure.step("Получение даты создания новости");
        scrollToItem(recyclerViewPos);
        return Helper.getTextFromNews(fieldID, recyclerViewPos);
    }

    public void scrollToItem(int position) {
        Allure.step("Скролить список новостей до элемента на позиции " + position);
        onView(withId(newsRecyclerViewID)).perform(scrollToPosition(position));
    }

    public void checkVisibilityOfFilterNewslPanel() {
        Allure.step("Проверка видимости Filter News Panel");
        onView(isRoot()).perform(waitId((filterNewsHeaderID), 10000));
    }

    public void setPublicationDateStartFilter(String startDate) {
        Allure.step("Ввод начальной даты интервала публикации новости");
        publicationDateStartField.check(matches(isDisplayed()))
                .perform(replaceText(startDate), closeSoftKeyboard());
    }

    public void setPublicationDateEndFilter(String endDate) {
        Allure.step("Ввод конечной даты интервала публикации новости");
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

    public int checkPositionWithDescription(String expectedString, @IdRes int recyclerViewId, int viewingNewsFieldId) {
        Allure.step("Проверить, что все элементы в списке новостей в поле: " + expectedString);
        int counterPosition = 0;
        for (int i = 0; i < Helper.getRecyclerViewItemCount(recyclerViewId); i++) {
            scrollToNewsItem(i);
            String actualStatus = Helper.getTextFromNews(viewingNewsFieldId, i);
            if (expectedString.contains(actualStatus)) {
                counterPosition = i;
                break;
            }

        }
        System.out.println("COUNTER_POSITION = " + counterPosition);
        return counterPosition;
    }

    public void checkPostDescription(@IdRes int descrFieldId, int position, String expectedString) {
        Allure.step("Проверить, что описание новости соответствует : " + expectedString);
        scrollToNewsItem(position);
        String actualDescr = Helper.getTextFromNews(descrFieldId, position);
        assertEquals("Ожидается текст в поле '" + expectedString,
                expectedString, actualDescr);
    }

    public void checkPostStatus(@IdRes int statusFieldId, int position, String expectedString) {
        Allure.step("Проверить, что описание новости соответствует : " + expectedString);
        scrollToNewsItem(position);
        String actualDescr = Helper.getTextFromNews(statusFieldId, position);
        assertEquals("Ожидается текст в поле '" + expectedString,
                expectedString, actualDescr);
    }


    public void scrollToNewsItem(int position) {
        Allure.step("Прокручиваем к элементу новостей с позицией: " + position);
        newsRecyclerView.perform(scrollToPosition(position))
                .perform(actionOnItemAtPosition(position, scrollTo()))
                .check(matches(isDisplayed()));
    }

    public void filterWithWrongDateErrorMesDisplay() {
        Allure.step("Отображение ошибки фильтрации по дате");
        onView(withText(R.string.wrong_news_date_period)).check(matches(isDisplayed()));
    }

    public void clickNotActiveCheckboxFilter() {
        Allure.step("Изменить состояние чекбокса статуса новости Active");
        notActiveNewsCheckboxFilter.perform(click());
    }

    public void clickActiveCheckboxFilter() {
        Allure.step("Изменить состояние чекбокса статуса новости Not active");
        activeNewsCheckboxFilter.perform(click());
    }


    public void clickEditButton(String title) {
        Allure.step("Нажатие кнопки редактирования новости");
        onView(allOf(changingNewsButton, hasSibling(withText(title)))).perform(click());
    }

    public void clickDeleteButton(String title) {
        Allure.step("Нажатие кнопки удаления новости");
        onView(allOf(deletingNewsButton, hasSibling(withText(title)))).perform(click());
    }

    public void clickOkInAlertDialog() {
        Allure.step("Нажатие кнопки Ok в предупреждждающем сообщении");
        okAlertDialog.perform(click());
    }

    public void clickCancelInAlertDialog() {
        Allure.step("Нажатие кнопки Cancel в предупреждждающем сообщении");
        cancelAlertDialog.perform(click());
    }

    public void checkTitleInEditingMode(String title) {
        Allure.step("Проверка заголовка на соответствие тексту " + title);
        titleField.check(matches(withText(title)));
    }

    public void checkDescriptionInEditingMode(String descr) {
        Allure.step("Проверка описания новости на соответствие тексту " + descr);
        descriptionField.check(matches(withText(descr)));
    }

    public void checkDateInEditingMode(String date) {
        Allure.step("Проверка даты публикации новости на соответствие дате " + date);
        publicationDateField.check(matches(withText(date)));
    }

    public void checkSwitcherInEditingMode(String text) {
        Allure.step("Проверка статуса новости на соответствие тексту " + text);
        switcherActivity.check(matches(withText(text)));
    }

    public void checkPostDoesNotExist(String title) {
        Allure.step("Проверка отсутствия по заголовку новости после удаления " + title);
        onView(allOf(withText(title))).check(doesNotExist());
    }

    public void checkErrorMessage() {
        Allure.step("Cообщение об ошибке при попытке создать новость с незаполненными полями");
        onView(withText(Data.popupErrorMessage));
    }

    public void checkCategoryErrorMessage() {
        Allure.step("Cообщение об ошибке при попытке создать новость с некорректной категорией");
        onView(withText(Data.popupCategoryErrorMessage));
    }

}
