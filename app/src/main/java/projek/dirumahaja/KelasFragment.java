package projek.dirumahaja;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import projek.dirumahaja.api.GabungKelasService;
import projek.dirumahaja.model.User;
import projek.dirumahaja.model.gabungkelas.GabungResponse;
import projek.dirumahaja.model.kelas.KelasItem;
import projek.dirumahaja.util.PrefUtil;
import projek.dirumahaja.viewModel.KelasViewModel;
import retrofit2.Call;
import retrofit2.Callback;


/**
 * A simple {@link Fragment} subclass.
 */
public class KelasFragment extends Fragment {

    private KelasAdapter kelasAdapter;
    private RecyclerView rvKelas;
    private KelasViewModel kelasViewModel;
    private Button btnBuatKelas,btnGabungKelas;
    private EditText etIdGabung;

    GabungKelasService gabungKelasService;
    public KelasFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kelas, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Kelas");

        User user = PrefUtil.getUser(view.getContext(), PrefUtil.USER_SESSION);

        kelasAdapter = new KelasAdapter(getContext());
        kelasAdapter.notifyDataSetChanged();

        rvKelas = view.findViewById(R.id.rv_list_kelas);
        rvKelas.setLayoutManager(new GridLayoutManager(getContext(),1));

        kelasViewModel = new ViewModelProvider(requireActivity()).get(KelasViewModel.class);
        kelasViewModel.setKelas(user.getData().getEmail());
        kelasViewModel.getKelas().observe(this,getKelas);
        rvKelas.setAdapter(kelasAdapter);

        etIdGabung = view.findViewById(R.id.et_kode_kelas);
        btnGabungKelas = (Button) view.findViewById(R.id.btn_gabung_kelas);
        btnGabungKelas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gabungAct();
            }
        });
    }
    private Observer<ArrayList<KelasItem>> getKelas = new Observer<ArrayList<KelasItem>>() {
        @Override
        public void onChanged(ArrayList<KelasItem> kelasItems) {
            if (kelasItems != null){
                kelasAdapter.setData(kelasItems);
            }
        }
    };

    void gabungAct() {
        User user = PrefUtil.getUser(getContext(), PrefUtil.USER_SESSION);
        String strIdgabung = etIdGabung.getText().toString();
        String action = "gabung";
        String email = user.getData().getEmail();

        if(TextUtils.isEmpty(strIdgabung)) {
            etIdGabung.setError("Kode Kelas Kosong!");
            return;
        }

        gabungKelasService = new GabungKelasService(getContext());
        gabungKelasService.setGabungKelas(action,strIdgabung,email, new Callback() {
            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(getContext(), "An error occurred!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(retrofit2.Call call, retrofit2.Response response) {
                GabungResponse gabungResponse = (GabungResponse) response.body();

                if(gabungResponse != null) {
                    if(!gabungResponse.isError()) {
                        Toast.makeText(getContext(), gabungResponse.getMessage(), Toast.LENGTH_SHORT).show();
                        FragmentTransaction t = getActivity().getSupportFragmentManager().beginTransaction();
                        t.setReorderingAllowed(false);
                        t.detach(KelasFragment.this).attach(KelasFragment.this).commitAllowingStateLoss();
                    }
                    Toast.makeText(getContext(), gabungResponse.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
