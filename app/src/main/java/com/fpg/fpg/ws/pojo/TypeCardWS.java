package com.fpg.fpg.ws.pojo;


import io.realm.RealmObject;

/**
 * Created by jhovany on 27/03/17.
 */

public class TypeCardWS {

    private String nameCardType;
    private Long remoteId;

    public String getNameCardType() {
        return nameCardType;
    }

    public void setNameCardType(String nameCardType) {
        this.nameCardType = nameCardType;
    }

    public Long getRemoteId() {
        return remoteId;
    }

    public void setRemoteId(Long remoteId) {
        this.remoteId = remoteId;
    }
}
