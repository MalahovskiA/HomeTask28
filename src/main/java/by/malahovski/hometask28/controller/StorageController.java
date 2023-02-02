package by.malahovski.hometask28.controller;


import by.malahovski.hometask28.model.Storage;
import by.malahovski.hometask28.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Controller
@ResponseBody
@RequestMapping("/storage")
public class StorageController {

    private final StorageService storageService;

    @Autowired
    public StorageController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PutMapping(value = "/add", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> addStorage(@RequestBody Storage storage) {
        return ResponseEntity.ok(storageService.insertEntity(storage));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Storage>> getStorageById(@PathVariable Long id) {
        Optional<Storage> storage = storageService.getOneById(id);
        if (isNull(storage)) {
            throw new ArithmeticException("Склад с ID = " + id + " не найден.");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(storage);
    }

    @GetMapping(value = "/all/{id}/{area}")
    public ResponseEntity<List<Storage>> findAllStorageMoreThan(@PathVariable Long id, @PathVariable Double area) {
        List<Storage> storages = storageService.getStorageByMoreTheIdAndArea(id,area);
        if (isNull(storages)) {
            throw new ArithmeticException("Склады не найдены");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(storages);
    }

    @GetMapping(value = "/all/{area}")
    public ResponseEntity<Integer> countStorageMoreThan(@PathVariable Double area) {
        Integer counts = storageService.getNumberOfRecordsArea(area);
        if (isNull(counts)) {
            throw new ArithmeticException("Склады не установлены");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(counts);
    }

    @PutMapping(value = "/update/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> updateStorage(@PathVariable Long id, @RequestBody Storage storage) {
        return ResponseEntity.ok(storageService.updateById(id, storage));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> deleteStorageById(@PathVariable Long id) {
        Boolean isDeleted = storageService.deleteById(id);
        if (isDeleted) {
            return ResponseEntity.ok(isDeleted);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(isDeleted);
    }
}
