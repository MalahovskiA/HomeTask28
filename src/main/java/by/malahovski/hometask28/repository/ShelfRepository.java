package by.malahovski.hometask28.repository;

import by.malahovski.hometask28.model.Shelf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ShelfRepository extends JpaRepository<Shelf, Long> {

    List<Shelf> findShelvesByNumberOfRowAfterAndNumberAfter(Integer row, Integer fields);

    Integer countShelfByNumberAfter(Integer number);
}
