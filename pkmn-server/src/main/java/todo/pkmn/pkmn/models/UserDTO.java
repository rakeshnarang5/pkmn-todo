package todo.pkmn.pkmn.models;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;

import todo.pkmn.pkmn.entities.UserEntity;

public class UserDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long userId;

	private String userName;

	private String email;
	
	private String password;
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static UserEntity dtoToEntity(UserDTO dto) {
		UserEntity entity = null;
		if (null != dto) {
			entity = new UserEntity();
			BeanUtils.copyProperties(dto, entity);
		}
		return entity;
	}

	public static UserDTO entityToDTO(UserEntity entity) {
		UserDTO dto = null;
		if (null != entity) {
			dto = new UserDTO();
			BeanUtils.copyProperties(entity, dto);
			dto.setPassword(null);
		}
		return dto;
	}

}
