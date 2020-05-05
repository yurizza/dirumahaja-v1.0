package projek.dirumahaja.model.kelas;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class KelasItem{

	@SerializedName("anggotaKelas")
	private ArrayList<String> anggotaKelas;

	@SerializedName("idKelas")
	private int idKelas;

	@SerializedName("kodeKelas")
	private String kodeKelas;

	@SerializedName("namaKelas")
	private String namaKelas;

	@SerializedName("subKelas")
	private String subKelas;

	@SerializedName("pengajar")
	private String pengajar;

	public void setAnggotaKelas(ArrayList<String> anggotaKelas){
		this.anggotaKelas = anggotaKelas;
	}

	public ArrayList<String> getAnggotaKelas(){
		return anggotaKelas;
	}

	public int getIdKelas() {
		return idKelas;
	}

	public void setIdKelas(int idKelas) {
		this.idKelas = idKelas;
	}

	public String getKodeKelas() {
		return kodeKelas;
	}

	public void setKodeKelas(String kodeKelas) {
		this.kodeKelas = kodeKelas;
	}

	public void setNamaKelas(String namaKelas){
		this.namaKelas = namaKelas;
	}

	public String getNamaKelas(){
		return namaKelas;
	}

	public void setSubKelas(String subKelas){
		this.subKelas = subKelas;
	}

	public String getSubKelas(){
		return subKelas;
	}

	public void setPengajar(String pengajar){
		this.pengajar = pengajar;
	}

	public String getPengajar(){
		return pengajar;
	}

	@Override
 	public String toString(){
		return 
			"KelasItem{" + 
			"anggotaKelas = '" + anggotaKelas + '\'' + 
			",namaKelas = '" + namaKelas + '\'' + 
			",subKelas = '" + subKelas + '\'' + 
			",pengajar = '" + pengajar + '\'' +
			",kodeKelas = '"+kodeKelas+'\''+
			"}";
		}
}