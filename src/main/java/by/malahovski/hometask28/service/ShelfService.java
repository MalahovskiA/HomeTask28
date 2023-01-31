package by.malahovski.hometask28.service;


import by.malahovski.hometask28.model.Shelf;

import java.util.List;

public interface ShelfService extends DefaultService<Shelf> {

    List<Shelf> getNumberOfRowsAndFields(Integer row, Integer fields);

    Integer getNumberOfRecords(Integer number);
}
