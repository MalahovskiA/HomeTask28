package by.malahovski.hometask28.controller;

import by.malahovski.hometask28.model.Shelf;
import by.malahovski.hometask28.service.ShelfService;
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
@RequestMapping("/shelf")
public class ShelfController {

    private final ShelfService shelfService;

    @Autowired
    public ShelfController(ShelfService shelfService) {
        this.shelfService = shelfService;
    }

    @PutMapping(value = "/add", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> addShelf(@RequestBody Shelf shelf) {
        return ResponseEntity.ok(shelfService.insertEntity(shelf));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Shelf>> getShelfById(@PathVariable Long id) {
        Optional<Shelf> shelf = shelfService.getOneById(id);
        if (isNull(shelf)) {
            throw new ArithmeticException("Полка с ID = " + id + " не найден.");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(shelf);
    }

    @GetMapping(value = "/all/{row}/{fields}")
    public ResponseEntity<List<Shelf>> findAllShelfMoreThan(@PathVariable Integer row, @PathVariable Integer fields) {
        List<Shelf> shelves = shelfService.getNumberOfRowsAndFields(row, fields);
        if (isNull(shelves)) {
            throw new ArithmeticException("Полки  не найдены");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(shelves);
    }

    @GetMapping(value = "/all/{number}")
    public ResponseEntity<Integer> countShelfMoreThan(@PathVariable Integer number) {
        Integer counts = shelfService.getNumberOfRecords(number);
        if (isNull(counts)) {
            throw new ArithmeticException("Номера полок не установлены");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(counts);
    }

    @PutMapping(value = "/update/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> updateShelf(@PathVariable Long id, @RequestBody Shelf shelf) {
        return ResponseEntity.ok(shelfService.updateById(id, shelf));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> deleteShelfById(@PathVariable Long id) {
        Boolean isDeleted = shelfService.deleteById(id);
        if (isDeleted) {
            return ResponseEntity.ok(isDeleted);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(isDeleted);
    }
}
