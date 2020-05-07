package projek.dirumahaja;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import projek.dirumahaja.api.BuatKelasService;
import projek.dirumahaja.model.User;
import projek.dirumahaja.model.buatkelas.BuatKelasResponse;
import projek.dirumahaja.util.PrefUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BuatKelasActivity extends AppCompatActivity {
    BuatKelasService buatKelasService;
    private BuatKelasResponse buatKelasResponse;
    private EditText etNamaKelas,etSubKelas;
    private Button btnBuatKelas;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat_kelas);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("OnCreating..");
        etNamaKelas = findViewById(R.id.et_nama_kelas);
        etSubKelas = findViewById(R.id.et_sub_kelas);
        btnBuatKelas = findViewById(R.id.btn_buat_kelas);
        btnBuatKelas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buatKelasAct();
            }
        });

    }

    private void buatKelasAct() {
        User user = PrefUtil.getUser(this, PrefUtil.USER_SESSION);
        final String strNamaKelas = etNamaKelas.getText().toString();
        final String strSubKelas = etSubKelas.getText().toString();

        String action = "buat";
        final String email = user.getData().getEmail();

        if(TextUtils.isEmpty(strNamaKelas)) {
            etNamaKelas.setError("Nama Kelas Kosong!");
            return;
        }
        progressDialog.show();
        buatKelasService = new BuatKelasService(this);
        buatKelasService.setKelasService(action, strNamaKelas, strSubKelas, email, new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                buatKelasResponse = (BuatKelasResponse) response.body();
                if (buatKelasResponse != null){
                    if (!buatKelasResponse.isError()){
                        Toast.makeText(BuatKelasActivity.this, buatKelasResponse.getMessage(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(BuatKelasActivity.this,KelasDetailActivity.class);
                        intent.putExtra("pengajar",email);
                        intent.putExtra("email",email);
                        intent.putExtra("namaKelas", strNamaKelas);
                        intent.putExtra("subKelas",strSubKelas);
                        intent.putExtra("kodeKelas", buatKelasResponse.getData().getKodeKelas());
                        startActivity(intent);
                        BuatKelasActivity.this.finish();
                    }
                    Toast.makeText(BuatKelasActivity.this, buatKelasResponse.getMessage(), Toast.LENGTH_SHORT).show();
                }
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(BuatKelasActivity.this, "An error occurred!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
