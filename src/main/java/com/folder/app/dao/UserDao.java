package com.folder.app.dao;

import java.util.List;

import com.folder.app.dto.UserDTO;

public interface UserDao {

	public UserDTO selectNo();
	
	public List<UserDTO> selectAll();
	
	public UserDTO selectOne(UserDTO user);
	
	public int insert(UserDTO user);
	
	public int update(UserDTO user);
	
	public int delete(UserDTO user);
	
}
