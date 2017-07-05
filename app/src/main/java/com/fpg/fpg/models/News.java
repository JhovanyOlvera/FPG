package com.fpg.fpg.models;


import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by jhovany on 27/03/17.
 */

public class News extends RealmObject {

    @PrimaryKey
    private Long id;
    private Long remoteId;
    private String title;
    private String shortTitle;
    private String image;
    private String description;
    private Long orderItem;
    private GroupNews groupNews;
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

    public Long getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(Long orderItem) {
        this.orderItem = orderItem;
    }

    public GroupNews getGroupNews() {
        return groupNews;
    }

    public void setGroupNews(GroupNews groupNews) {
        this.groupNews = groupNews;
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
