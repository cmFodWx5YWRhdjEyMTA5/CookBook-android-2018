package com.dangtin.cookbook.ui.base;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.MainThread;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.StringRes;
import android.support.annotation.UiThread;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Toast;

import com.dangtin.cookbook.CookBookApplication;
import com.dangtin.cookbook.injection.ActivityScopeComponentCache;
import com.dangtin.cookbook.injection.components.ActivityComponent;
import com.dangtin.cookbook.injection.components.ActivityScopeComponent;
import com.dangtin.cookbook.injection.components.DaggerActivityScopeComponent;
import com.dangtin.cookbook.injection.modules.ActivityModule;

import javax.inject.Inject;
import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment {

    private ActivityComponent activityComponent;
    private ActivityScopeComponent activityScopeComponent;

    protected Unbinder viewUnbind;

    private long componentStateKey = -1;
    private boolean isDestroyBySystem = false;

    @Inject
    ActivityScopeComponentCache activityScopeComponentCache;

    @Inject
    Toast mToast;

    private ActivityScopeComponent getActivityScopeComponent() {
        if (activityScopeComponent == null) {
            activityScopeComponent = DaggerActivityScopeComponent.builder()
                    .applicationComponent(CookBookApplication.get(getActivity()).getComponent())
                    .build();
        }
        return activityScopeComponent;
    }

    public final ActivityComponent getActivityComponent() {
        if (activityComponent == null) {
            activityComponent = getActivityScopeComponent()
                    .activityComponent(new ActivityModule(getActivity()));
        }
        return activityComponent;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        CookBookApplication.get(getActivity()).getComponent().inject(this);
        activityScopeComponent = activityScopeComponentCache.restoreComponent(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (activityScopeComponentCache != null) {
            componentStateKey = activityScopeComponentCache
                    .saveComponentInstance(activityScopeComponent, outState);
        }
        isDestroyBySystem = true;
    }

    @Override
    public void onDestroyView() {
        if (viewUnbind != null) {
            viewUnbind.unbind();
        }
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        if (!isDestroyBySystem) {
            if (activityScopeComponentCache != null) {
                activityScopeComponentCache.clearComponent(componentStateKey);
            }
        }
        isDestroyBySystem = false;
        super.onDestroy();
    }

    @MainThread
    @UiThread
    protected void showMessage(@StringRes int strRes) {
        showMessage(getString(strRes));
    }

    @MainThread
    @UiThread
    protected void showMessage(String message) {
        Toast toast = mToast;
        if (toast != null) {
            toast.setText(message);
        }
        Context context = getContext();
        if (context != null) {
            toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        }
        if (toast != null) {
            toast.show();
        }
    }
}
