package com.dangtin.cookbook;

import android.app.Application;
import android.content.Context;

import com.dangtin.cookbook.data.prefs.DataStoreManager;
import com.dangtin.cookbook.injection.components.ApplicationComponent;
import com.dangtin.cookbook.injection.components.DaggerApplicationComponent;
import com.dangtin.cookbook.injection.modules.ApplicationModule;

public class CookBookApplication extends Application {

    private final Object lock = new Object();
    private ApplicationComponent mApplicationComponent;

    public static CookBookApplication get(Context context) {
        return (CookBookApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        DataStoreManager.init(getApplicationContext());
    }

    public ApplicationComponent getComponent() {
        if (mApplicationComponent == null) {
            synchronized (lock) {
                if (mApplicationComponent == null) {
                    mApplicationComponent = DaggerApplicationComponent.builder()
                            .applicationModule(new ApplicationModule(this))
                            .build();
                }
            }
        }
        return mApplicationComponent;
    }
}
