package com.fpg.fpg.ws.pojo;


import io.realm.RealmObject;

/**
 * Created by jhovany on 27/03/17.
 */

public class NewsWS {

    private String title;
    private String shortTitle;
    private String image;
    private String description;
    private Long remoteGroupId;
    private Long date;
    private Long order;
    private Long remoteId;
    private Long remoteIdTypeCard;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortTitle() {
        return shortTitle;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getRemoteGroupId() {
        return remoteGroupId;
    }

    public void setRemoteGroupId(Long remoteGroupId) {
        this.remoteGroupId = remoteGroupId;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public Long getOrder() {
        return order;
    }

    public void setOrder(Long order) {
        this.order = order;
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
