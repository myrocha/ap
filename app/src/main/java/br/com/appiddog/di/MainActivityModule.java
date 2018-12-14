package br.com.appiddog.di;

import android.app.Application;

import br.com.appiddog.model.persistence.SharedPreference;
import br.com.appiddog.service.IService;
import br.com.appiddog.viewmodel.MainViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {
    @Provides
    static MainViewModel provideMainViewModel(final Application application, final IService iService, final SharedPreference sharedPreference/*, final AppExecutors appExecutors, final AppDatabase appDatabase, final SharedPreferencesUtil sharedPreferencesUtil*/) {
        return new MainViewModel(/*new MainRepository(iService, sharedPreference, application)*//*new LoginRepository(iService)*/);/*application*//*, new LoginRepository(application, iService, appExecutors, appDatabase, sharedPreferencesUtil*/
    }
}
