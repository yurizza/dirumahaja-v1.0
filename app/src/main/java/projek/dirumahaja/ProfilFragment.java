package projek.dirumahaja;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import projek.dirumahaja.model.User;
import projek.dirumahaja.util.PrefUtil;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfilFragment extends Fragment {

    TextView tvNama,tvNomorMahasiswa,tvEmail;
    ImageView ivEditNama,ivEditNIM,ivEditEmail;
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

        tvNama = (TextView) view.findViewById(R.id.tv_username);
        tvNomorMahasiswa = (TextView) view.findViewById(R.id.tv_nomormahasiswa);
        tvEmail = (TextView) view.findViewById(R.id.tv_kontak);
        ivEditNama = (ImageView) view.findViewById(R.id.iv_edit_nama);
        ivEditNIM = (ImageView) view.findViewById(R.id.iv_edit_nim);
        ivEditEmail = (ImageView) view.findViewById(R.id.iv_edit_kontak);

        User user = PrefUtil.getUser(view.getContext(), PrefUtil.USER_SESSION);
//        Toast.makeText(view.getContext(), user.getData().getNomorMahasiswa(), Toast.LENGTH_SHORT).show();

        tvNama.setText(user.getData().getNama());
        tvNomorMahasiswa.setText(user.getData().getNomorMahasiswa());
        tvEmail.setText(user.getData().getEmail());

        ivEditEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
            Toast.makeText(view.getContext(),"Untuk Edit Email hubungi DEVELOPER!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
