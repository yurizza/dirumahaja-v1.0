package projek.dirumahaja.model.buatkelas;

import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("kodeKelas")
	private String kodeKelas;

	@SerializedName("namaKelas")
	private String namaKelas;

	@SerializedName("subKelas")
	private String subKelas;

	public String getKodeKelas() {
		return kodeKelas;
	}

	public String getNamaKelas(){
		return namaKelas;
	}

	public String getSubKelas(){
		return subKelas;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"namaKelas = '" + namaKelas + '\'' + 
			",subKelas = '" + subKelas + '\'' +
			",kodeKelas = '" + kodeKelas + '\'' +
			"}";
		}
}