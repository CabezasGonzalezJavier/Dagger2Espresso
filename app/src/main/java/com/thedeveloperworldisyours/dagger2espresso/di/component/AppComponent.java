package com.thedeveloperworldisyours.dagger2espresso.di.component;

import com.thedeveloperworldisyours.dagger2espresso.App;
import com.thedeveloperworldisyours.dagger2espresso.Interact.LoginInteract;
import com.thedeveloperworldisyours.dagger2espresso.Interact.MainInteract;
import com.thedeveloperworldisyours.dagger2espresso.di.AnalyticsManager;
import com.thedeveloperworldisyours.dagger2espresso.di.AppModule;
import com.thedeveloperworldisyours.dagger2espresso.di.DomainModule;
import com.thedeveloperworldisyours.dagger2espresso.di.LoginInteractModule;
import com.thedeveloperworldisyours.dagger2espresso.di.MainInteractModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by javierg on 05/07/16.
 */
@Singleton
@Component(
        modules = {
                AppModule.class,
                DomainModule.class,
                LoginInteractModule.class,
                MainInteractModule.class
        }
)
public interface AppComponent {
    void inject(App app);

    AnalyticsManager getAnalyticsManager();
    LoginInteract getFindItemsInteract();
    MainInteract getImageInteract();
}
