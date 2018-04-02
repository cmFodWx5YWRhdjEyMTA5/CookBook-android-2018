package com.dangtin.cookbook.injection.components;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import com.dangtin.cookbook.data.DataManager;
import com.dangtin.cookbook.injection.ApplicationContext;
import com.dangtin.cookbook.injection.modules.ApplicationModule;
import com.dangtin.cookbook.ui.base.BaseActivity;
import com.dangtin.cookbook.ui.base.BaseFragment;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    @ApplicationContext
    Context context();

    Application application();

    Retrofit retrofit();

    DataManager dataManager();

    Toast toast();

    void inject(BaseActivity baseActivity);

    void inject(BaseFragment fragment);
}
