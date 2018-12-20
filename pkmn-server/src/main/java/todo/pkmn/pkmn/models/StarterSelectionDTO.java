package todo.pkmn.pkmn.models;

import java.io.Serializable;

import todo.pkmn.pkmn.entities.UserPokemonEntity;

public class StarterSelectionDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String userName;

	private Long pkmnId;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getPkmnId() {
		return pkmnId;
	}

	public void setPkmnId(Long pkmnId) {
		this.pkmnId = pkmnId;
	}

}
