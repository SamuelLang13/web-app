package server.business;

import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import server.api.exception.NoEntityFoundException;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

public abstract class AbstractCrudService<K,E, REPOSITORY extends JpaRepository<E,K>> {
    protected final REPOSITORY repository;

    public abstract boolean exists(E entity);

    public abstract boolean findById(K key);
    public abstract Optional<E> getById(K key);

//    public abstract void update(K key,E entity);

    public AbstractCrudService(REPOSITORY repository) {
        this.repository = repository;
    }

    public Collection<E> readAll() {
        return repository.findAll();
    }

    @Transactional
    public void create(E entity) throws Exception {
        if (exists(entity))
            throw new NoEntityFoundException();
        repository.save(entity);
    }

    public void delete(K key ) {
        repository.deleteById(key);
    }

    public E getEntityById(K id) {
        Optional<E> entity = repository.findById(id);
        if(entity.isEmpty()) {
            throw new NoEntityFoundException();
        }
        return entity.get();
    }

}
