package bstorm.akimts.demo_jpa.data;

import bstorm.akimts.demo_jpa.exceptions.ElementAlreadyExistsException;
import bstorm.akimts.demo_jpa.models.entities.Cours;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public class CoursRepository {

    private final EntityManager manager;

    public CoursRepository(EntityManager manager) {
        this.manager = manager;
    }

    public Cours getOne(String id){
        return manager.find(Cours.class, id);
    }

    public List<Cours> getAll(){
        TypedQuery<Cours> query = manager.createQuery("SELECT c FROM Cours c", Cours.class);
        return query.getResultList();
    }

    @Transactional
    public void insert(Cours toInsert){
        if( getOne(toInsert.getId()) != null )
            throw new ElementAlreadyExistsException();

        manager.persist(toInsert);
    }

    @Transactional
    public Cours delete(String id){
        Cours toDelete = getOne(id);

        if(toDelete != null)
            manager.remove( toDelete );

        return toDelete;
    }

    @Transactional
    public Cours update(Cours toUpdate){
        Cours c = getOne(toUpdate.getId());

        if( c != null ){
            c.setName(toUpdate.getName());
            c.setEcts(toUpdate.getEcts());
            c.setProfessorId(toUpdate.getProfessorId());
        }

        return c;
    }
}
