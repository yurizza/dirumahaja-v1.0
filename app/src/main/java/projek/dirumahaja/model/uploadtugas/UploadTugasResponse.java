package projek.dirumahaja.model.uploadtugas;

import com.google.gson.annotations.SerializedName;

public class UploadTugasResponse{

	@SerializedName("error")
	private boolean error;

	@SerializedName("message")
	private String message;

	public boolean isError(){
		return error;
	}

	public String getMessage(){
		return message;
	}

	@Override
 	public String toString(){
		return 
			"UploadTugasResponse{" + 
			"error = '" + error + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}