package com.fpg.fpg.ws.pojo;


import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by jhovany on 27/03/17.
 */

public class OnBoardingWS {

    private String boardingName;
    private String boardDescription;
    private String boardImage;
    private String boardCircleColor;
    private Long boardingOrder;

    public String getBoardingName() {
        return boardingName;
    }

    public void setBoardingName(String boardingName) {
        this.boardingName = boardingName;
    }

    public String getBoardDescription() {
        return boardDescription;
    }

    public void setBoardDescription(String boardDescription) {
        this.boardDescription = boardDescription;
    }

    public String getBoardImage() {
        return boardImage;
    }

    public void setBoardImage(String boardImage) {
        this.boardImage = boardImage;
    }

    public String getBoardCircleColor() {
        return boardCircleColor;
    }

    public void setBoardCircleColor(String boardCircleColor) {
        this.boardCircleColor = boardCircleColor;
    }

    public Long getBoardingOrder() {
        return boardingOrder;
    }

    public void setBoardingOrder(Long boardingOrder) {
        this.boardingOrder = boardingOrder;
    }
}
