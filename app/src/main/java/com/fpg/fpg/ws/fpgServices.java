package com.fpg.fpg.ws;

import com.fpg.fpg.utils.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jhovany on 15/04/17.
 */

public class fpgServices {

    private static fpgClient FPG_CLIENT;

    public fpgServices() {
    }

    public static fpgClient getServices() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.Host.HOME_PATH)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        FPG_CLIENT = retrofit.create(fpgClient.class);

        return FPG_CLIENT;
    }

}
