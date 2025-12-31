package ru.iteco.fmhandroid.ui.data;

import androidx.annotation.NonNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;

import ru.iteco.fmhandroid.R;

public class Data {
    public static final String validLogin = "login2";
    public static final String validPassword = "password2";

    public static final String nonValidLogin = "qwerqwr";
    public static final String nonValidPassword = "12345";
    public static final String authErrorMes = "Something went wrong. Try again later.";
    public static final String citationCom1 = "\"Ну, идеальное устройство мира в моих глазах. Где никто не оценивает, никто не осудит, где говоришь, и тебя слышат, где, если страшно, тебя обнимут и возьмут за руку, а если холодно тебя согреют.” Юля Капис, волонтер";

    public static final String announcementCategory = "Объявление";
    public static final String birthdayCategory = "День рождения";
    public static final String salaryCategory = "Зарплата";
    public static final String profunoinCategory = "Профсоюз";
    public static final String holidayCategory = "Праздник";
    public static final String massggeCategory = "Массаж";
    public static final String thanksgivingCategory = "Благодарность";
    public static final String needhelpCategory = "Нужна помощь";
    public static final String creatingNewsTitle = "Testing Title №";
    public static final String creatingNewsDesc = "Testing description №";
    public static final String popupErrorMessage = "Fill empty fields";
    public static final String popupCategoryErrorMessage = "Saving failed. Try again later.";

    public static String creatingRandomTitle() {
        Random random = new Random();
        int randomNumber = random.nextInt(2000);

        return (creatingNewsTitle + String.valueOf(randomNumber));
    }

    public static String creatingPublicationDate(int difDays) {
        LocalDate date;
        date = LocalDate.now().plusDays(difDays);
        return date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String creatingPublicationTime(int difTime) {
        LocalTime time;
        time = LocalTime.now().plusHours(difTime);
        return time.format(DateTimeFormatter.ofPattern("HH:mm"));
    }

    public static String creatingPublicationDescription() {
        Random random = new Random();
        int randomNumber = random.nextInt(2000);

        return (creatingNewsDesc + String.valueOf(randomNumber));
    }

    public static final List<String> categories = Arrays.asList(
            Data.announcementCategory,
            Data.birthdayCategory,
            Data.salaryCategory,
            Data.profunoinCategory,
            Data.holidayCategory,
            Data.massggeCategory,
            Data.thanksgivingCategory,
            Data.needhelpCategory
    );

    public static final Map<String, Integer> categoriesIcons = Map.of(
            Data.announcementCategory, R.raw.icon_advertisement,
            Data.birthdayCategory, R.raw.icon_birthday,
            Data.salaryCategory, R.raw.icon_salary,
            Data.profunoinCategory, R.raw.icon_union,
            Data.holidayCategory, R.raw.icon_holiday,
            Data.massggeCategory, R.raw.icon_massage,
            Data.thanksgivingCategory, R.raw.icon_gratitude,
            Data.needhelpCategory, R.raw.icon_help
    );


}
