package projek.dirumahaja.viewModel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import java.util.ArrayList;

import projek.dirumahaja.LoginActivity;
import projek.dirumahaja.api.KelasService;
import projek.dirumahaja.model.User;
import projek.dirumahaja.model.UserData;
import projek.dirumahaja.model.kelas.KelasItem;
import projek.dirumahaja.model.kelas.KelasResponse;
import projek.dirumahaja.util.PrefUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KelasViewModel extends ViewModel{
    private KelasService kelasService;

    private MutableLiveData<ArrayList<KelasItem>> listMutableLiveData = new MutableLiveData<ArrayList<KelasItem>>();

    public void setKelas(String email){
        if (this.kelasService ==null){
            kelasService = new KelasService();
        }
        kelasService.getApiKelas().getKelas(email).enqueue(new Callback<KelasResponse>() {
            @Override
            public void onResponse(Call<KelasResponse> call, Response<KelasResponse> response) {
                KelasResponse kelasResponse = response.body();
                if (kelasResponse!=null && !kelasResponse.isError()){

                    ArrayList<KelasItem> kelasItem = kelasResponse.getKelas();
                    listMutableLiveData.postValue(kelasItem);
                }
            }

            @Override
            public void onFailure(Call<KelasResponse> call, Throwable t) {

            }
        });
    }
    public LiveData<ArrayList<KelasItem>> getKelas(){
        return listMutableLiveData;
    }
}
