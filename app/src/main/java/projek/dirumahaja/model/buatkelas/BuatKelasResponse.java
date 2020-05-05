package projek.dirumahaja.model.buatkelas;

import com.google.gson.annotations.SerializedName;

public class BuatKelasResponse{

	@SerializedName("data")
	private Data data;

	@SerializedName("error")
	private boolean error;

	@SerializedName("message")
	private String message;

	public Data getData(){
		return data;
	}

	public boolean isError(){
		return error;
	}

	public String getMessage(){
		return message;
	}

	@Override
 	public String toString(){
		return 
			"BuatKelasResponse{" + 
			"data = '" + data + '\'' + 
			",error = '" + error + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}