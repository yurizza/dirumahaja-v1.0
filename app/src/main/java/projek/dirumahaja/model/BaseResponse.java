package projek.dirumahaja.model;

import com.google.gson.annotations.SerializedName;

public class BaseResponse {

    @SerializedName("error")
    private boolean error;
    @SerializedName("message")
    private String message;

    public BaseResponse() {
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString(){
        return
                "BaseResponse{" +
                        "error = '" + error + '\'' +
                        ",message = '" + message + '\'' +
                        "}";
    }
}
