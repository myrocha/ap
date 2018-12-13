package br.com.appiddog.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import javax.inject.Inject;

import br.com.appiddog.model.Access;
import br.com.appiddog.model.User;
import br.com.appiddog.service.IService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * class responsible for accessing the web service.
 */

public class LoginRepository {

    public IService mIservice;

    @Inject
    public LoginRepository(final  IService service){
        this.mIservice = service;

    }


    /**
     * method responsible for logging in to the server.
     * @param access
     * @return
     */
    public  LiveData<User> onLogin(final Access access) {
        final MutableLiveData<User> data = new MutableLiveData<>();


        final Call<JsonObject> call = this.mIservice.login("application/json", access);
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(final Call<JsonObject> call, final Response<JsonObject> response) {
                Gson gson = new Gson();
                User user = gson.fromJson(response.body(), User.class);
                data.setValue(user);
                }



            @Override
            public void onFailure(final Call<JsonObject> call, final Throwable t) {
                data.setValue(null);
            }
        });

        return  data;
    }


}
