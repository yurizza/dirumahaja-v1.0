package projek.dirumahaja.api.interfaces;

import projek.dirumahaja.api.config.Config;
import projek.dirumahaja.model.gabungkelas.GabungResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface GabungKelasInterface {
    @FormUrlEncoded
    @POST(Config.API_BUATnGABUNG_KELAS)
    Call<GabungResponse> gabungKelas(
            @Field("action") String action,
            @Field("idGabung") String idGabung,
            @Field("email") String email);
}
