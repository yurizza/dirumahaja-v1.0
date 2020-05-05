package projek.dirumahaja;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import projek.dirumahaja.model.User;
import projek.dirumahaja.model.kelas.KelasItem;
import projek.dirumahaja.util.PrefUtil;
import projek.dirumahaja.viewModel.KelasViewModel;

public class KelasAdapter extends RecyclerView.Adapter<KelasAdapter.ViewHolder> {
   private ArrayList<KelasItem> kelasItems=new ArrayList<>();
   private Context context;

    public KelasAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<KelasItem> items){
        kelasItems.clear();
        kelasItems.addAll(items);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public KelasAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview_kelas,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KelasAdapter.ViewHolder holder, int position) {
        holder.tvNamaKelas.setText(kelasItems.get(position).getNamaKelas());
        holder.tvSubKelas.setText(kelasItems.get(position).getSubKelas());
        holder.tvPengajar.setText(kelasItems.get(position).getPengajar());
    }

    @Override
    public int getItemCount() {
        return kelasItems.size();
    }

    public class  ViewHolder extends RecyclerView.ViewHolder {
        User user = PrefUtil.getUser(context, PrefUtil.USER_SESSION);
        TextView tvNamaKelas,tvSubKelas,tvPengajar;
        CardView cvKelas;
        LinearLayout layoutItemList;
        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            tvNamaKelas = itemView.findViewById(R.id.tv_nama_kelas);
            tvSubKelas = itemView.findViewById(R.id.tv_sub_kelas);
            tvPengajar = itemView.findViewById(R.id.tv_pengajar);
            cvKelas = itemView.findViewById(R.id.cv_kelas);
            layoutItemList= itemView.findViewById(R.id.layout_item_list_kelas);
            layoutItemList.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();

                    intent = new Intent(context, KelasDetailActivity.class);
                    intent.putExtra("email",user.getData().getEmail());
//                    Toast.makeText(v.getContext(),user.getData().getEmail(), Toast.LENGTH_SHORT).show();
                    intent.putExtra("idKelas",kelasItems.get(getAdapterPosition()).getIdKelas());
                    intent.putExtra("namaKelas",kelasItems.get(getAdapterPosition()).getNamaKelas());
                    intent.putExtra("subKelas",kelasItems.get(getAdapterPosition()).getSubKelas());
                    intent.putExtra("kodeKelas",kelasItems.get(getAdapterPosition()).getKodeKelas());
                    intent.putExtra("pengajar",kelasItems.get(getAdapterPosition()).getPengajar());
                    v.getContext().startActivity(intent);
                }
            });
        }
    }
}
