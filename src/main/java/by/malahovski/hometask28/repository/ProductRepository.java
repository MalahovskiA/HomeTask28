package by.malahovski.hometask28.repository;


import by.malahovski.hometask28.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findProductsByCountAfterAndPriceAfter(Integer count, Double price);

    Integer countProductByPriceAfter(Double price);

}
