package projek.dirumahaja.api;

import android.content.Context;

import projek.dirumahaja.api.config.RetrofitBuilder;
import projek.dirumahaja.api.interfaces.UpdateProfilInterface;
import retrofit2.Callback;

public class UpdateProfilService {
    private UpdateProfilInterface updateProfilInterface;

    public UpdateProfilService(Context context) {
        updateProfilInterface = RetrofitBuilder.builder(context)
                .create(UpdateProfilInterface.class);
    }

    public void setUpdateProfil(String action, String strEmail, String strPassword,String strNama, String strNomorMahasiswa,String strInstansi, Callback callback) {
        updateProfilInterface.updateProfil(action, strEmail,strPassword,strNama,strNomorMahasiswa,strInstansi).enqueue(callback);
    }
}
