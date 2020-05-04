package projek.dirumahaja.model.gabungkelas;

import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("idKelas")
	private String idKelas;

	@SerializedName("namaKelas")
	private String namaKelas;

	@SerializedName("subKelas")
	private String subKelas;

	public String getIdKelas(){
		return idKelas;
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
			"idKelas = '" + idKelas + '\'' + 
			",namaKelas = '" + namaKelas + '\'' + 
			",subKelas = '" + subKelas + '\'' + 
			"}";
		}
}