package ru.iteco.fmhandroid.ui.test;

import static org.junit.Assert.assertEquals;

import static ru.iteco.fmhandroid.ui.pageObject.NewsPage.newsRecyclerViewID;
import static ru.iteco.fmhandroid.ui.pageObject.NewsPage.newsStatusId;
import static ru.iteco.fmhandroid.ui.pageObject.NewsPage.publicationDateId;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.data.Data;
import ru.iteco.fmhandroid.ui.data.Helper;
import ru.iteco.fmhandroid.ui.pageObject.AboutPage;
import ru.iteco.fmhandroid.ui.pageObject.AuthorizationPage;
import ru.iteco.fmhandroid.ui.pageObject.MainPage;
import ru.iteco.fmhandroid.ui.pageObject.NewsPage;
import ru.iteco.fmhandroid.ui.pageObject.OurMissionPage;

@RunWith(AllureAndroidJUnit4.class)
public class NewsPageTest {
    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule  =
            new ActivityScenarioRule<>(AppActivity.class);

    AuthorizationPage authorizationPage = new AuthorizationPage();
    MainPage mainPage = new MainPage();
    NewsPage newsPage = new NewsPage();
    AboutPage aboutPage = new AboutPage();
    OurMissionPage ourMissionPage = new OurMissionPage();
    int elBeforeCreation, elAfterCreation = 0;
    String creatingNewPostTitle = Data.creatingRandomTitle();

    @Before
    public void setUp() {
        try {
            authorizationPage.signInButtonCheckVisibility();
        } catch (Exception e) {
            authorizationPage.logOutFromProfile();
        }
    }

    @DisplayName("Создание новой актуальной новости")
    @Test
    public void creatingNewActualPost()
    {
        authorizationPage.signInButtonCheckVisibility();
        authorizationPage.succefullAuthorization();
        mainPage.checkVisibilityOfMainPage();
        mainPage.clickShowAllNews();
        newsPage.checkVisibilityOfNewsPage();
        newsPage.clickEditNewsButton();
        newsPage.checkVisibilityOfControlPanel();
        newsPage.clickAddNewsButton();
        newsPage.checkVisibilityOfCreatingNewsWindow();
        newsPage.setNewsCategory(Data.profunoinCategory);
        newsPage.setNewsTitle(creatingNewPostTitle);
        newsPage.setPublicationDate(0);
        newsPage.setPublicationTime(-1);
        newsPage.setNewsDescription();
        newsPage.clickSaveNewPostButton();
        newsPage.checkVisibilityOfControlPanel();
        newsPage.searchingNewPostTitle(creatingNewPostTitle);
        newsPage.checkSearchResultIsDisplayed(creatingNewPostTitle);


    }

    @DisplayName("Создание новой новости для будущего")
    @Test
    public void creatingNewFuturePost()
    {
        authorizationPage.signInButtonCheckVisibility();
        authorizationPage.succefullAuthorization();
        mainPage.checkVisibilityOfMainPage();
        mainPage.clickShowAllNews();
        newsPage.checkVisibilityOfNewsPage();
        newsPage.clickEditNewsButton();
        newsPage.checkVisibilityOfControlPanel();
        newsPage.clickAddNewsButton();
        newsPage.checkVisibilityOfCreatingNewsWindow();
        newsPage.setNewsCategory(Data.profunoinCategory);
        newsPage.setNewsTitle(creatingNewPostTitle);
        newsPage.setPublicationDate(2);
        newsPage.setPublicationTime(0);
        newsPage.setNewsDescription();
        newsPage.clickSaveNewPostButton();
        newsPage.checkVisibilityOfControlPanel();
        newsPage.searchingNewPostTitle(creatingNewPostTitle);
        newsPage.checkSearchResultIsDisplayed(creatingNewPostTitle);


    }


