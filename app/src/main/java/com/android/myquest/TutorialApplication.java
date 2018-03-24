package com.android.myquest;

import android.app.Application;
import android.content.Intent;

import com.android.myquest.ui.activities.MainActivity;
import com.android.myquest.ui.activities.PostActivity;
import com.android.myquest.ui.activities.RegisterActivity;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;


public class TutorialApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if (FirebaseApp.getApps(this).isEmpty()) {
            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        }
        if(FirebaseAuth.getInstance().getCurrentUser()!= null) {
            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
            Intent loginIntent = new Intent(TutorialApplication.this, PostActivity.class);
            loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        }
    }

}


