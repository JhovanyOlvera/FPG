package com.fpg.fpg.utils;

import android.app.Application;
import android.util.Log;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by jhovany on 2/04/17.
 */

public class FPGApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name("fpgDB")
                .schemaVersion(1)
                .build();

        Realm.setDefaultConfiguration(realmConfiguration);


    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
