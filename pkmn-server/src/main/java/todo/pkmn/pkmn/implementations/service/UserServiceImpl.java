package todo.pkmn.pkmn.implementations.service;

import java.util.Optional;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import todo.pkmn.pkmn.entities.PKMNEntity;
import todo.pkmn.pkmn.entities.UserEntity;
import todo.pkmn.pkmn.entities.UserPokemonEntity;
import todo.pkmn.pkmn.interfaces.dao.PKMNDaoI;
import todo.pkmn.pkmn.interfaces.dao.UserDaoI;
import todo.pkmn.pkmn.interfaces.dao.UserPokemonDaoI;
import todo.pkmn.pkmn.interfaces.service.UserServiceI;
import todo.pkmn.pkmn.models.LoginDTO;
import todo.pkmn.pkmn.models.StarterSelectionDTO;
import todo.pkmn.pkmn.models.UserDTO;

@Service
public class UserServiceImpl implements UserServiceI {

	@Autowired
	private UserDaoI userDao;
	
	@Autowired
	private PKMNDaoI pkmnDao;
	
	@Autowired
	private UserPokemonDaoI userPokemonDao;

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
	public void selectStarter(StarterSelectionDTO starterSelectionDTO) {
		UserPokemonEntity userPokemonEntity = new UserPokemonEntity();
		Optional<PKMNEntity> pkmnEntity = pkmnDao.findById(starterSelectionDTO.getPkmnId());
		UserEntity userEntity = userDao.findUserByUserName(starterSelectionDTO.getUserName());
		userPokemonEntity.setLevel(5l);
		userPokemonEntity.setPkmnEntity(pkmnEntity.get());
		userPokemonEntity.setUserEntity(userEntity);
		userPokemonDao.save(userPokemonEntity);
	}

	@Override
	public UserDTO getUser(String userName) {
		return UserDTO.entityToDTO(userDao.findUserByUserName(userName));
	}

}
