package projek.dirumahaja;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import projek.dirumahaja.model.User;
import projek.dirumahaja.model.kelas.KelasItem;
import projek.dirumahaja.util.PrefUtil;
import projek.dirumahaja.viewModel.KelasViewModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class KelasFragment extends Fragment {

    private KelasAdapter kelasAdapter;
    private RecyclerView rvKelas;
    private KelasViewModel kelasViewModel;

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
    }
    private Observer<ArrayList<KelasItem>> getKelas = new Observer<ArrayList<KelasItem>>() {
        @Override
        public void onChanged(ArrayList<KelasItem> kelasItems) {
            if (kelasItems != null){
                kelasAdapter.setData(kelasItems);
            }
        }
    };
}
