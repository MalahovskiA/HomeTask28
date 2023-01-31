package by.malahovski.hometask28.service.impl;

import by.malahovski.hometask28.model.Product;
import by.malahovski.hometask28.repository.ProductRepository;
import by.malahovski.hometask28.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Boolean insertEntity(Product entity) {
        if (productRepository.findAll().contains(entity)) {
            return false;
        } else {
            productRepository.save(entity);
            return true;
        }
    }

    @Override
    public Optional<Product> getOneById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Boolean updateById(Long id, Product entity) {
        if (productRepository.existsById(id)) {
            productRepository.save(entity);
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteById(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Product> getAllByMoreTheCountAndPrice(Integer count, Double price) {
        return new ArrayList<>(productRepository.findProductsByCountAfterAndPriceAfter(count, price));
    }

    @Override
    public Integer getNumberOfRecordsMorePrice(Double price) {
        return productRepository.countProductByPriceAfter(price);
    }
}
