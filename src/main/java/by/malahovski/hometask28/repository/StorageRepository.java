package by.malahovski.hometask28.repository;


import by.malahovski.hometask28.model.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StorageRepository extends JpaRepository<Storage, Long> {

}
