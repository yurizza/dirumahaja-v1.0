package projek.dirumahaja;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import projek.dirumahaja.model.User;

import static android.widget.Toast.LENGTH_SHORT;

public class KelasDetailActivity extends AppCompatActivity{
    private TextView tvNamaKelas,tvKodeKelas;
    private ImageView ivUploadImage,ivUploadFile, ivSend;
    private EditText etTugas;
    private ImageButton ibShareKelasKode;
    Fragment fragment;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelas_detail);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final String strEmail = getIntent().getStringExtra("email");
        int idKelas = getIntent().getIntExtra("idKelas",0);
        final String strNamaKelas =getIntent().getStringExtra("namaKelas");
        final String strSubKelas = getIntent().getStringExtra("subKelas");
        final String strKodeKelas=getIntent().getStringExtra("kodeKelas");
        final String strPengajar = getIntent().getStringExtra("pengajar");
        tvNamaKelas = (TextView) findViewById(R.id.tv_detail_nama_kelas);
        tvNamaKelas.setText(strNamaKelas + " " + strSubKelas);
        ibShareKelasKode = (ImageButton) findViewById(R.id.ib_share_kode_kelas);
        tvKodeKelas = (TextView) findViewById(R.id.tv_kode_kelas);
        if (!strKodeKelas.equals("")){
        tvKodeKelas.setText("Kode Kelas : " +strKodeKelas);
        }else {
            tvKodeKelas.setText("");
        }
        etTugas = (EditText) findViewById(R.id.et_upload_tugas);
        ivUploadImage = (ImageView) findViewById(R.id.iv_upload_gambar);
        ivUploadFile = (ImageView) findViewById(R.id.iv_upload_file);

        ibShareKelasKode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //share kode kelas to another app

                if (strEmail.equals(strPengajar)){
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, strNamaKelas+" "+strSubKelas+"\nKode Kelas : "+strKodeKelas);
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
                }else {
                    Toast.makeText(KelasDetailActivity.this,"Hanya PENGAJAR yang bisa berbagi KODE KELAS!", LENGTH_SHORT).show();
                }
            }
        });

    }

}
