package projek.dirumahaja;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class KelasDetailActivity extends AppCompatActivity{
    private TextView tvNamaKelas,tvKodeKelas;
    private ImageView ivUploadImage,ivUploadFile, ivSend;
    private EditText etTugas;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelas_detail);

        String strEmail = getIntent().getStringExtra("email");
        int idKelas = getIntent().getIntExtra("idKelas",0);
        String strNamaKelas =getIntent().getStringExtra("namaKelas");
        String strSubKelas = getIntent().getStringExtra("subKelas");
        String strKodeKelas=getIntent().getStringExtra("kodeKelas");
        tvNamaKelas = (TextView) findViewById(R.id.tv_detail_nama_kelas);
        tvNamaKelas.setText(strNamaKelas + " " + strSubKelas);

        tvKodeKelas = (TextView) findViewById(R.id.tv_kode_kelas);
        tvKodeKelas.setText("Kode Kelas : " +strKodeKelas);
        etTugas = (EditText) findViewById(R.id.et_upload_tugas);
        ivUploadImage = (ImageView) findViewById(R.id.iv_upload_gambar);
        ivUploadFile = (ImageView) findViewById(R.id.iv_upload_file);

    }

}
