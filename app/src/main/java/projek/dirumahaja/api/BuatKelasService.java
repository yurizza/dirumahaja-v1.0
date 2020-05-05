package projek.dirumahaja.api;

import android.content.Context;

import retrofit2.Callback;
import projek.dirumahaja.api.config.RetrofitBuilder;
import projek.dirumahaja.api.interfaces.BuatKelasInterface;

public class BuatKelasService {
    private BuatKelasInterface buatKelasInterface;
    public BuatKelasService(Context context){
        buatKelasInterface = RetrofitBuilder.builder(context).create(BuatKelasInterface.class);
    }
    public void setKelasService(String action, String namaKelas, String subKelas, String email, Callback callback){
        buatKelasInterface.setKelas(action, namaKelas, subKelas, email).enqueue(callback);
    }
}
