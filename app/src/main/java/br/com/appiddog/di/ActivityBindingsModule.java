package br.com.appiddog.di;


import br.com.appiddog.view.LoginActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Module(includes = AndroidSupportInjectionModule.class)
public abstract class ActivityBindingsModule {


    @ContributesAndroidInjector(modules = LoginActivityModule.class)
    abstract LoginActivity loginActivityInjector();


}
