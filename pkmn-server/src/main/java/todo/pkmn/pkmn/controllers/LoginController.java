package todo.pkmn.pkmn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import todo.pkmn.pkmn.interfaces.service.UserServiceI;
import todo.pkmn.pkmn.models.LoginDTO;

@RestController
public class LoginController {
	
	@Autowired
	private UserServiceI userService;
	
	@RequestMapping(value="/login/user", method=RequestMethod.POST)
	public ResponseEntity<Boolean> loginUser(@RequestBody final LoginDTO loginDTO) {
		return ResponseEntity.ok(userService.loginUser(loginDTO));
	}

}
