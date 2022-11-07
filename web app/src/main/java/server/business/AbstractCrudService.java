package server.business;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public abstract class AbstractCrudService<K,E, REPOSITORY extends JpaRepository<E,K>> {

    private REPOSITORY repository;

    public Collection<E> readAll() {
        return repository.findAll();
    }
}
