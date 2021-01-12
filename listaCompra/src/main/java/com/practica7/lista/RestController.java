package com.practica7.lista;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@CrossOrigin(origins = "*") //Permitir acceso cruzado con el CORS!

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/item")

public class RestController {

    private HashMap<Integer, Item> mapItem = new HashMap<>();
    private int itemID = 1;


    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public ResponseEntity<Item> addItem(@RequestBody Item item) {
        if (item != null) {

            item.setID(itemID);
            mapItem.put(itemID, item);
            itemID++;
            return new ResponseEntity<>(item, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<HashMap<Integer, Item>> getAllItems() {

        return new ResponseEntity<HashMap<Integer, Item>>(this.mapItem, HttpStatus.OK);
    }

    @RequestMapping(value = "modify/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Item> modifyItem(@RequestBody Item item, @PathVariable int id) {
        if (item != null && mapItem.get(id).getClass() == Item.class) {
            mapItem.get(id).setName(item.getName());
            mapItem.get(id).setDescription(item.getDescription());
            mapItem.get(id).setPrice(item.getPrice());
            mapItem.get(id).setBought(item.isBought());
            return new ResponseEntity<>(mapItem.get(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Item> deleteItem(@PathVariable int id) {
        Item deletedItem = mapItem.get(id);
        if (mapItem.remove(id, deletedItem)) {
            return new ResponseEntity<>(deletedItem, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/getOne/{id}")
    public ResponseEntity<Item> getOneItem(@PathVariable int id) {

        if (mapItem.get(id) != null) {
            return new ResponseEntity<>(mapItem.get(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
        }
    }
}
//TODO: Recoger errorres!