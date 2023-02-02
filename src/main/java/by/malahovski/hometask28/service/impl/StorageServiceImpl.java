package by.malahovski.hometask28.service.impl;

import by.malahovski.hometask28.model.Storage;
import by.malahovski.hometask28.repository.StorageRepository;
import by.malahovski.hometask28.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StorageServiceImpl implements StorageService {

    private final StorageRepository storageRepository;

    @Autowired
    public StorageServiceImpl(StorageRepository storageRepository) {
        this.storageRepository = storageRepository;
    }

    @Override
    public Boolean insertEntity(Storage entity) {
        if (storageRepository.findAll().contains(entity)) {
            return false;
        } else {
            storageRepository.save(entity);
            return true;
        }
    }

    @Override
    public Optional<Storage> getOneById(Long id) {
        return storageRepository.findById(id);
    }

    @Override
    public Boolean updateById(Long id, Storage entity) {
        if (storageRepository.existsById(id)) {
            storageRepository.save(entity);
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteById(Long id) {
        if (storageRepository.existsById(id)) {
            storageRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Storage> getStorageByMoreTheIdAndArea(Long productId, Double area) {
        return new ArrayList<>(storageRepository.findStoragesByProduct_IdAndAreaAfter(productId, area));
    }

    @Override
    public Integer getNumberOfRecordsArea(Double area) {
        return storageRepository.countStorageByAreaAfter(area);
    }
}
