package projek.dirumahaja.model.kelas;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class KelasResponse{

	@SerializedName("kelas")
	private ArrayList<KelasItem> kelas;

	@SerializedName("error")
	private boolean error;

	@SerializedName("message")
	private String message;

	public void setKelas(ArrayList<KelasItem> kelas){
		this.kelas = kelas;
	}

	public ArrayList<KelasItem> getKelas(){
		return kelas;
	}

	public void setError(boolean error){
		this.error = error;
	}

	public boolean isError(){
		return error;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	@Override
 	public String toString(){
		return 
			"KelasResponse{" + 
			"kelas = '" + kelas + '\'' + 
			",error = '" + error + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}