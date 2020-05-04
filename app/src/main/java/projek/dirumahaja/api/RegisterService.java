package projek.dirumahaja.api;
import android.content.Context;

import projek.dirumahaja.api.config.RetrofitBuilder;
import projek.dirumahaja.api.interfaces.RegisterInterface;

import retrofit2.Callback;

public class RegisterService {

    private RegisterInterface registerInterface;

    public RegisterService(Context context) {
        registerInterface = RetrofitBuilder.builder(context)
                .create(RegisterInterface.class);
    }

    public void doRegister(String strNama, String strEmail, String strPassword, String strNomorMahasiswa,String strInstansi, Callback callback) {
        registerInterface.register(strNama,strEmail,strPassword,strNomorMahasiswa,strInstansi).enqueue(callback);
    }

}