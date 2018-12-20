package todo.pkmn.pkmn.interfaces.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import todo.pkmn.pkmn.entities.UserEntity;

@Repository
public interface UserDaoI extends CrudRepository<UserEntity, Long> {
	
	@Query("select s from UserEntity s where s.userName = :userName")
	UserEntity findUserByUserName(@Param("userName") String userName);

}
