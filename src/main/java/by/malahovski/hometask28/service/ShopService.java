package by.malahovski.hometask28.service;


import by.malahovski.hometask28.model.Shop;

import java.util.List;

public interface ShopService extends DefaultService<Shop> {

    List<Shop> getStoresByWarehousesAndShelves(Long storageId, Long shelfId);

    Integer getNumberOfRecordsMoreStorageId(Integer storageId);

    List<String> getStoresNameByWarehousesAndShelves(Long storageId, Long shelfId);
}