    @DisplayName("Сортировка списка новостей")
    @Test
    public void sortingNewsList()
    {
        authorizationPage.signInButtonCheckVisibility();
        authorizationPage.succefullAuthorization();
        mainPage.checkVisibilityOfMainPage();
        mainPage.clickShowAllNews();
        newsPage.checkVisibilityOfNewsPage();
        newsPage.clickEditNewsButton();
        newsPage.checkVisibilityOfControlPanel();
        String firstPostCreationDateBefSort = newsPage.getCreationDateOfThePost(NewsPage.publicationDateFieldID, 0);
        String lastPostCreationDateBefSort = newsPage.
                getCreationDateOfThePost(NewsPage.publicationDateFieldID, (newsPage.countAmountOfNewsElements()-1));
        newsPage.clickSortNewsButton();
        String firstPostCreationDateAftSort = newsPage.getCreationDateOfThePost(NewsPage.publicationDateFieldID, 0);
        String lastPostCreationDateAftSort = newsPage.
                getCreationDateOfThePost(NewsPage.publicationDateFieldID, (newsPage.countAmountOfNewsElements()-1));
        assertEquals(firstPostCreationDateBefSort, lastPostCreationDateAftSort);
        assertEquals(lastPostCreationDateBefSort, firstPostCreationDateAftSort);
    }


//    @DisplayName("Фильтрация списка новостей по категории")
//    @Test
//    public void filteringNewsListWithCategory()
//    {
//        authorizationPage.signInButtonCheckVisibility();
//        authorizationPage.succefullAuthorization();
//        mainPage.checkVisibilityOfMainPage();
//        mainPage.clickShowAllNews();
//        newsPage.checkVisibilityOfNewsPage();
//        newsPage.clickEditNewsButton();
//        newsPage.checkVisibilityOfControlPanel();
//        newsPage.clickFilterNewsButton();
//        newsPage.checkVisibilityOfFilterNewslPanel();
//        String randomCategory = Helper.randomCategory();
//        newsPage.setCategoryFilter(randomCategory);
//        newsPage.clickFilterButton();
//        newsPage.checkAllNewsNeededField(randomCategory, NewsPage.newsRecyclerViewID, NewsPage.imageCategoryFieldId);
//        //не понятно как интегрировать R.raw определенной картинки для сопоставления наименования категории и картинки этой категории в тест
//
//
//    }

    @DisplayName("Фильтрация списка новостей по дате публикации")
    @Test
    public void filteringNewsListWithDate()
    {
        authorizationPage.signInButtonCheckVisibility();
        authorizationPage.succefullAuthorization();
        mainPage.checkVisibilityOfMainPage();
        mainPage.clickShowAllNews();
        newsPage.checkVisibilityOfNewsPage();
        newsPage.clickEditNewsButton();
        newsPage.checkVisibilityOfControlPanel();
        newsPage.clickAddNewsButton();
        newsPage.checkVisibilityOfCreatingNewsWindow();
        newsPage.setNewsCategory(Data.profunoinCategory);
        newsPage.setNewsTitle(creatingNewPostTitle);
        newsPage.setPublicationDate(1);
        newsPage.setPublicationTime(0);
        newsPage.setNewsDescription();
        newsPage.clickSaveNewPostButton();
        newsPage.checkVisibilityOfControlPanel();
        newsPage.searchingNewPostTitle(creatingNewPostTitle);
        newsPage.checkSearchResultIsDisplayed(creatingNewPostTitle);

        newsPage.clickFilterNewsButton();
        newsPage.checkVisibilityOfFilterNewslPanel();
        newsPage.setPublicationDateStartFilter(newsPage.setPublicationDateStart(1));
        newsPage.setPublicationDateEndFilter(newsPage.setPublicationDateEnd(1));
        newsPage.clickFilterButton();
        newsPage.checkAllNewsNeededField(newsPage.setPublicationDateStart(1), newsRecyclerViewID, publicationDateId);
    }

    @DisplayName("Попытка фильтрации списка новостей при заполнении только начала интервала дат")
    @Test
    public void filteringNewsListWithOnlyStartDate()
    {
        authorizationPage.signInButtonCheckVisibility();
        authorizationPage.succefullAuthorization();
        mainPage.checkVisibilityOfMainPage();
        mainPage.clickShowAllNews();
        newsPage.checkVisibilityOfNewsPage();
        newsPage.clickEditNewsButton();
        newsPage.checkVisibilityOfControlPanel();
        newsPage.clickAddNewsButton();
        newsPage.checkVisibilityOfCreatingNewsWindow();
        newsPage.setNewsCategory(Data.profunoinCategory);
        newsPage.setNewsTitle(creatingNewPostTitle);
        newsPage.setPublicationDate(1);
        newsPage.setPublicationTime(0);
        newsPage.setNewsDescription();
        newsPage.clickSaveNewPostButton();
        newsPage.checkVisibilityOfControlPanel();
        newsPage.searchingNewPostTitle(creatingNewPostTitle);
        newsPage.checkSearchResultIsDisplayed(creatingNewPostTitle);

        newsPage.clickFilterNewsButton();
        newsPage.checkVisibilityOfFilterNewslPanel();
        newsPage.setPublicationDateStartFilter(newsPage.setPublicationDateStart(1));
        newsPage.clickFilterButton();
        newsPage.filterWithWrongDateErrorMesDisplay();
    }

