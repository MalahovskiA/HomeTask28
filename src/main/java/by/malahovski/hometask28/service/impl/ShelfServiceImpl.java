package by.malahovski.hometask28.service.impl;

import by.malahovski.hometask28.model.Shelf;
import by.malahovski.hometask28.repository.ShelfRepository;
import by.malahovski.hometask28.service.ShelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShelfServiceImpl implements ShelfService {

    private final ShelfRepository shelfRepository;

    @Autowired
    public ShelfServiceImpl(ShelfRepository shelfRepository) {
        this.shelfRepository = shelfRepository;
    }

    @Override
    public Boolean insertEntity(Shelf entity) {
        if (shelfRepository.findAll().contains(entity)) {
            return false;
        } else {
            shelfRepository.save(entity);
            return true;
        }
    }

    @Override
    public Optional<Shelf> getOneById(Long id) {
        return shelfRepository.findById(id);
    }

    @Override
    public Boolean updateById(Long id, Shelf entity) {
        if (shelfRepository.existsById(id)) {
            shelfRepository.save(entity);
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteById(Long id) {
        if (shelfRepository.existsById(id)) {
            shelfRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Shelf> getNumberOfRowsAndFields(Integer row, Integer fields) {
        return new ArrayList<>(shelfRepository.findShelvesByNumberOfRowAfterAndNumberAfter(row, fields));
    }

    @Override
    public Integer getNumberOfRecords(Integer number) {
        return shelfRepository.countShelfByNumberAfter(number);
    }
}
