package com.fpg.fpg.ws.pojo;


import io.realm.RealmObject;

/**
 * Created by jhovany on 27/03/17.
 */

public class DateNewsWS  {

    private Long startDay;
    private Long finishDay;
    private String month;
    private Long year;
    private Long remoteId;

    public DateNewsWS() {
    }

    public Long getStartDay() {
        return startDay;
    }

    public void setStartDay(Long startDay) {
        this.startDay = startDay;
    }

    public Long getFinishDay() {
        return finishDay;
    }

    public void setFinishDay(Long finishDay) {
        this.finishDay = finishDay;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public Long getRemoteId() {
        return remoteId;
    }

    public void setRemoteId(Long remoteId) {
        this.remoteId = remoteId;
    }
}
