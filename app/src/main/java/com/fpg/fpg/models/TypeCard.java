package com.fpg.fpg.models;


import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by jhovany on 27/03/17.
 */

public class TypeCard extends RealmObject {

    @PrimaryKey
    private Long id;
    private Long remoteId;
    private String nameCardType;

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

    public String getNameCardType() {
        return nameCardType;
    }

    public void setNameCardType(String nameCardType) {
        this.nameCardType = nameCardType;
    }
}
