package todo.pkmn.pkmn.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserPokemonEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long userPokemonId;
	
	private UserEntity userEntity;
	
	private PKMNEntity pkmnEntity;
	
	private Long level;

	public Long getUserPokemonId() {
		return userPokemonId;
	}

	public void setUserPokemonId(Long userPokemonId) {
		this.userPokemonId = userPokemonId;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public PKMNEntity getPkmnEntity() {
		return pkmnEntity;
	}

	public void setPkmnEntity(PKMNEntity pkmnEntity) {
		this.pkmnEntity = pkmnEntity;
	}

	public Long getLevel() {
		return level;
	}

	public void setLevel(Long level) {
		this.level = level;
	}
	
}
