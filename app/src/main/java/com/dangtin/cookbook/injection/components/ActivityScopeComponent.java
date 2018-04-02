package com.dangtin.cookbook.injection.components;

import com.dangtin.cookbook.injection.PerActivity;
import com.dangtin.cookbook.injection.modules.ActivityModule;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class)
public interface ActivityScopeComponent {

    ActivityComponent activityComponent(ActivityModule module);
}
