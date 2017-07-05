package com.fpg.fpg.services;

import com.fpg.fpg.models.DateNews;
import com.fpg.fpg.models.GroupNews;
import com.fpg.fpg.models.News;

import java.util.List;
import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

/**
 * Created by Jhovany Olvera on 04/07/2017.
 */

public class GroupNewsServices {
    private final Realm realm;

    public GroupNewsServices(Realm realm) {
        this.realm = realm;
    }


    public List<GroupNews> getGroupNewsList() {
        List<GroupNews> listGroupNews = realm.copyFromRealm(realm.where(GroupNews.class).findAll());

        for (GroupNews groupNews : listGroupNews){
            RealmList<News> listNews = new RealmList<>();
            RealmResults<News> resultsNews = realm.where(News.class).equalTo("groupNews.id",groupNews.getId()).findAll();
            listNews.addAll(resultsNews.subList(0,resultsNews.size()));
             groupNews.setNews(listNews);

        }
        return listGroupNews;
    }

    /*
        for (GroupNews groupNews : groupNewsList) {
            groupNews.setNews(Select.from(News.class).where(Condition.prop("GROUP_NEWS").eq(groupNews.getRemoteId())).list());
        }
*/

}
