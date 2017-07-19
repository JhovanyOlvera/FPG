package com.fpg.fpg.ui.onBoarding;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.fpg.fpg.R;
import com.fpg.fpg.services.SyncUp;
import com.fpg.fpg.utils.Constants;
import com.fpg.fpg.utils.Fonts;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends AppCompatActivity {

    //<editor-fold des=" * * * * *  U I    R E F E R E N C E S  * * * * * ">
    @BindView(R.id.tv_version_app)
    TextView tvNumberVersion;
    @BindView(R.id.iv_logo_app)
    ImageView ivLogoApp;
    @BindView(R.id.tv_college)
    TextView tvCollege;
    @BindView(R.id.tv_institute)
    TextView tvInstitute;
    @BindView(R.id.ll_title)
    LinearLayout llTitle;
    @BindView(R.id.tv_title_preschool)
    TextView tvTitlePreschool;
    @BindView(R.id.tv_title_primary)
    TextView tvTitlePrimary;
    @BindView(R.id.tv_title_high_school)
    TextView tvTitleHighSchool;
    @BindView(R.id.ll_schools)
    LinearLayout llSchools;
    @BindView(R.id.lottie_loading)
    LottieAnimationView lottieLoading;
    @BindView(R.id.tv_title_name_app)
    TextView tvTitleNameApp;
    @BindView(R.id.activity_splash)
    ConstraintLayout activitySplash;
    //</editor-fold>

    //<editor-fold des=" * * * * *  I N T E R N A L  V A R I A B L E  * * * * * ">
    private Handler handler = new Handler();
    //</editor-fold>

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        DatabaseReference mensajeRef = ref.child("var_sys/android/appVersion");

        mensajeRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                tvNumberVersion.setText(getString(R.string.splash_title_version) + " " + dataSnapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });


        SyncUp syncUpServices = new SyncUp();
        syncUpServices.getOnBoardingData();

        setFont();
         waitChange();
    }

    private void setFont() {
        tvNumberVersion.setTypeface(Fonts.getFontRoboto(this, Constants.ConstanTypeFont.DOSIS_BOLD));
        tvCollege.setTypeface(Fonts.getFontRoboto(this, Constants.ConstanTypeFont.DOSIS_BOLD));
        tvInstitute.setTypeface(Fonts.getFontRoboto(this, Constants.ConstanTypeFont.DOSIS_BOLD));
        tvTitlePreschool.setTypeface(Fonts.getFontRoboto(this, Constants.ConstanTypeFont.DOSIS_BOLD));
        tvTitlePrimary.setTypeface(Fonts.getFontRoboto(this, Constants.ConstanTypeFont.DOSIS_BOLD));
        tvTitleHighSchool.setTypeface(Fonts.getFontRoboto(this, Constants.ConstanTypeFont.DOSIS_BOLD));
        tvTitleNameApp.setTypeface(Fonts.getFontRoboto(this, Constants.ConstanTypeFont.DOSIS_BOLD));
    }

    private void waitChange() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                goActivity();
            }
        }, 10000);
    }

    private void goActivity() {
        Intent intent = new Intent(this, PagerActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }

}
