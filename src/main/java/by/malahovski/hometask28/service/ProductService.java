package by.malahovski.hometask28.service;


import by.malahovski.hometask28.model.Product;

import java.util.List;

public interface ProductService extends DefaultService<Product> {

    List<Product> getAllByMoreTheCountAndPrice(Integer count, Double price);

    Integer getNumberOfRecordsMorePrice(Double price);
}
