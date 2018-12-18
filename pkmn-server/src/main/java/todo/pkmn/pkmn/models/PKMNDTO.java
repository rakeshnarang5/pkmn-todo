package todo.pkmn.pkmn.models;

import org.springframework.beans.BeanUtils;

import todo.pkmn.pkmn.entities.PKMNEntity;

public class PKMNDTO {

	Long id;
	String name;
	Long rarity;
	

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

	public static PKMNEntity dtoToEntity(PKMNDTO dto) {
		PKMNEntity entity = null;
		if (null != dto) {
			entity = new PKMNEntity();
			BeanUtils.copyProperties(dto, entity);
		}
		return entity;
	}

	public static PKMNDTO entityToDTO(PKMNEntity entity) {
		PKMNDTO dto = null;
		if (null != entity) {
			dto = new PKMNDTO();
			BeanUtils.copyProperties(entity, dto);
		}
		return dto;
	}

	public Long getRarity() {
		return rarity;
	}

	public void setRarity(Long rarity) {
		this.rarity = rarity;
	}
	
	

}
