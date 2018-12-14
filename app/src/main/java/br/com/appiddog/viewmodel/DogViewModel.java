package br.com.appiddog.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableBoolean;

import javax.inject.Inject;

import br.com.appiddog.model.ListDog;
import br.com.appiddog.repository.DogRepository;

public class DogViewModel extends ViewModel {

    public final ObservableBoolean loading = new ObservableBoolean();

    public DogRepository dogRepository;
    @Inject
    public DogViewModel(final DogRepository repository) {
        this.dogRepository = repository;

    }

    /**
     * access the repository to login.
     * @return
     */
    public LiveData<ListDog> getListDog(final String category) {
        /*Access access = new Access();
        access.setEmail(email.getValue());*/
        return dogRepository.getListDog(category);


    }

    public void showLoading() {
        loading.set(true);
    }

    public void hideLoading() {
        loading.set(false);


    }
}
