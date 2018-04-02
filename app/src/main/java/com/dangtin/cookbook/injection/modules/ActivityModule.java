package com.dangtin.cookbook.injection.modules;

import android.app.Activity;
import android.content.Context;

import com.dangtin.cookbook.injection.ActivityContext;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private final Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    public Activity provideActivity() {
        return mActivity;
    }

    @Provides
    @ActivityContext
    Context provideActivityContext() {
        return mActivity;
    }
}
