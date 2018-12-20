package todo.pkmn.pkmn.implementations.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import todo.pkmn.pkmn.entities.PKMNEntity;
import todo.pkmn.pkmn.interfaces.dao.PKMNDaoI;
import todo.pkmn.pkmn.interfaces.service.PKMNServiceI;
import todo.pkmn.pkmn.models.PKMNDTO;

@Service
public class PKMNServiceImpl implements PKMNServiceI {

	@Autowired
	private PKMNDaoI PKMNDaoI;

	@Override
	public PKMNDTO createPKMN(PKMNDTO pkmndto, Random random) {
		PKMNEntity pkmnEntity = PKMNDTO.dtoToEntity(pkmndto);
		pkmnEntity = PKMNDaoI.save(pkmnEntity);
		return PKMNDTO.entityToDTO(pkmnEntity);
	}

	private boolean calculateHatchResult(PKMNEntity pkmnEntity, Random random) {
		boolean willHatch = false;
		Long rarity = pkmnEntity.getRarity();
		Float probability = calculateProbability(rarity);
		if (probability == 100.0f)
			return true;
		if (probability != 0.0f) {
			int maxNum = (int) (100.0 / probability);
			int expected = random.nextInt(maxNum);
			int actual = random.nextInt(maxNum);
			if (expected == actual) {
				System.out.println(pkmnEntity.getName());
				System.out.println(actual);
				System.out.println(expected);
				willHatch = true;
			}
		}
		return willHatch;
	}

	private Float calculateProbability(Long rarity) {
		Float probability = 0.0f;
		if (rarity == 1l)
			probability = 10.0f;
		else if (rarity == 2l)
			probability = 2.0f;
		else if (rarity == 3l)
			probability = 1.0f;
		else if (rarity == 4l)
			probability = 0.1f;
		else if (rarity == 5l)
			probability = 0.1f;
		else if (rarity == 6l)
			probability = 0.01f;
		else if (rarity == 7l)
			probability = 0.01f;
		else if (rarity == 8l)
			probability = 0.01f;
		else if (rarity == 9l)
			probability = 0.001f;
		else if (rarity == 10l)
			probability = 0.0001f;
		return probability;
	}

	@Override
	public List<PKMNDTO> getAllPKMN() {
		List<PKMNDTO> pkmndtos = new ArrayList<>();
		Iterable<PKMNEntity> pkmnEntities = PKMNDaoI.findAll();
		for (PKMNEntity pkmnEntity : pkmnEntities) {
			pkmndtos.add(PKMNDTO.entityToDTO(pkmnEntity));
		}
		return pkmndtos;
	}

	@Override
	public PKMNDTO hatch() {
		PKMNDTO pkmndto = null;
		Random random = new Random();
		Iterable<PKMNEntity> pkmnEntities = PKMNDaoI.findAll();
		Map<Long, List<PKMNEntity>> hatchedPkmnEntitiesMap = new HashMap<>();
		for (PKMNEntity pkmnEntity : pkmnEntities) {
			boolean willHatch = calculateHatchResult(pkmnEntity, random);
			if (willHatch && !hatchedPkmnEntitiesMap.containsKey(pkmnEntity.getRarity())) {
				hatchedPkmnEntitiesMap.put(pkmnEntity.getRarity(), new ArrayList<>());

			}
			if (willHatch) {
				System.out.println(pkmnEntity.getName() + ", " + pkmnEntity.getRarity());
				hatchedPkmnEntitiesMap.get(pkmnEntity.getRarity()).add(pkmnEntity);
			}
		}
		Long maxRarityKey = 0l;
		for (Long key : hatchedPkmnEntitiesMap.keySet()) {
			if (key >= maxRarityKey)
				maxRarityKey = key;
		}
		int size = hatchedPkmnEntitiesMap.get(maxRarityKey).size();
		pkmndto = PKMNDTO.entityToDTO(hatchedPkmnEntitiesMap.get(maxRarityKey).get(random.nextInt(size)));
		return pkmndto;
	}

	@Override
	public List<PKMNDTO> getPKMNByRarity(Long valueOf) {
		List<PKMNEntity> pkmnEntities = PKMNDaoI.findPKMNEntityByRarity(valueOf);
		List<PKMNDTO> pkmndtos = new ArrayList<>();
		convertEntitiesListToDTOs(pkmnEntities, pkmndtos);
		return pkmndtos;
	}

	private void convertEntitiesListToDTOs(List<PKMNEntity> pkmnEntities, List<PKMNDTO> pkmndtos) {
		for(PKMNEntity pkmnEntity : pkmnEntities) {
			pkmndtos.add(PKMNDTO.entityToDTO(pkmnEntity));
		}
	}

	@Override
	public List<PKMNDTO> fetchStarter() {
		List<PKMNDTO> pkmndtos = new ArrayList<>();
		List<Long> ids = Arrays.asList(1l,4l,7l,25l);
		List<PKMNEntity> pkmnEntities = PKMNDaoI.fetchStarter(ids);
		convertEntitiesListToDTOs(pkmnEntities, pkmndtos);
		return pkmndtos;
	}

}
