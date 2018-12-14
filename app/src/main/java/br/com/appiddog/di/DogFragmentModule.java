package br.com.appiddog.di;

import android.app.Application;

import br.com.appiddog.model.persistence.SharedPreference;
import br.com.appiddog.repository.DogRepository;
import br.com.appiddog.service.IService;
import br.com.appiddog.viewmodel.DogViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class DogFragmentModule {

    @Provides
    static DogViewModel provideMainViewModel(final Application application, final IService iService, final SharedPreference sharedPreference/*, final AppExecutors appExecutors, final AppDatabase appDatabase, final SharedPreferencesUtil sharedPreferencesUtil*/) {
        return new DogViewModel(new DogRepository(iService, sharedPreference, application)/*new LoginRepository(iService)*/);/*application*//*, new LoginRepository(application, iService, appExecutors, appDatabase, sharedPreferencesUtil*/
    }
}
