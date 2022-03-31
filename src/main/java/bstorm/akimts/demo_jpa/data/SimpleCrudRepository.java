package bstorm.akimts.demo_jpa.data;

import java.util.List;
import java.util.Optional;

public interface SimpleCrudRepository<TEntity, TID> {

    /**
     * Méthode renvoyant une entité sur base de son id encapsulée dans un
     * Optional.
     * @param id l'id de l'entité recherchée
     * @return un Optional rempli si l'élément recherché existe, vide sinon
     */
    Optional<TEntity> getOne(TID id);
    List<TEntity> getAll();

    void insert(TEntity toInsert);

    TEntity delete(TID id);

    TEntity update(TEntity toUpdate);

}
