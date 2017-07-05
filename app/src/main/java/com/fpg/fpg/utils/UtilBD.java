package com.fpg.fpg.utils;

import android.util.Log;

import com.fpg.fpg.models.DateNews;
import com.fpg.fpg.models.GroupNews;
import com.fpg.fpg.models.News;
import com.fpg.fpg.models.OnBoarding;
import com.fpg.fpg.models.TypeCard;

import io.realm.Realm;

/**
 * Created by Jhovany Olvera on 03/07/2017.
 */

public class UtilBD {

    public static void LogDateNews(Realm realm) {
        for (DateNews dateNews : realm.where(DateNews.class).findAll()) {
            String value =
                    dateNews.getId() + " , " +
                            dateNews.getRemoteId().toString() + " , " +
                            dateNews.getStartDay() + " , " +
                            dateNews.getFinishDay() + " , " +
                            dateNews.getMonth() + " , " +
                            dateNews.getYear() + " . ";
            Log.d("DB DateNews", value);
        }
    }

    public static void LogOnboarding(Realm realm) {
        for (OnBoarding onBoarding : realm.where(OnBoarding.class).findAll()) {
            String value =
                    onBoarding.getId() + " , " +
                            onBoarding.getBoardingName().toString() + " , " +
                            onBoarding.getBoardDescription() + " , " +
                            onBoarding.getBoardImage() + " , " +
                            onBoarding.getBoardCircleColor() + " , " +
                            onBoarding.getBoardingOrder() + " . ";
            Log.d("DB Onboarding", value);
        }
    }

    public static void LogTypeCard(Realm realm) {
        for (TypeCard typeCard : realm.where(TypeCard.class).findAll()) {
            String value =
                    typeCard.getId() + " , " +
                            typeCard.getRemoteId() + " , " +
                            typeCard.getNameCardType() + " . ";
            Log.d("DB TypeCard", value);
        }
    }

    public static void LogGroupNews(Realm realm) {
        for (GroupNews groupNews : realm.where(GroupNews.class).findAll()) {
            String value =
                    groupNews.getId() + " , " +
                            groupNews.getRemoteId() + " . ";
            Log.d("DB GroupNews", value);
        }
    }

    public static void LogNews(Realm realm) {
        for (News news : realm.where(News.class).findAll()) {
            String value =
                    news.getId() + " , " +
                            news.getRemoteId() + " , " +
                            news.getTitle() + " , " +
                            news.getShortTitle() + " , " +
                            news.getImage() + " , " +
                            news.getDescription() + " , " +
                            news.getOrderItem() + " , " +
                            news.getGroupNews().getRemoteId() + " , " +
                            news.getDateNews().getRemoteId() + " , " +
                            news.getTypeCard().getRemoteId() + " . ";
            Log.d("DB News", value);
        }
    }

}
