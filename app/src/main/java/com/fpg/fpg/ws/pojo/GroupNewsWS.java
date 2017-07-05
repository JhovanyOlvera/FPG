package com.fpg.fpg.ws.pojo;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by jhovany on 27/03/17.
 */

public class GroupNewsWS {

    private Long dateNews;
    private List<NewsWS> newsList;
    private Long remoteId;
    private Long remoteIdTypeCard;

    public Long getDateNews() {
        return dateNews;
    }

    public void setDateNews(Long dateNews) {
        this.dateNews = dateNews;
    }

    public List<NewsWS> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<NewsWS> newsList) {
        this.newsList = newsList;
    }

    public Long getRemoteId() {
        return remoteId;
    }

    public void setRemoteId(Long remoteId) {
        this.remoteId = remoteId;
    }

    public Long getRemoteIdTypeCard() {
        return remoteIdTypeCard;
    }

    public void setRemoteIdTypeCard(Long remoteIdTypeCard) {
        this.remoteIdTypeCard = remoteIdTypeCard;
    }
}
