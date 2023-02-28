package com.folder.app.service;

import com.folder.app.dto.ResultDTO;
import com.folder.app.dto.UserDTO;

public interface UserService {

	public ResultDTO list() throws Exception;
	
	public ResultDTO select(UserDTO user) throws Exception;
	
	public ResultDTO insert(UserDTO user) throws Exception;
	
	public ResultDTO update(UserDTO user) throws Exception;
	
	public ResultDTO delete(UserDTO user) throws Exception;
	
}
