package com.fpg.fpg.ws;

import com.fpg.fpg.models.OnBoarding;
import com.fpg.fpg.utils.Constants;
import com.fpg.fpg.ws.pojo.DateNewsWS;
import com.fpg.fpg.ws.pojo.GroupNewsWS;
import com.fpg.fpg.ws.pojo.NewsWS;
import com.fpg.fpg.ws.pojo.TypeCardWS;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by jhovany on 15/04/17.
 */

public interface fpgClient {

    @GET(Constants.Host.HOME_SCRIPTS + Constants.Section.ONBOARGING + Constants.Script.JSON_ONBOARDING)
    Call<List<OnBoarding>> index();

    @GET(Constants.Host.HOME_SCRIPTS + Constants.Section.CARD + Constants.Script.JSON_TYPE_CARD)
    Call<List<TypeCardWS>> getTypeCard();

    @GET(Constants.Host.HOME_SCRIPTS + Constants.Section.GROUP_NEWS + Constants.Script.JSON_GROUP_NEWS)
    Call<List<GroupNewsWS>> getGroupNews();

    @GET(Constants.Host.HOME_SCRIPTS + Constants.Section.DATE + Constants.Script.JSON_DATE_NEWS)
    Call<List<DateNewsWS>> getDateNews();

    @GET(Constants.Host.HOME_SCRIPTS + Constants.Section.NEWS + Constants.Script.JSON_NEWS)
    Call<List<NewsWS>> getNews();

}
