package projek.dirumahaja.api;

import android.content.Context;

import projek.dirumahaja.api.config.RetrofitBuilder;
import projek.dirumahaja.api.interfaces.GabungKelasInterface;
import retrofit2.Callback;

public class GabungKelasService {
    private GabungKelasInterface gabungKelasInterface;
    public GabungKelasService(Context context) {
        gabungKelasInterface = RetrofitBuilder.builder(context)
                .create(GabungKelasInterface.class);
    }

    public void setGabungKelas(String action,String idGabung, String email, Callback callback) {
        gabungKelasInterface.gabungKelas(action,idGabung,email).enqueue(callback);
    }
}
