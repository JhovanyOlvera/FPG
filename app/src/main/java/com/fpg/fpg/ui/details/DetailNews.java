package com.fpg.fpg.ui.details;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.fpg.fpg.R;
import com.fpg.fpg.adapters.ListDetailNewsAdapter;
import com.fpg.fpg.models.News;
import com.fpg.fpg.services.NewsServices;
import com.fpg.fpg.utils.Constants;
import com.fpg.fpg.utils.Fonts;

import java.util.List;

import io.realm.Realm;

/**
 * Created by jhovany on 7/05/17.
 */

public class DetailNews extends AppCompatActivity {

    private Long valor;
    private NewsServices newsServices;
    private RecyclerView mRecyclerView;
    private ListDetailNewsAdapter mAdapter;
    private Toolbar toolbar;
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        initServices();
        initBundle();
        initRecyclerView();
        initToolbar();

    }

    private void initServices() {
        newsServices = new NewsServices(Realm.getDefaultInstance());
    }

    private void initBundle() {
        Intent intent = this.getIntent();
        if (intent != null) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                valor = bundle.getLong(Constants.Group.GROUP_NEWS);
            }
        }
    }

    private void initToolbar() {
        title = (TextView) findViewById(R.id.title);
        title.setText(newsServices.getDateBar(valor));
        title.setTypeface(Fonts.getFontRoboto(this, Constants.ConstanTypeFont.DOSIS_BOLD));

        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }

    private void initRecyclerView() {
        List<News> newsList = newsServices.getNewsByGroup(valor);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_detailNews);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new ListDetailNewsAdapter(newsList, getApplicationContext());
        mRecyclerView.setAdapter(mAdapter);
    }


}
