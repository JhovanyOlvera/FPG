package com.fpg.fpg.services;

import android.util.Log;

import com.fpg.fpg.models.DateNews;
import com.fpg.fpg.models.GroupNews;
import com.fpg.fpg.models.News;
import com.fpg.fpg.models.OnBoarding;
import com.fpg.fpg.models.TypeCard;
import com.fpg.fpg.utils.UtilBD;
import com.fpg.fpg.ws.pojo.DateNewsWS;
import com.fpg.fpg.ws.pojo.GroupNewsWS;
import com.fpg.fpg.ws.pojo.NewsWS;
import com.fpg.fpg.ws.pojo.OnBoardingWS;
import com.fpg.fpg.ws.pojo.TypeCardWS;
import com.google.firebase.database.DataSnapshot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.realm.Realm;
import io.realm.RealmList;

/**
 * Created by jhovany on 16/04/17.
 */

public class SplashServices {

    private final Realm realm;

    public SplashServices(Realm realm) {
        this.realm = realm;
        Log.d("DB", "path: " + realm.getPath());
    }

    //<editor-fold des=" * * * * *  C R E A T E   * * * * * ">
    private void createDateNews(Long remoteId, String startDay, String finishDay, String month, String year) {
        realm.beginTransaction();

        DateNews dateNews = realm.createObject(DateNews.class, AutoIncrementIdDateNews());
        dateNews.setFinishDay(finishDay);
        dateNews.setMonth(month);
        dateNews.setRemoteId(remoteId);
        dateNews.setStartDay(startDay);
        dateNews.setYear(year);
        realm.commitTransaction();
    }

    private void createTypeCard(Long remoteId, String nameCardType) {
        realm.beginTransaction();

        TypeCard typeCard = realm.createObject(TypeCard.class, AutoIncrementIdTypeCard());
        typeCard.setRemoteId(remoteId);
        typeCard.setNameCardType(nameCardType);

        realm.commitTransaction();
    }

    private void createOnBoarding(String boardingName, String boardDescription, String boardImage, String boardCircleColor, Long boardingOrder) {
        realm.beginTransaction();

        OnBoarding onBoarding = realm.createObject(OnBoarding.class, AutoIncrementIdOnBoarding());
        onBoarding.setBoardingName(boardingName);
        onBoarding.setBoardDescription(boardDescription);
        onBoarding.setBoardImage(boardImage);
        onBoarding.setBoardCircleColor(boardCircleColor);
        onBoarding.setBoardingOrder(boardingOrder);
        realm.commitTransaction();
    }

    private void createGroupNews(Long remoteId, Long remoteIdDateNews, Long remoteIdTypeCard, List<NewsWS> newsList) {
        realm.beginTransaction();

        GroupNews groupNews = realm.createObject(GroupNews.class, AutoIncrementIdGroupNews());
        groupNews.setRemoteId(remoteId);
        groupNews.setDateNews(getDateNewsForRemoteId(remoteIdDateNews));
        //groupNews.setNews(newsList);
        groupNews.setTypeCard(getTypeCardForRemoteId(remoteIdTypeCard));
        realm.commitTransaction();
    }

    private void createNews(Long remoteId, String title, String shortTitle, String image, String description, Long remoteGroupId, Long remoteIdDate, Long order, Long remoteIdTypeCard) {

        realm.beginTransaction();

        News news = realm.createObject(News.class, AutoIncrementIdNews());
        news.setRemoteId(remoteId);
        news.setTitle(title);
        news.setShortTitle(shortTitle);
        news.setImage(image);
        news.setDescription(description);

        news.setGroupNews(getGroupNewsForRemoteId(remoteGroupId));
        news.setDateNews(getDateNewsForRemoteId(remoteIdDate));
        news.setTypeCard(getTypeCardForRemoteId(remoteIdTypeCard));

        news.setOrderItem(order);

        realm.commitTransaction();
    }
    //</editor-fold>


    //<editor-fold des=" * * * * *  D E L E T E   A L L   * * * * * ">
    private void deleteAllOnBoarding() {
        realm.beginTransaction();
        realm.delete(OnBoarding.class);
        realm.commitTransaction();
    }

    private void deleteDateNews(DateNews dateNews) {
        realm.beginTransaction();
        dateNews.deleteFromRealm();
        realm.commitTransaction();
    }

