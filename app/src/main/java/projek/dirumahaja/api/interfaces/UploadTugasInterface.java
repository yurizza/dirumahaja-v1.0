package projek.dirumahaja.api.interfaces;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import projek.dirumahaja.api.config.Config;
import projek.dirumahaja.model.BaseResponse;
import projek.dirumahaja.model.buatkelas.BuatKelasResponse;
import projek.dirumahaja.model.uploadtugas.UploadTugasResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface UploadTugasInterface {
    @FormUrlEncoded
    @POST(Config.API_TUGAS)
    Call<UploadTugasResponse> uploadPhotoBase64(
            @Field("action") String action,
            @Field("email") String email,
            @Field("idKelas") int idKelas,
            @Field("judulTugas") String judulTugas,
            @Field("deskripsiTugas") String deskripsi,
            @Field("tanggalTenggat") String tanggalTenggat,
            @Field("photo") String photo);
}
