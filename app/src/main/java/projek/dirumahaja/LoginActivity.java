package projek.dirumahaja;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import okhttp3.Call;
import okhttp3.Response;
import projek.dirumahaja.api.LoginService;
import projek.dirumahaja.model.User;
import projek.dirumahaja.util.PrefUtil;
import retrofit2.Callback;

public class LoginActivity extends AppCompatActivity {
    private EditText etEmail,etPassword;
    private Button btnLogin;
    private TextView tvDaftar;
    private LoginService loginService;
    ProgressDialog progressDialog;

    public static void start(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Login...");
        if(isSessionLogin()) {
            Main2Activity.start(this);
            LoginActivity.this.finish();
        }

        etEmail = (EditText) findViewById(R.id.et_email);
        etPassword = (EditText) findViewById(R.id.et_password);
        tvDaftar = (TextView) findViewById(R.id.tv_daftar);
        btnLogin = (Button) findViewById(R.id.btn_login);

        tvDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, DaftarActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginAct();
            }
        });
    }
    void loginAct() {
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        if(TextUtils.isEmpty(email)) {
            etEmail.setError("Email cannot be empty!");
            return;
        }

        if(TextUtils.isEmpty(password)) {
            etPassword.setError("Password cannot be empty");
            return;
        }

        progressDialog.show();
        loginService = new LoginService(this);
        loginService.doLogin(email, password, new Callback() {
            @Override
            public void onResponse(retrofit2.Call call, retrofit2.Response response) {
                User user = (User) response.body();

                if(user != null) {
                    if(!user.isError()) {
                        PrefUtil.putUser(LoginActivity.this, PrefUtil.USER_SESSION, user);
//                        Toast.makeText(LoginActivity.this,user.getData().getEmail(),Toast.LENGTH_SHORT).show();
                        Main2Activity.start(LoginActivity.this);
                        LoginActivity.this.finish();
                    }

                    Toast.makeText(LoginActivity.this, user.getMessage(), Toast.LENGTH_SHORT).show();
                }
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(retrofit2.Call call, Throwable t) {
                Toast.makeText(LoginActivity.this, "An error occurred!", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }

        });
    }

    boolean isSessionLogin()
    {
        return PrefUtil.getUser(this, PrefUtil.USER_SESSION) != null;
    }
}