    private void deleteTypeCard(TypeCard typeCard) {
        realm.beginTransaction();
        typeCard.deleteFromRealm();
        realm.commitTransaction();
    }

    private void deleteGroupNews(GroupNews groupNews) {
        realm.beginTransaction();
        groupNews.deleteFromRealm();
        realm.commitTransaction();
    }

    private void deleteNews(News news) {
        realm.beginTransaction();
        news.deleteFromRealm();
        realm.commitTransaction();
    }
    //</editor-fold>

    // <editor-fold des=" * * * * *  S A V E   O R   U P D A T E  * * * * * ">
    public boolean saveOrUpdateCatalogDataNews(DataSnapshot dssDataNews) {

        List<DateNews> referenceDateNews = getAllDateNews();
        HashMap<String, DateNews> hmItem = new HashMap<>();
        for (DateNews dateNews : referenceDateNews) {
            hmItem.put(String.valueOf(dateNews.getRemoteId()), dateNews);
        }

        for (DataSnapshot dss : dssDataNews.getChildren()) {

            DateNewsWS dateNewsWS = dss.getValue(DateNewsWS.class);
            DateNews dateNews = realm.where(DateNews.class).equalTo("remoteId", dateNewsWS.getRemoteId()).findFirst();

            if (dateNews == null) {
                createDateNews(dateNewsWS.getRemoteId(), dateNewsWS.getStartDay().toString(), dateNewsWS.getFinishDay().toString(), dateNewsWS.getMonth(), dateNewsWS.getYear().toString());
            }
            hmItem.remove(String.valueOf(dateNewsWS.getRemoteId()));
        }

        for (Map.Entry<String, DateNews> hmDateNews : hmItem.entrySet()) {
            deleteDateNews(hmDateNews.getValue());
        }

        UtilBD.LogDateNews(realm);
        return true;
    }

    public boolean saveOrUpdateOnboarding(DataSnapshot dssOnBoarding) {

        deleteAllOnBoarding();
        for (DataSnapshot dss : dssOnBoarding.getChildren()) {

            OnBoardingWS onBoardingWS = dss.getValue(OnBoardingWS.class);
            createOnBoarding(
                    onBoardingWS.getBoardingName(),
                    onBoardingWS.getBoardDescription(),
                    onBoardingWS.getBoardImage(),
                    onBoardingWS.getBoardCircleColor(),
                    onBoardingWS.getBoardingOrder()
            );
        }
        UtilBD.LogOnboarding(realm);
        return true;
    }

    public boolean saveOrUpdateCatalogTypeCard(DataSnapshot dssTypeCard) {
        List<TypeCard> referenceTypeCard = getAllTypeCard();
        HashMap<String, TypeCard> hmItem = new HashMap<>();
        for (TypeCard typeCard : referenceTypeCard) {
            hmItem.put(String.valueOf(typeCard.getRemoteId()), typeCard);
        }

        for (DataSnapshot dss : dssTypeCard.getChildren()) {

            TypeCardWS typeCardWS = dss.getValue(TypeCardWS.class);
            TypeCard typeCard = realm.where(TypeCard.class).equalTo("remoteId", typeCardWS.getRemoteId()).findFirst();

            if (typeCard == null) {
                createTypeCard(typeCardWS.getRemoteId(), typeCardWS.getNameCardType());
            }
            hmItem.remove(String.valueOf(typeCardWS.getRemoteId()));
        }

        for (Map.Entry<String, TypeCard> hmTypeCard : hmItem.entrySet()) {
            deleteTypeCard(hmTypeCard.getValue());
        }
        UtilBD.LogTypeCard(realm);
        return true;
    }

