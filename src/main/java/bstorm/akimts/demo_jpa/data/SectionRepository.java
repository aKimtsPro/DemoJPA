package bstorm.akimts.demo_jpa.data;

import bstorm.akimts.demo_jpa.models.entities.Section;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class SectionRepository {

    private final EntityManagerFactory managerFactory;

    public SectionRepository(EntityManagerFactory managerFactory ) {
        this.managerFactory = managerFactory;
    }

    public Section getOne( long id ){
        EntityManager manager = managerFactory.createEntityManager();

        Section section = manager.find(Section.class, id);

        manager.close();
        return section;
    }

    public List<Section> getAll(){

        EntityManager manager = managerFactory.createEntityManager();

        TypedQuery<Section> query = manager.createQuery("SELECT s FROM Section s",Section.class);
        List<Section> list = query.getResultList();

        manager.close();

        return list;

    }

    public boolean insert(Section toInsert){

        EntityManager manager = managerFactory.createEntityManager();

        manager.getTransaction().begin();
        try {
            manager.persist(toInsert);
            manager.getTransaction().commit();
            return true;
        }
        catch (RollbackException ex){
            return false;
        }
        catch (EntityExistsException ex){
            manager.getTransaction().rollback();
            return false;
        }
        finally {
            manager.close();
        }

    }

    public Section delete( long id ){

        EntityManager manager = managerFactory.createEntityManager();

        manager.getTransaction().begin();
        try {
            Section toDelete = manager.find(Section.class, id);
            manager.remove( toDelete );
            manager.getTransaction().commit();
            return toDelete;
        }
        catch (Exception ex){
            return null;
        }
        finally {
            manager.close();
        }
    }

    public Section update(long id, Section newValues){

        EntityManager manager = managerFactory.createEntityManager();
        manager.getTransaction().begin();

        Section toUpdate = manager.find(Section.class, id);

        if( toUpdate != null ){
            toUpdate.setName( newValues.getName() );
            toUpdate.setDelegateId( newValues.getDelegateId() );
            manager.getTransaction().commit();
        }
        else
            manager.getTransaction().rollback();

        manager.close();
        return toUpdate;

    }

}
