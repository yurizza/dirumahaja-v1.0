package projek.dirumahaja.api.interfaces;

import projek.dirumahaja.api.config.Config;
import projek.dirumahaja.model.buatkelas.BuatKelasResponse;
import projek.dirumahaja.model.kelas.KelasResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface BuatKelasInterface {
    @FormUrlEncoded
    @POST(Config.API_BUATnGABUNG_KELAS)
    Call<BuatKelasResponse> setKelas(
            @Field("action") String action,
            @Field("namaKelas") String namaKelas,
            @Field("subKelas") String subKelas,
            @Field("email") String email
    );
}
