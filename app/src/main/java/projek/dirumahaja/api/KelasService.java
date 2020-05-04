package projek.dirumahaja.api;

import android.content.Context;

import projek.dirumahaja.api.config.Config;
import projek.dirumahaja.api.config.RetrofitBuilder;
import projek.dirumahaja.api.interfaces.KelasInterface;
import projek.dirumahaja.model.kelas.KelasResponse;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class KelasService {
    private Retrofit retrofit;
    public KelasInterface getApiKelas(){
        if (retrofit == null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(Config.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(KelasInterface.class);
    }
}
