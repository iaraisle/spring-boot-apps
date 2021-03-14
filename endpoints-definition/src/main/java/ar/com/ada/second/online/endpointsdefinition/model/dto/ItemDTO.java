package ar.com.ada.second.online.endpointsdefinition.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ItemDTO implements Serializable {

    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "description is required")
    private String description;

    @NotNull(message = "numberBarcode is required")
    private Integer numberBarcode;

}

//Test post en postman
// body>raw>JSON
// {
//  "name": "Crema de Leche",
//  "description": "ideal para recetas",
//   "numberBarcode": "756345"
//}
