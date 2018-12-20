package todo.pkmn.pkmn.implementations.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import todo.pkmn.pkmn.entities.UserEntity;
import todo.pkmn.pkmn.interfaces.dao.UserDaoI;
import todo.pkmn.pkmn.interfaces.service.UserServiceI;
import todo.pkmn.pkmn.models.LoginDTO;
import todo.pkmn.pkmn.models.StarterSelectionDTO;
import todo.pkmn.pkmn.models.UserDTO;

@Service
public class UserServiceImpl implements UserServiceI {

	@Autowired
	private UserDaoI userDao;

	@Override
	public UserDTO registerUser(UserDTO userDTO) {
		UserEntity userEntity = UserDTO.dtoToEntity(userDTO);
		userEntity.setPassword(DigestUtils.md5Hex(userEntity.getPassword()));
		return UserDTO.entityToDTO(userDao.save(userEntity));
	}

	@Override
	public Boolean loginUser(LoginDTO loginDTO) {
		UserEntity userEntity = userDao.findUserByUserName(loginDTO.getUserName());
		String password = DigestUtils.md5Hex(loginDTO.getPassword());
		return password.equals(userEntity.getPassword());
	}

	@Override
	public StarterSelectionDTO selectStarter(StarterSelectionDTO starterSelectionDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
