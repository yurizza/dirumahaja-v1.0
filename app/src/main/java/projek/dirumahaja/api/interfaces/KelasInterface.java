package projek.dirumahaja.api.interfaces;

import projek.dirumahaja.api.config.Config;
import projek.dirumahaja.model.kelas.KelasResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface KelasInterface {
    @POST(Config.API_KELAS+"/")
    Call<KelasResponse> getKelas(
            @Query("email") String email
    );
}
