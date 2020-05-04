package projek.dirumahaja.model;

import java.util.ArrayList;

public class UserData {

    private String nama;
    private String email;
    private String password;
    private String nomorMahasiswa;
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
}