package com.folder.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.folder.app.dao.UserDao;
import com.folder.app.dto.ResultDTO;
import com.folder.app.dto.UserDTO;

@Service
public class UserServiceImp implements UserService {
	
	@Autowired
	UserDao uDao;
	
	private ResultDTO resultDTO;

	@Override
	public ResultDTO list() throws Exception {
		resultDTO = new ResultDTO();
		resultDTO.setState(true);
		List<UserDTO> userList = uDao.selectAll();
		if(userList.size() == 0) {
			resultDTO.setState(false);
		} else {
			resultDTO.setRow(userList);
		}
		return resultDTO;
	}

	@Override
	public ResultDTO select(UserDTO user) throws Exception {
		resultDTO = new ResultDTO();
		resultDTO.setState(true);
		UserDTO userDTO = uDao.selectOne(user);
		if(userDTO == null) {
			resultDTO.setState(false);
		} else {
			resultDTO.setRow(userDTO);
		}
		return resultDTO;
	}

	@Override
	public ResultDTO insert(UserDTO user) throws Exception {
		int result = uDao.insert(user);
		resultDTO = new ResultDTO();
		resultDTO.setState(true);
		if(result == 0) {
			resultDTO.setState(false);
		} else {
			user = uDao.selectNo();
			return select(user);
		}
		return resultDTO;
	}

	@Override
	public ResultDTO update(UserDTO user) throws Exception {
		int result = uDao.update(user);
		resultDTO = new ResultDTO();
		resultDTO.setState(true);
		if(result == 0) {
			resultDTO.setState(false);
		} else {
			return select(user);
		}
		return resultDTO;
	}

	@Override
	public ResultDTO delete(UserDTO user) throws Exception {
		int result = uDao.delete(user);
		resultDTO = new ResultDTO();
		resultDTO.setState(true);
		if(result == 0) {
			resultDTO.setState(false);
		}
		return resultDTO;
	}

}
