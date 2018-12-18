package todo.pkmn.pkmn.interfaces.service;

import java.util.List;
import java.util.Random;

import todo.pkmn.pkmn.models.PKMNDTO;

public interface PKMNServiceI {
	
	public PKMNDTO createPKMN(PKMNDTO pkmndto, Random random);

	public List<PKMNDTO> getAllPKMN();

	public PKMNDTO hatch();

	public List<PKMNDTO> getPKMNByRarity(Long valueOf);

}
