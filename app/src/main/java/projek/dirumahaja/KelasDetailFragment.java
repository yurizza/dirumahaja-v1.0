package projek.dirumahaja;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class KelasDetailFragment extends Fragment {

    private TextView tvNamaKelas;
    public KelasDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kelas_detail, container, false);
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String strEmail = getActivity().getIntent().getStringExtra("email");
        int idKelas = getActivity().getIntent().getIntExtra("idKelas",0);
        String strNamaKelas = getActivity().getIntent().getStringExtra("namaKelas");
        String strSubKelas = getActivity().getIntent().getStringExtra("subKelas");
        getActivity().setTitle("Kelas "+strNamaKelas+" "+strSubKelas);

        tvNamaKelas = (TextView) view.findViewById(R.id.tv_detail_nama_kelas);
        tvNamaKelas.setText(strNamaKelas + " " + strSubKelas);

    }
}
