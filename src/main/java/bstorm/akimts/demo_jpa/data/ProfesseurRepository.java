package bstorm.akimts.demo_jpa.data;

import bstorm.akimts.demo_jpa.exceptions.ElementAlreadyExistsException;
import bstorm.akimts.demo_jpa.models.entities.Professeur;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class ProfesseurRepository implements SimpleCrudRepository<Professeur, Long> {

    private final EntityManager manager;

    public ProfesseurRepository(EntityManager manager) {
        this.manager = manager;
    }


    @Override
    public Optional<Professeur> getOne(Long id) {
        Optional<Professeur> p = Optional.ofNullable( manager.find(Professeur.class, id) );
        manager.clear();
        return p;
    }

    @Override
    public List<Professeur> getAll() {
        TypedQuery<Professeur> query = manager.createQuery("SELECT p FROM Professeur p", Professeur.class);
        List<Professeur> result = query.getResultList();
        manager.clear();
        return result;
    }

    @Override
    public void insert(Professeur toInsert) {
        if( getOne(toInsert.getId()).isEmpty() ) {
            manager.persist(toInsert);
            manager.flush();
            manager.clear();
        }
        else
            throw new ElementAlreadyExistsException();
    }

    @Override
    public Professeur delete(Long id) {

        Professeur p = manager.find(Professeur.class, id);
        if(p != null){
            manager.remove(p);
            manager.flush();
        }
        manager.clear();
        return p;
    }

    @Override
    public Professeur update(Professeur toUpdate) {
        Professeur updated = manager.merge( toUpdate );
        manager.flush();
        manager.detach(updated);
        return updated;
    }

}
