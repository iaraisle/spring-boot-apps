package ar.com.ada.second.online.endpointsdefinition.controller;

import ar.com.ada.second.online.endpointsdefinition.model.dto.ItemDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping(value = "/items")
public class ItemController {


    //Test get en postman
    @GetMapping({"/", ""})
    public ResponseEntity getItemsMethod() {
        List<ItemDTO> items = Arrays.asList(
                new ItemDTO(1L, "Cocacola", "Bebida gaseosa", 123456),
                new ItemDTO(2L, "Palitos salados", "Snack", 123457),
                new ItemDTO(3L, "Cerveza heineken", "Bebida rica", 123458)
                );
        return ResponseEntity.ok().body(items);
    }


    @PostMapping
    public ResponseEntity postItemMethod(@Valid @RequestBody ItemDTO item) throws URISyntaxException {
        //el request no pide id pero el dto si así que asignamos un id random
        Long id = Math.abs(new Random().nextLong()) % 100;
        item.setId(id);
        URI uri = new URI("/items/" + id);

        return ResponseEntity.created(uri).body(item);
    }
}