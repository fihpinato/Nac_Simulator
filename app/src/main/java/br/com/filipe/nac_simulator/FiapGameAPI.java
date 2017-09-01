package br.com.filipe.nac_simulator;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FiapGameAPI {
    @GET("/usuario/{username}/{password}")
    Call<Void> buscarUsuario(@Path(value = "username")String username, @Path(value = "password")String password);

    @GET("/avatar/{username}")
    Call<Login> buscarAvatar(@Path(value = "username")String username);

}
