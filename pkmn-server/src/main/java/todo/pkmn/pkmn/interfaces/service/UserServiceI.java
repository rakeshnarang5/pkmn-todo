package todo.pkmn.pkmn.interfaces.service;

import todo.pkmn.pkmn.models.LoginDTO;
import todo.pkmn.pkmn.models.StarterSelectionDTO;
import todo.pkmn.pkmn.models.UserDTO;

public interface UserServiceI {

	UserDTO registerUser(UserDTO userDTO);

	Boolean loginUser(LoginDTO loginDTO);

	void selectStarter(StarterSelectionDTO starterSelectionDTO);

	UserDTO getUser(String userName);

}
