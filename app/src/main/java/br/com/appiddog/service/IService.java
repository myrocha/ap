package br.com.appiddog.service;

import com.google.gson.JsonObject;

import br.com.appiddog.model.Access;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface IService {
    /**
     *
     * @param contentType
     * @return
     */

    @POST("/signup")
    Call<JsonObject> login(@Header("Content-Type") String contentType, @Body Access access);
}
