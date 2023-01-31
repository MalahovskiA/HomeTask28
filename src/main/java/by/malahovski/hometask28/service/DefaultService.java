package by.malahovski.hometask28.service;

import java.util.Optional;

public interface DefaultService<T> {

    Boolean insertEntity(T entity);

    Optional<T> getOneById(Long id);

    Boolean updateById(Long id, T entity);

    Boolean deleteById(Long id);
}
