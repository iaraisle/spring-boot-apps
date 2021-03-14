package ar.com.ada.second.online.endpointsdefinition.advice.validation;

import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
//tipo de clase generic <T> todos los tipos internos se van a acoplar al tipo de dato que les pase
public class RestErrorsResponse<T> {

        private Timestamp timestamp;
        private Integer status;
        private String error;
        private List<T> errors;

        public RestErrorsResponse(Integer status, String error, List<T> errors) {
            this.timestamp = new Timestamp(System.currentTimeMillis()); //millis = milliseconds
            this.status = status;
            this.error = error;
            this.errors = errors;
        }
}