    @DisplayName("Попытка фильтрации списка новостей при заполнении только начала интервала дат")
    @Test
    public void filteringNewsListWithOnlyEndDate()
    {
        authorizationPage.signInButtonCheckVisibility();
        authorizationPage.succefullAuthorization();
        mainPage.checkVisibilityOfMainPage();
        mainPage.clickShowAllNews();
        newsPage.checkVisibilityOfNewsPage();
        newsPage.clickEditNewsButton();
        newsPage.checkVisibilityOfControlPanel();
        newsPage.clickAddNewsButton();
        newsPage.checkVisibilityOfCreatingNewsWindow();
        newsPage.setNewsCategory(Data.profunoinCategory);
        newsPage.setNewsTitle(creatingNewPostTitle);
        newsPage.setPublicationDate(1);
        newsPage.setPublicationTime(0);
        newsPage.setNewsDescription();
        newsPage.clickSaveNewPostButton();
        newsPage.checkVisibilityOfControlPanel();
        newsPage.searchingNewPostTitle(creatingNewPostTitle);
        newsPage.checkSearchResultIsDisplayed(creatingNewPostTitle);

        newsPage.clickFilterNewsButton();
        newsPage.checkVisibilityOfFilterNewslPanel();
        newsPage.setPublicationDateEndFilter(newsPage.setPublicationDateEnd(1));
        newsPage.clickFilterButton();
        newsPage.filterWithWrongDateErrorMesDisplay();
    }

    @DisplayName("Фильтрация активных новостей")
    @Test
    public void filteringActiveNewsList()
    {
        authorizationPage.signInButtonCheckVisibility();
        authorizationPage.succefullAuthorization();
        mainPage.checkVisibilityOfMainPage();
        mainPage.clickShowAllNews();
        newsPage.checkVisibilityOfNewsPage();
        newsPage.clickEditNewsButton();
        newsPage.checkVisibilityOfControlPanel();
        newsPage.clickAddNewsButton();
        newsPage.checkVisibilityOfCreatingNewsWindow();
        newsPage.setNewsCategory(Data.profunoinCategory);
        newsPage.setNewsTitle(creatingNewPostTitle);
        newsPage.setPublicationDate(1);
        newsPage.setPublicationTime(0);
        newsPage.setNewsDescription();
        newsPage.clickSaveNewPostButton();
        newsPage.checkVisibilityOfControlPanel();
        newsPage.searchingNewPostTitle(creatingNewPostTitle);
        newsPage.checkSearchResultIsDisplayed(creatingNewPostTitle);

        newsPage.clickEditButton(creatingNewPostTitle);
        newsPage.checkVisibilityOfEditingNewsWindow();
        newsPage.changeSwitcherPosition();
        newsPage.clickSaveNewPostButton();
        newsPage.checkVisibilityOfControlPanel();

        newsPage.clickFilterNewsButton();
        newsPage.checkVisibilityOfFilterNewslPanel();
        newsPage.clickNotActiveCheckboxFilter();
        newsPage.clickFilterButton();
        newsPage.checkVisibilityOfControlPanel();
        newsPage.checkAllNewsNeededField("Active", newsRecyclerViewID, newsStatusId);

    }

    @DisplayName("Фильтрация неактивных новостей")
    @Test
    public void filteringNonActiveNewsList()
    {
        authorizationPage.signInButtonCheckVisibility();
        authorizationPage.succefullAuthorization();
        mainPage.checkVisibilityOfMainPage();
        mainPage.clickShowAllNews();
        newsPage.checkVisibilityOfNewsPage();
        newsPage.clickEditNewsButton();
        newsPage.checkVisibilityOfControlPanel();
        newsPage.clickAddNewsButton();
        newsPage.checkVisibilityOfCreatingNewsWindow();
        newsPage.setNewsCategory(Data.profunoinCategory);
        newsPage.setNewsTitle(creatingNewPostTitle);
        newsPage.setPublicationDate(1);
        newsPage.setPublicationTime(0);
        newsPage.setNewsDescription();
        newsPage.clickSaveNewPostButton();
        newsPage.checkVisibilityOfControlPanel();
        newsPage.searchingNewPostTitle(creatingNewPostTitle);
        newsPage.checkSearchResultIsDisplayed(creatingNewPostTitle);

        newsPage.clickEditButton(creatingNewPostTitle);
        newsPage.checkVisibilityOfEditingNewsWindow();
        newsPage.changeSwitcherPosition();
        newsPage.clickSaveNewPostButton();
        newsPage.checkVisibilityOfControlPanel();

        newsPage.clickFilterNewsButton();
        newsPage.checkVisibilityOfFilterNewslPanel();
        newsPage.clickActiveCheckboxFilter();
        newsPage.clickFilterButton();
        newsPage.checkVisibilityOfControlPanel();
        newsPage.checkAllNewsNeededField("Not active", newsRecyclerViewID, newsStatusId);

    }

