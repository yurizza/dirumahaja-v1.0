package projek.dirumahaja.api.interfaces;

import projek.dirumahaja.api.config.Config;
import projek.dirumahaja.model.BaseResponse;
import projek.dirumahaja.model.User;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface UpdateProfilInterface {
    @FormUrlEncoded
    @POST(Config.API_UPDATE_PROFIL)
    Call<User> updateProfil(
            @Field("action") String action,
            @Field("email") String strEmail,
            @Field("password") String strPassword,
            @Field("nama") String strNama,
            @Field("nomorMahasiswa") String strNomorMahasiswa,
            @Field("instansi") String strInstansi);
}