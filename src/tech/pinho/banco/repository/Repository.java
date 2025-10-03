package tech.pinho.banco.repository;

import java.util.List;
import java.util.Optional;

public interface Repository<T, E> {

    T save(T obj);

    T update(T obj);

    List<T> findAll();

    Optional<T> findById(E id);
}
