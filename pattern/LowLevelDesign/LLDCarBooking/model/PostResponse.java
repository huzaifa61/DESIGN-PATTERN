package LLDCarBooking.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostResponse {
    public static final String OK_RESPONSE = "success";
    public static final String ERROR = "error";

    @JsonProperty private String status;
    @JsonProperty private String message;

    public PostResponse ok() {
        return new PostResponse(OK_RESPONSE,null);
    }
    public PostResponse error(final String message) {
        return new PostResponse(ERROR,message);
    }



}
