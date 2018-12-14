package br.com.appiddog.di;

import br.com.appiddog.view.fragments.DogFragment;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Module(includes = AndroidSupportInjectionModule.class)
public abstract class FragmentBindingsModule {



    @ContributesAndroidInjector(modules = DogFragmentModule.class)
    abstract DogFragment provideClosedResourcecFragment();


}

