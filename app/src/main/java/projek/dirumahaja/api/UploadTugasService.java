package projek.dirumahaja.api;

import android.content.Context;

import projek.dirumahaja.api.config.RetrofitBuilder;
import projek.dirumahaja.api.interfaces.UploadTugasInterface;
import retrofit2.Callback;

public class UploadTugasService {
    private UploadTugasInterface uploadTugasInterface;
    public UploadTugasService(Context context){
        uploadTugasInterface = RetrofitBuilder.builder(context).create(UploadTugasInterface.class);
    }


    public void setTugasService(String action, String email, int idKelas, String judulTugas, String deskripsiTugas, String tanggalTenggat, String photo, Callback callback){
        uploadTugasInterface.uploadPhotoBase64(action, email, idKelas,judulTugas,deskripsiTugas,tanggalTenggat,photo).enqueue(callback);
    }
}
