package by.malahovski.hometask28.service;


import by.malahovski.hometask28.model.Shop;

import java.util.List;

public interface ShopService extends DefaultService<Shop> {

    List<Shop> getStoresByWarehousesAndShelves(Long storageId, Integer shelfId);

    Integer getNumberOfRecordsStorageId(Long storageId);

    List<Shop> getAllShops();

    List<Shop> getAlLShopsBySQL();
}
