package projek.dirumahaja.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class UserData {

    @SerializedName("nama")
    private String nama;
    @SerializedName("email")
    private String email;
    @SerializedName("password")
    private String password;
    @SerializedName("nomorMahasiswa")
    private String nomorMahasiswa;
    @SerializedName("instansi")
    private String instansi;

    public UserData() {
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNomorMahasiswa() {
        return nomorMahasiswa;
    }

    public void setNomorMahasiswa(String nomorMahasiswa) {
        this.nomorMahasiswa = nomorMahasiswa;
    }

    public String getInstansi() {
        return instansi;
    }

    public void setInstansi(String instansi) {
        this.instansi = instansi;
    }
    @Override
    public String toString(){
        return
                "Data{" +
                        "nama = '" + nama + '\'' +
                        ",email = '" + email + '\'' +
                        ",password = '" + password + '\'' +
                        "nomorMahasiswa = '" + nomorMahasiswa + '\'' +
                        "instansi = '" + instansi + '\'' +
                        "}";
    }
}