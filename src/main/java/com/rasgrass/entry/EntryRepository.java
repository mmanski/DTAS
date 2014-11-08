package com.rasgrass.entry;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author RasGrass
 */
@Repository
@Transactional(isolation = Isolation.READ_COMMITTED)
public class EntryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Entry save(Entry entry) {
        entityManager.persist(entry);
        return entry;
    }
}
