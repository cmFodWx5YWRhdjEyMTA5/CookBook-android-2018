package com.dangtin.cookbook.injection.modules;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import com.dangtin.cookbook.data.networking.CookBookService;
import com.dangtin.cookbook.injection.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class ApplicationModule {
    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideApplicationContext() {
        return mApplication;
    }

    @Provides
    @Singleton
    Toast provideToast(@ApplicationContext Context context) {
        return Toast.makeText(context, "", Toast.LENGTH_LONG);
    }

    @Provides
    @Singleton
    CookBookService networkService(Retrofit retrofit){
        return retrofit.create(CookBookService.class);
    }

    @Provides
    @Singleton
    Retrofit provideRetrofitInstance() {
        return CookBookService.Creator.newRetrofitInstance();
    }
}
