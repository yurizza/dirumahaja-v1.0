package projek.dirumahaja.api.interfaces;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import projek.dirumahaja.api.config.Config;
import projek.dirumahaja.model.buatkelas.BuatKelasResponse;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface UploadTugasInterface {
    @POST(Config.API_BUATnGABUNG_KELAS)
    Call<BuatKelasResponse> uploadTugas(
            @Part MultipartBody file,
            @Part("filename") RequestBody name
    );
}
