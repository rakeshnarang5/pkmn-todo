package todo.pkmn.pkmn.interfaces.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import todo.pkmn.pkmn.entities.PKMNEntity;

@Repository
public interface PKMNDaoI extends CrudRepository<PKMNEntity, Long> {
	
	@Query("select s from PKMNEntity s where s.rarity = :rarity")
	List<PKMNEntity> findPKMNEntityByRarity(@Param("rarity") Long rarity);
	
}
