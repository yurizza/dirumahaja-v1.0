package projek.dirumahaja;
import projek.dirumahaja.api.RegisterService;
import projek.dirumahaja.model.BaseResponse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import retrofit2.Call;
import retrofit2.Callback;

public class DaftarActivity extends AppCompatActivity {
    EditText etNama,etEmail,etPassword,etNomorMahasiswa,etInstansi;
    Button btnDaftar;

    private RegisterService registerService;

    public static void start(Context context) {
        Intent intent = new Intent(context, DaftarActivity.class);
        context.startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        etNama = (EditText) findViewById(R.id.et_daf_nama);
        etEmail = (EditText) findViewById(R.id.et_daf_email);
        etPassword = (EditText) findViewById(R.id.et_daf_password);
        etInstansi = (EditText) findViewById(R.id.et_daf_instansi);
        etNomorMahasiswa = (EditText) findViewById(R.id.et_daf_nomorMahasiswa);
        btnDaftar =(Button) findViewById(R.id.btn_daftar);

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerAct();
            }
        });
    }
    void registerAct() {
        String strNama = etNama.getText().toString();
        String strEmail = etEmail.getText().toString();
        String strPassword = etPassword.getText().toString();
        String strNomorMahasiswa = etNomorMahasiswa.getText().toString();
        String strInstansi = etInstansi.getText().toString();

        if(TextUtils.isEmpty(strNama)) {
            etNama.setError("Name cannot be empty !");
            return;
        }

        if(TextUtils.isEmpty(strEmail)) {
            etEmail.setError("Email cannot be empty !");
            return;
        }

        if(TextUtils.isEmpty(strPassword)) {
            etPassword.setError("Password cannot be empty !");
            return;
        }

        registerService = new RegisterService(this);
        registerService.doRegister(strNama, strEmail,strPassword, strNomorMahasiswa,strInstansi, new Callback() {
            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(DaftarActivity.this, "An error occurred!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(retrofit2.Call call, retrofit2.Response response) {
                BaseResponse baseResponse = (BaseResponse) response.body();

                if(baseResponse != null) {
                    if(!baseResponse.isError()) {
                        Toast.makeText(DaftarActivity.this, baseResponse.getMessage(), Toast.LENGTH_SHORT).show();
                        LoginActivity.start(DaftarActivity.this);
                        DaftarActivity.this.finish();
                    }
                    Toast.makeText(DaftarActivity.this, baseResponse.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
