package by.malahovski.hometask28.service.impl;

import by.malahovski.hometask28.model.Shop;
import by.malahovski.hometask28.repository.ShopRepository;
import by.malahovski.hometask28.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShopServiceImpl implements ShopService {

    private final ShopRepository shopRepository;

    @Autowired
    public ShopServiceImpl(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    @Override
    public Boolean insertEntity(Shop entity) {
        if (shopRepository.findAll().contains(entity)) {
            return false;
        } else {
            shopRepository.save(entity);
            return true;
        }
    }

    @Override
    public Optional<Shop> getOneById(Long id) {
        return shopRepository.findById(id);
    }

    @Override
    public Boolean updateById(Long id, Shop entity) {
        if (shopRepository.existsById(id)) {
            shopRepository.save(entity);
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteById(Long id) {
        if (shopRepository.existsById(id)) {
            shopRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Shop> getStoresByWarehousesAndShelves(Long storageId, Integer shelfId) {
        return new ArrayList<>(shopRepository.findShopsByStorage_IdAndShelf_Number(storageId, shelfId));
    }

    @Override
    public Integer getNumberOfRecordsStorageId(Long storageId) {
        return shopRepository.countShopsByStorageId(storageId);
    }

    @Override
    public List<Shop> getAllShops() {
        return shopRepository.findAll();
    }

    @Override
    public List<Shop> getAlLShopsBySQL() {
        return shopRepository.findShopsBySQL();
    }
}
