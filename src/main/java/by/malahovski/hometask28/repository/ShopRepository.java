package by.malahovski.hometask28.repository;


import by.malahovski.hometask28.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {

    List<Shop> findShopsByStorage_IdAndShelf_Number(Long storage_id, Integer shelf_number);

    Integer countShopsByStorageId(Long storageId);

    @Query( value = "select s,f,g,p from Shop s join Shelf f on s.shelf.id = f.id join Storage g on s.storage.id = g.id join Product p on p.id = f.id")
    List<Shop> findShopsBySQL();
    // попробовал явное внутреннее соединение таблиц с использовнием JOIN, хотя достаточно в
    // ShopRepository дернуть метод findAll()
}