    public boolean saveOrUpdateCatalogGroupNews(DataSnapshot dssGroupNews) {
        List<GroupNews> referenceGroupNews = getAllGroupNews();
        HashMap<String, GroupNews> hmItem = new HashMap<>();
        for (GroupNews groupNews : referenceGroupNews) {
            hmItem.put(String.valueOf(groupNews.getRemoteId()), groupNews);
        }

        for (DataSnapshot dss : dssGroupNews.getChildren()) {

            GroupNewsWS groupNewsWS = dss.getValue(GroupNewsWS.class);
            GroupNews groupNews = realm.where(GroupNews.class).equalTo("remoteId", groupNewsWS.getRemoteId()).findFirst();

            if (groupNews == null) {
                createGroupNews(groupNewsWS.getRemoteId(), groupNewsWS.getDateNews(), groupNewsWS.getRemoteIdTypeCard(), groupNewsWS.getNewsList());
            }
            hmItem.remove(String.valueOf(groupNewsWS.getRemoteId()));
        }

        for (Map.Entry<String, GroupNews> hmGroupNews : hmItem.entrySet()) {
            deleteGroupNews(hmGroupNews.getValue());
        }
        UtilBD.LogGroupNews(realm);
        return true;
    }

    public boolean saveOrUpdateCatalogNews(DataSnapshot dssNews) {
        List<News> referenceNews = getAllNews();

        HashMap<String, News> hmItem = new HashMap<>();
        for (News news : referenceNews) {
            hmItem.put(String.valueOf(news.getRemoteId()), news);
        }

        for (DataSnapshot dss : dssNews.getChildren()) {

            NewsWS newsWS = dss.getValue(NewsWS.class);
            News news = realm.where(News.class).equalTo("remoteId", newsWS.getRemoteId()).findFirst();

            if (news == null) {
                createNews(newsWS.getRemoteId(), newsWS.getTitle(), newsWS.getShortTitle(), newsWS.getImage(), newsWS.getDescription(), newsWS.getRemoteGroupId(), newsWS.getDate(),
                        newsWS.getOrder(), newsWS.getRemoteIdTypeCard());
            }
            hmItem.remove(String.valueOf(newsWS.getRemoteId()));
        }

        for (Map.Entry<String, News> hmNews : hmItem.entrySet()) {
            deleteNews(hmNews.getValue());
        }
        UtilBD.LogNews(realm);
        return true;
    }

    //</editor-fold>

    //<editor-fold des=" * * * * *    A U T O   I N C R E M E N T   * * * * * ">
    public Long AutoIncrementIdDateNews() {
        Long maxValue = (Long) realm.where(DateNews.class).max("id");
        return (maxValue != null) ? maxValue + 1 : 0;
    }

    public Long AutoIncrementIdTypeCard() {
        Long maxValue = (Long) realm.where(TypeCard.class).max("id");
        return (maxValue != null) ? maxValue + 1 : 0;
    }

    public Long AutoIncrementIdOnBoarding() {
        Long maxValue = (Long) realm.where(OnBoarding.class).max("id");
        return (maxValue != null) ? maxValue + 1 : 0;
    }

    public Long AutoIncrementIdGroupNews() {
        Long maxValue = (Long) realm.where(GroupNews.class).max("id");
        return (maxValue != null) ? maxValue + 1 : 0;
    }

    private Object AutoIncrementIdNews() {
        Long maxValue = (Long) realm.where(News.class).max("id");
        return (maxValue != null) ? maxValue + 1 : 0;
    }

    //</editor-fold>

    //<editor-fold des=" * * * * *    G E T   A L L    * * * * * ">
    private List<DateNews> getAllDateNews() {
        return realm.where(DateNews.class).findAll();
    }

    private List<TypeCard> getAllTypeCard() {
        return realm.where(TypeCard.class).findAll();
    }

    private List<OnBoarding> getAllOnboarding() {
        return realm.where(OnBoarding.class).findAll();
    }

    private List<GroupNews> getAllGroupNews() {
        return realm.where(GroupNews.class).findAll();
    }

    private List<News> getAllNews() {
        return realm.where(News.class).findAll();
    }

    // </editor-fold>

    //<editor-fold des=" * * * * *    G E T   F O R   R E M O T E   I D     * * * * * ">
    private GroupNews getGroupNewsForRemoteId(Long remoteId) {
        return realm.where(GroupNews.class).equalTo("remoteId", remoteId).findFirst();
    }

    private DateNews getDateNewsForRemoteId(Long remoteId) {
        return realm.where(DateNews.class).equalTo("remoteId", remoteId).findFirst();
    }

    private TypeCard getTypeCardForRemoteId(Long remoteId) {
        return realm.where(TypeCard.class).equalTo("remoteId", remoteId).findFirst();
    }

    // </editor-fold>

}
