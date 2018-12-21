package todo.pkmn.pkmn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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
	public ResponseEntity<Boolean> selectStarter(@RequestBody final StarterSelectionDTO starterSelectionDTO){
		userService.selectStarter(starterSelectionDTO);
		return ResponseEntity.ok(true);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getUser/{userName}")
	public UserDTO getUser(@PathVariable final String userName){
		return userService.getUser(userName);
	}

}
