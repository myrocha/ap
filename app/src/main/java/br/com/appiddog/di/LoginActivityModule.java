package br.com.appiddog.di;

import android.app.Application;

import br.com.appiddog.repository.LoginRepository;
import br.com.appiddog.service.IService;
import br.com.appiddog.viewmodel.LoginViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class LoginActivityModule {
    @Provides
    static LoginViewModel provideViewModel(final Application application, final IService iService/*, final AppExecutors appExecutors, final AppDatabase appDatabase, final SharedPreferencesUtil sharedPreferencesUtil*/) {
        return new LoginViewModel(new LoginRepository(iService));/*application*//*, new LoginRepository(application, iService, appExecutors, appDatabase, sharedPreferencesUtil*/
    }
}
