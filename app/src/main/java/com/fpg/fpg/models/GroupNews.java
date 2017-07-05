package com.fpg.fpg.models;


import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.PrimaryKey;

/**
 * Created by jhovany on 27/03/17.
 */

public class GroupNews extends RealmObject {

    @PrimaryKey
    private Long id;
    private Long remoteId;
    private RealmList<News> news;
    private DateNews dateNews;
    private TypeCard typeCard;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRemoteId() {
        return remoteId;
    }

    public void setRemoteId(Long remoteId) {
        this.remoteId = remoteId;
    }

    public RealmList<News> getNews() {
        return news;
    }

    public void setNews(RealmList<News> news) {
        this.news = news;
    }

    public DateNews getDateNews() {
        return dateNews;
    }

    public void setDateNews(DateNews dateNews) {
        this.dateNews = dateNews;
    }

    public TypeCard getTypeCard() {
        return typeCard;
    }

    public void setTypeCard(TypeCard typeCard) {
        this.typeCard = typeCard;
    }
}
