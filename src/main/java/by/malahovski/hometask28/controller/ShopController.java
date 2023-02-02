package by.malahovski.hometask28.controller;

import by.malahovski.hometask28.model.Shop;
import by.malahovski.hometask28.service.ShopService;
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
@RequestMapping("/shop")
public class ShopController {

    private final ShopService shopService;

    @Autowired
    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @PutMapping(value = "/add", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> addStorage(@RequestBody Shop shop) {
        return ResponseEntity.ok(shopService.insertEntity(shop));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Shop>> getStorageById(@PathVariable Long id) {
        Optional<Shop> shop = shopService.getOneById(id);
        if (isNull(shop)) {
            throw new ArithmeticException("Склад с ID = " + id + " не найден.");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(shop);
    }

    @GetMapping(value = "/all/{storageId}/{shelfId}")
    public ResponseEntity<List<Shop>> findAllStorageMoreThan(@PathVariable Long storageId, @PathVariable Integer shelfId) {
        List<Shop> shops = shopService.getStoresByWarehousesAndShelves(storageId,shelfId);
        if (isNull(shops)) {
            throw new ArithmeticException("Магазины не найдены");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(shops);
    }

    @GetMapping(value = "/all/{storageId}")
    public ResponseEntity<Integer> countStorageMoreThan(@PathVariable Long storageId) {
        Integer counts = shopService.getNumberOfRecordsStorageId(storageId);
        if (isNull(counts)) {
            throw new ArithmeticException("Склады не установлены");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(counts);
    }

    @PutMapping(value = "/update/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> updateStorage(@PathVariable Long id, @RequestBody Shop shop) {
        return ResponseEntity.ok(shopService.updateById(id, shop));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> deleteStorageById(@PathVariable Long id) {
        Boolean isDeleted = shopService.deleteById(id);
        if (isDeleted) {
            return ResponseEntity.ok(isDeleted);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(isDeleted);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Shop>> getAllShops() {
        List<Shop> shops = shopService.getAllShops();
        if (isNull(shops)) {
            throw new ArithmeticException("Магазины не найдены");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(shops);
    }

    @GetMapping(value = "/allSQL")
    public ResponseEntity<List<Shop>> getAllShopsSQL() {
        List<Shop> shops = shopService.getAlLShopsBySQL();
        if (isNull(shops)) {
            throw new ArithmeticException("Магазины не найдены");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(shops);
    }
}
