package com.fpg.fpg.ui.home;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.fpg.fpg.R;
import com.fpg.fpg.adapters.ListHeaderNewsAdapter;
import com.fpg.fpg.interfaces.GroupCallbacks;
import com.fpg.fpg.models.GroupNews;
import com.fpg.fpg.services.GroupNewsServices;
import com.fpg.fpg.utils.Constants;
import com.fpg.fpg.utils.Fonts;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, GroupCallbacks {

    //<editor-fold des=" * * * * *  U I    R E F E R E N C E S  * * * * * ">
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.banner_month)
    CardView bannerMonth;
    @BindView(R.id.rv_headerNews)
    RecyclerView mRecyclerView;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    //</editor-fold>

    private ListHeaderNewsAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private GroupCallbacks mGroupCallbacks;
    private GroupNewsServices groupNewsServices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        toolbar.setTitle("");

        setSupportActionBar(toolbar);

        mGroupCallbacks = this;

        groupNewsServices = new GroupNewsServices(Realm.getDefaultInstance());
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        navView.setNavigationItemSelectedListener(this);

        navView.getMenu().size();

        MenuItem mi = navView.getMenu().getItem(0);
        mi.setVisible(true);
        mi.setTitle("Actividades");

        title.setText("Actividades");
        title.setTypeface(Fonts.getFontRoboto(this, Constants.ConstanTypeFont.DOSIS_BOLD));

        final TextView tv_title = (TextView) navView.getHeaderView(0).findViewById(R.id.tv_title);
        final TextView tv_subtitle = (TextView) navView.getHeaderView(0).findViewById(R.id.tv_subtitle);
        final ImageView iv = (ImageView) navView.getHeaderView(0).findViewById(R.id.iv_profile);

        Glide.with(this).load(R.drawable.ic_escudo).asBitmap().centerCrop().into(new BitmapImageViewTarget(iv) {

            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable = RoundedBitmapDrawableFactory.create(getBaseContext().getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                iv.setImageDrawable(circularBitmapDrawable);
            }
        });

        setFont(tv_title);
        setFont(tv_subtitle);

        tv_title.setText("Colegio Fray Pedro de Gante");
        tv_subtitle.setText("fpg_developer@gmail.com");

        initRecyclerView();
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nav_section_1) {

        } else if (id == R.id.nav_section_2) {

        } else if (id == R.id.nav_section_3) {

        } else if (id == R.id.nav_section_4) {

        } else if (id == R.id.nav_section_5) {

        } else if (id == R.id.nav_divisor_section1) {

        } else if (id == R.id.nav_divisor_section2) {

        } else if (id == R.id.nav_divisor_section3) {

        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void initRecyclerView() {
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

       List<GroupNews> groupNewsList = groupNewsServices.getGroupNewsList();

        mAdapter = new ListHeaderNewsAdapter(groupNewsList, getApplicationContext(), mGroupCallbacks);
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public void invokeActivity(Class activity, Long putExtras) {
        Intent intent = new Intent(this, activity);
        intent.putExtra(Constants.Group.GROUP_NEWS, putExtras);
        startActivity(intent);
    }

    private void setFont(TextView tv) {
        tv.setTypeface(Fonts.getFontRoboto(this, Constants.ConstanTypeFont.DOSIS_BOLD));
    }
}
