package com.folder.app.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.folder.app.dto.UserDTO;
import com.folder.app.mapper.UserMapper;

@Repository
public class UserDaoImp implements UserDao {
	
	@Autowired 
	UserMapper uMapper;

	@Override
	public UserDTO selectNo() {
		UserDTO resultBean;
		try {
			resultBean = uMapper.selectNo();
		} catch (Exception e) {
			e.printStackTrace();
			resultBean = null;
		}
		return resultBean;
	}
	
	@Override
	public List<UserDTO> selectAll() {
		List<UserDTO> resultList;
		try {
			resultList = uMapper.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
			resultList = new ArrayList<UserDTO>();
		}
		return resultList;
	}

	@Override
	public UserDTO selectOne(UserDTO user) {
		UserDTO resultBean;
		try {
			resultBean = uMapper.selectOne(user);
		} catch (Exception e) {
			e.printStackTrace();
			resultBean = null;
		}
		return resultBean;
	}

	@Override
	public int insert(UserDTO user) {
		int result;
		try {
			result = uMapper.insert(user);
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

	@Override
	public int update(UserDTO user) {
		int result;
		try {
			result = uMapper.update(user);
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

	@Override
	public int delete(UserDTO user) {
		int result;
		try {
			result = uMapper.delete(user);
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

}
