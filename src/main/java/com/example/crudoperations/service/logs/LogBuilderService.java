package com.example.crudoperations.service.logs;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

@Component
public class LogBuilderService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private  ObjectMapper objectMapper;

    public String log(String message, Throwable throwable) {
        if (throwable instanceof WebApplicationException) {
            return logWebApplicationException(message, (WebApplicationException) throwable);
        }
        return logThrowable(message, throwable);
    }

    public String logWebApplicationException(String message, WebApplicationException we) {
        Response response = we.getResponse();
        int status = (null != response ? response.getStatus() : -1);
        Object responseBody = (null != response ? response.getEntity() : null);
        String jsonResponseBody = jsonParseOrNone(responseBody);
        return message  +
                " http_status=" + status +
                " response_body=" + jsonResponseBody;
    }

    public String logThrowable(String message, Throwable throwable) {
        return message +
                " message=" + throwable.getMessage();
    }

    private String jsonParseOrNone(Object responseBody) {
        String jsonResponseBody = "none";
        try {
            jsonResponseBody=objectMapper.writeValueAsString(responseBody);
        } catch (JsonProcessingException jpe) {
            log.error("Unable to serialize response body!", jpe);
        }
        return jsonResponseBody;
    }
}
