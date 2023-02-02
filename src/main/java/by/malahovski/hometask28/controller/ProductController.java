package by.malahovski.hometask28.controller;


import by.malahovski.hometask28.model.Product;
import by.malahovski.hometask28.service.ProductService;
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
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PutMapping(value = "/add", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> addProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.insertEntity(product));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Product>> getProductById(@PathVariable Long id) {
        Optional<Product> product = productService.getOneById(id);
        if (isNull(product)) {
            throw new ArithmeticException("Продукт с ID = " + id + " не найден.");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(product);
    }

    @GetMapping(value = "/all/{count}/{price}")
    public ResponseEntity<List<Product>> findAllProductsMoreThan(@PathVariable Integer count, @PathVariable Double price) {
        List<Product> products = productService.getAllByMoreTheCountAndPrice(count, price);
        if (isNull(products)) {
            throw new ArithmeticException("Продукт не найдены");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(products);
    }

    @GetMapping(value = "/all/{price}")
    public ResponseEntity<Integer> countProductByPriceMoreThan(@PathVariable Double price) {
        Integer counts = productService.getNumberOfRecordsMorePrice(price);
        if (isNull(counts)) {
            throw new ArithmeticException("Цены на продукты не установлены");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(counts);
    }

    @PutMapping(value = "/update/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return ResponseEntity.ok(productService.updateById(id, product));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> deleteProductById(@PathVariable Long id) {
        Boolean isDeleted = productService.deleteById(id);
        if (isDeleted) {
            return ResponseEntity.ok(isDeleted);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(isDeleted);
    }
}
