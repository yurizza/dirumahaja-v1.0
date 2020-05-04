package projek.dirumahaja.model.gabungkelas;

import com.google.gson.annotations.SerializedName;

public class GabungResponse{

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
			"GabungResponse{" + 
			"data = '" + data + '\'' + 
			",error = '" + error + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}