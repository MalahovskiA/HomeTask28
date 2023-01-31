package by.malahovski.hometask28.service;


import by.malahovski.hometask28.model.Storage;

import java.util.List;

public interface StorageService extends DefaultService<Storage> {

    List<Storage> getStorageByMoreTheIdAndArea(Integer productId, Double area);

    List<String> getValuesByMoreTheIdAndArea(Integer productId, Double area);

    Integer getNumberOfRecordsArea(Double area);
}
