package projek.dirumahaja;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import projek.dirumahaja.api.RegisterService;
import projek.dirumahaja.api.UpdateProfilService;
import projek.dirumahaja.model.BaseResponse;
import projek.dirumahaja.model.User;
import projek.dirumahaja.util.PrefUtil;
import retrofit2.Call;
import retrofit2.Callback;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfilFragment extends Fragment {

    EditText etNama,etNomorMahasiswa,etPasswordProfil;
    TextView tvEmail;
    ImageView ivEditNama,ivEditNIM,ivEditEmail,ivSaveProfil;

    UpdateProfilService updateProfilService;

    public ProfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profil, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Profil");

        etNama = (EditText) view.findViewById(R.id.et_username);
        etNomorMahasiswa = (EditText) view.findViewById(R.id.et_nomormahasiswa);
        etPasswordProfil =(EditText) view.findViewById(R.id.et_password_profil);
        tvEmail = (TextView) view.findViewById(R.id.tv_kontak);
        ivSaveProfil = (ImageView) view.findViewById(R.id.iv_save_profil);
        ivEditNama = (ImageView) view.findViewById(R.id.iv_edit_nama);
        ivEditNIM = (ImageView) view.findViewById(R.id.iv_edit_nim);
        ivEditEmail = (ImageView) view.findViewById(R.id.iv_edit_kontak);


//        Toast.makeText(view.getContext(), user.getData().getNomorMahasiswa(), Toast.LENGTH_SHORT).show();
        User user = PrefUtil.getUser(getContext(), PrefUtil.USER_SESSION);
        etNama.setText(user.getData().getNama());
        etNomorMahasiswa.setText(user.getData().getNomorMahasiswa());
        tvEmail.setText(user.getData().getEmail());

        ivEditEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
            Toast.makeText(view.getContext(),"Untuk Edit Email dan Password hubungi DEVELOPER!", Toast.LENGTH_SHORT).show();
            }
        });
        ivSaveProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = PrefUtil.getUser(getContext(), PrefUtil.USER_SESSION);
                String strEmail = user.getData().getEmail();
                registerAct(strEmail);

            }
        });
    }
    void registerAct(String strEmail) {
//        User user = PrefUtil.getUser(getContext(), PrefUtil.USER_SESSION);
        String strNama = etNama.getText().toString();
        String strNomorMahasiswa = etNomorMahasiswa.getText().toString();
        String strPassword = etPasswordProfil.getText().toString();
        String strAction = "update";
        String strInstansi ="";

        if(TextUtils.isEmpty(strPassword)) {
            etPasswordProfil.setError("passwornyaaa..");
            return;
        }
        updateProfilService = new UpdateProfilService(this.getContext());
        updateProfilService.setUpdateProfil(strAction, strEmail,strPassword,strNama, strNomorMahasiswa,strInstansi, new Callback() {
            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(getContext(), "An error occurred!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(retrofit2.Call call, retrofit2.Response response) {
                User user = (User) response.body();

                if(user != null) {
                    if(!user.isError()) {
                        PrefUtil.putUser(getContext(), PrefUtil.USER_SESSION, user);
                        Toast.makeText(getContext(), user.getMessage(), Toast.LENGTH_SHORT).show();
                        //refresh fragment
                        FragmentTransaction t = getActivity().getSupportFragmentManager().beginTransaction();
                        t.setReorderingAllowed(false);
                        t.detach(ProfilFragment.this).attach(ProfilFragment.this).commitAllowingStateLoss();
                        etPasswordProfil.setText("");
                    }
                    Toast.makeText(getContext(), user.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
