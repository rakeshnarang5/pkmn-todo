package todo.pkmn.pkmn.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PKMNEntity {

	@Id
	private Long id;
	private String name;
	private Long rarity;
	private boolean willHatch;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getRarity() {
		return rarity;
	}

	public void setRarity(Long rarity) {
		this.rarity = rarity;
	}

	public boolean isWillHatch() {
		return willHatch;
	}

	public void setWillHatch(boolean willHatch) {
		this.willHatch = willHatch;
	}
	

}
