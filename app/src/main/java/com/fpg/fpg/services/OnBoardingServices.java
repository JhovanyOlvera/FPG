package com.fpg.fpg.services;

import com.fpg.fpg.models.OnBoarding;

import java.util.List;

import io.realm.Realm;

/**
 * Created by jhovany on 27/03/17.
 */

public class OnBoardingServices {
    private final Realm realm;

    public OnBoardingServices(Realm realm) {
        this.realm = realm;
    }

    public List<OnBoarding> getView() {
        return realm.where(OnBoarding.class).findAll().sort("boardingOrder");

    }

}
