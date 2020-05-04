package projek.dirumahaja.api.interfaces;
import projek.dirumahaja.model.BaseResponse;
import projek.dirumahaja.api.config.Config;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RegisterInterface {

    @FormUrlEncoded
    @POST(Config.API_REGISTER)
    Call<BaseResponse> register(
            @Field("nama") String strNama,
            @Field("email") String strEmail,
            @Field("password") String strPassword,
            @Field("nomorMahasiswa") String strNomorMahasiswa,
            @Field("instansi") String strInstansi);
}
