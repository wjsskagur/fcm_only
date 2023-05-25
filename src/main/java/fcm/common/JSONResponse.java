package fcm.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class JSONResponse<T> {

    private int code;

    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T info;

    public JSONResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public JSONResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public JSONResponse(int code, String message, T data, T info) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.info = info;
    }
}
