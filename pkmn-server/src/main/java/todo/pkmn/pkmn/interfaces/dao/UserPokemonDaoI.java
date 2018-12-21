package todo.pkmn.pkmn.interfaces.dao;

import org.springframework.data.repository.CrudRepository;

import todo.pkmn.pkmn.entities.UserPokemonEntity;

public interface UserPokemonDaoI extends CrudRepository<UserPokemonEntity, Long> {

}