    @DisplayName("Фильтрация активных новостей по дате публикации и активному статусу")
    @Test
    public void filteringNewsListByPublicationDateAndStatus()
    {
        authorizationPage.signInButtonCheckVisibility();
        authorizationPage.succefullAuthorization();
        mainPage.checkVisibilityOfMainPage();
        mainPage.clickShowAllNews();
        newsPage.checkVisibilityOfNewsPage();
        newsPage.clickEditNewsButton();
        newsPage.checkVisibilityOfControlPanel();
        newsPage.clickAddNewsButton();
        newsPage.checkVisibilityOfCreatingNewsWindow();
        newsPage.setNewsCategory(Data.profunoinCategory);
        newsPage.setNewsTitle(creatingNewPostTitle);
        newsPage.setPublicationDate(1);
        newsPage.setPublicationTime(0);
        newsPage.setNewsDescription();
        newsPage.clickSaveNewPostButton();
        newsPage.checkVisibilityOfControlPanel();
        newsPage.searchingNewPostTitle(creatingNewPostTitle);
        newsPage.checkSearchResultIsDisplayed(creatingNewPostTitle);

        newsPage.clickEditButton(creatingNewPostTitle);
        newsPage.checkVisibilityOfEditingNewsWindow();
        newsPage.changeSwitcherPosition();
        newsPage.clickSaveNewPostButton();
        newsPage.checkVisibilityOfControlPanel();

        newsPage.clickFilterNewsButton();
        newsPage.checkVisibilityOfFilterNewslPanel();
        newsPage.setPublicationDateStartFilter(newsPage.setPublicationDateStart(1));
        newsPage.setPublicationDateEndFilter(newsPage.setPublicationDateEnd(1));
        newsPage.clickActiveCheckboxFilter();
        newsPage.clickFilterButton();
        newsPage.checkVisibilityOfControlPanel();
        newsPage.checkAllNewsNeededField("Not active", newsRecyclerViewID, newsStatusId);
        newsPage.checkAllNewsNeededField(newsPage.setPublicationDateStart(1), newsRecyclerViewID, publicationDateId);

    }

    @DisplayName("Редактирование категории новости")
    @Test
    public void editingNewsCategory()
    {
        authorizationPage.signInButtonCheckVisibility();
        authorizationPage.succefullAuthorization();
        mainPage.checkVisibilityOfMainPage();
        mainPage.clickShowAllNews();
        newsPage.checkVisibilityOfNewsPage();
        newsPage.clickEditNewsButton();
        newsPage.checkVisibilityOfControlPanel();
        newsPage.clickAddNewsButton();
        newsPage.checkVisibilityOfCreatingNewsWindow();
        newsPage.setNewsCategory(Data.thanksgivingCategory);
        newsPage.setNewsTitle(creatingNewPostTitle);
        newsPage.setPublicationDate(1);
        newsPage.setPublicationTime(0);
        newsPage.setNewsDescription();
        newsPage.clickSaveNewPostButton();
        newsPage.checkVisibilityOfControlPanel();
        newsPage.searchingNewPostTitle(creatingNewPostTitle);
        newsPage.checkSearchResultIsDisplayed(creatingNewPostTitle);

        newsPage.clickEditButton(creatingNewPostTitle);
        newsPage.checkVisibilityOfEditingNewsWindow();
        newsPage.setNewsCategory(Data.profunoinCategory);

        newsPage.clickSaveNewPostButton();
        newsPage.checkVisibilityOfControlPanel();
        newsPage.searchingNewPostTitle(creatingNewPostTitle);
        newsPage.checkSearchResultIsDisplayed(creatingNewPostTitle);
        newsPage.clickEditButton(creatingNewPostTitle);
        newsPage.checkVisibilityOfEditingNewsWindow();
        newsPage.checkNewPostCategory(Data.profunoinCategory);
    }
}
