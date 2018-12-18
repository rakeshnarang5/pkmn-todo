package todo.pkmn.pkmn.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import todo.pkmn.pkmn.interfaces.service.PKMNServiceI;
import todo.pkmn.pkmn.models.PKMNDTO;
import todo.pkmn.pkmn.models.PKMNDTOList;

@RestController
public class PKMNController {
	
	@Autowired
	PKMNServiceI pkmnServiceI;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		return "Welcome to the world of Pokemon TODO";
	}
	
	@RequestMapping(value="/createPKMN", method=RequestMethod.POST)
	public List<PKMNDTO> createPKMN(@RequestBody final PKMNDTOList pkmnDtoList){
		List<PKMNDTO> pkmndtos = new ArrayList<>();
		Random random = new Random();
		for(PKMNDTO pkmnName : pkmnDtoList.getPkmnNames()) {
			pkmndtos.add(pkmnServiceI.createPKMN(pkmnName,random));
		}
		return pkmndtos;
	}

	@RequestMapping(value="/getAllPKMN", method=RequestMethod.GET) 
	public List<PKMNDTO> getAllPKMN() {
		return pkmnServiceI.getAllPKMN();
	}
	
	@RequestMapping(value="/hatch", method=RequestMethod.GET)
	public PKMNDTO hatch() {
		return pkmnServiceI.hatch();
	}
	
	@RequestMapping(value="/getPKMNByRarity/{rarity}", method=RequestMethod.GET)
	public List<PKMNDTO> getPKMNByRarity(@PathVariable final String rarity) {
		return pkmnServiceI.getPKMNByRarity(Long.valueOf(rarity));
	}

}
