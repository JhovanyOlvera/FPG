package com.fpg.fpg.services;

import com.fpg.fpg.models.DateNews;
import com.fpg.fpg.models.GroupNews;
import com.fpg.fpg.models.News;
import com.fpg.fpg.models.OnBoarding;
import com.fpg.fpg.models.TypeCard;
import com.fpg.fpg.utils.Constants;
import com.fpg.fpg.ws.fpgServices;
import com.fpg.fpg.ws.pojo.DateNewsWS;
import com.fpg.fpg.ws.pojo.GroupNewsWS;
import com.fpg.fpg.ws.pojo.NewsWS;
import com.fpg.fpg.ws.pojo.TypeCardWS;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by jhovany on 27/04/17.
 */

public class SyncUp {

    private SplashServices splashServices;
    private DatabaseReference refCatalog = FirebaseDatabase.getInstance().getReference();

    public SyncUp() {
        splashServices = new SplashServices(Realm.getDefaultInstance());

    }

    public void getOnBoardingData() {

        DatabaseReference listOnboarding = refCatalog.child(Constants.FirebaseCatalog.FIREBASE_CATALOG_ON_BOARDING);
        listOnboarding.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                splashServices.saveOrUpdateOnboarding(dataSnapshot);
                getTypeCard();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    private void getTypeCard() {
        DatabaseReference listTypeCard = refCatalog.child(Constants.FirebaseCatalog.FIREBASE_CATALOG_TYPE_CARD);
        listTypeCard.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                splashServices.saveOrUpdateCatalogTypeCard(dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        getDateNews();
    }


    private void getDateNews() {

        DatabaseReference listCatalog = refCatalog.child(Constants.FirebaseCatalog.FIREBASE_CATALOG_DATE_NEWS);

        listCatalog.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                splashServices.saveOrUpdateCatalogDataNews(dataSnapshot);
                  getGroupNews();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    private void getGroupNews() {

      DatabaseReference listGroupNews = refCatalog.child(Constants.FirebaseCatalog.FIREBASE_CATALOG_GROUP_NEWS);

        listGroupNews.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                splashServices.saveOrUpdateCatalogGroupNews(dataSnapshot);
                getNews();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }


    private void getNews() {

        DatabaseReference listNews = refCatalog.child(Constants.FirebaseCatalog.FIREBASE_CATALOG_NEWS);

        listNews.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                splashServices.saveOrUpdateCatalogNews(dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        /* fpgServices.getServices().getNews().enqueue(new Callback<List<NewsWS>>() {
            @Override
            public void onResponse(Call<List<NewsWS>> call, Response<List<NewsWS>> response) {
                List<News> referenceNews = Select.from(News.class).list();
                HashMap<String, News> hmItem = new HashMap<>();

                for (News newsElement : referenceNews) {
                    hmItem.put(String.valueOf(newsElement.getRemoteId()), newsElement);
                }

                for (NewsWS newsWS : response.body()) {

                    News newsElement = Select.from(News.class).where(Condition.prop("REMOTE_ID").eq(newsWS.getRemoteId())).first();
                    if (newsElement == null) {
                        newsElement = new News();
                    }
                    newsElement.setRemoteId(newsWS.getRemoteId());
                    newsElement.setTitle(newsWS.getTitle());
                    newsElement.setShortTitle(newsWS.getShortTitle());
                    newsElement.setImage(newsWS.getImage());
                    newsElement.setDescription(newsWS.getDescription());
                    newsElement.setOrderItem(newsWS.getOrder());

                    TypeCard typeCard = Select.from(TypeCard.class).where(Condition.prop("REMOTE_ID").eq(newsWS.getRemoteIdTypeCard())).first();

                    if (typeCard != null) {
                        newsElement.setTypeCard(typeCard);
                    }

                    GroupNews groupNews = Select.from(GroupNews.class).where(Condition.prop("REMOTE_ID").eq(newsWS.getRemoteGroupId())).first();
                    if (groupNews != null) {
                        newsElement.setGroupNews(groupNews);
                    }

                    DateNews dateNews = Select.from(DateNews.class).where(Condition.prop("REMOTE_ID").eq(newsWS.getDate())).first();
                    newsElement.setDateNews(dateNews);
                    newsElement.save();
                    hmItem.remove(String.valueOf(newsElement.getRemoteId()));

                }
                for (Map.Entry<String, News> deleteNews : hmItem.entrySet()) {
                    deleteNews.getValue().delete();
                }
            }

            @Override
            public void onFailure(Call<List<NewsWS>> call, Throwable t) {
            }
        });
        */
    }


}
