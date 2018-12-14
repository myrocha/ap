package br.com.appiddog.di;


import br.com.appiddog.view.activity.LoginActivity;
import br.com.appiddog.view.activity.MainActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Module(includes = AndroidSupportInjectionModule.class)
public abstract class ActivityBindingsModule {


    @ContributesAndroidInjector(modules = LoginActivityModule.class)
    abstract LoginActivity loginActivityInjector();

    @ContributesAndroidInjector(modules = {MainActivityModule.class/*, FragmentBindingsModule.class*/})
    abstract MainActivity mainActivityInjector();


}
