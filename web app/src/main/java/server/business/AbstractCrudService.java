package server.business;

import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Collection;

public abstract class AbstractCrudService<K,E, REPOSITORY extends JpaRepository<E,K>> {
    protected final REPOSITORY repository;

    public abstract boolean exists(E entity);

    public abstract boolean findById(K key);

    public AbstractCrudService(REPOSITORY repository) {
        this.repository = repository;
    }

    public Collection<E> readAll() {
        return repository.findAll();
    }

    @Transactional
    public void create(E entity) throws Exception {
        if (exists(entity))
            throw new RuntimeException("ERROR");
        repository.save(entity);
    }

    public void delete(K key ) {

        repository.deleteById(key);
    }
}
