package todo.pkmn.pkmn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import todo.pkmn.pkmn.interfaces.service.UserServiceI;
import todo.pkmn.pkmn.models.StarterSelectionDTO;
import todo.pkmn.pkmn.models.UserDTO;

@RestController
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserServiceI userService;
	
	@RequestMapping(method=RequestMethod.POST, value="/register")
	public UserDTO registerUser(@RequestBody final UserDTO userDTO) {
		UserDTO response = null;
		response = userService.registerUser(userDTO);
		return response;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/selectStarter")
	public StarterSelectionDTO selectStarter(@RequestBody final StarterSelectionDTO starterSelectionDTO){
		return userService.selectStarter(starterSelectionDTO);
	}

}
