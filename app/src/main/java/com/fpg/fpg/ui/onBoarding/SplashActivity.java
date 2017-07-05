package com.fpg.fpg.ui.onBoarding;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.TextView;

import com.fpg.fpg.R;
import com.fpg.fpg.services.SyncUp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;

public class SplashActivity extends AppCompatActivity {

    //<editor-fold des=" * * * * *  U I    R E F E R E N C E S  * * * * * ">
    @BindView(R.id.tv_number_version)
    TextView tvNumberVersion;
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
                tvNumberVersion.setText(dataSnapshot.getValue(String.class));
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
