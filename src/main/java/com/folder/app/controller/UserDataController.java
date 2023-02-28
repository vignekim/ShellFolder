package com.folder.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.folder.app.dto.ResultDTO;
import com.folder.app.dto.UserDTO;
import com.folder.app.service.UserService;

@RestController
@RequestMapping("/user/data")
public class UserDataController {
	
	@Autowired
	UserService uService;

	@PostMapping("/list")
	public ResultDTO all() throws Exception{
		return uService.list(); 
	}
	
	@PostMapping("/select")
	public ResultDTO one(@ModelAttribute UserDTO user) throws Exception{
		return uService.select(user);
	}
	
	@PostMapping("/insert")
	public ResultDTO insert(@ModelAttribute UserDTO user) throws Exception{
		return uService.insert(user);
	}
	
	@PostMapping("/update")
	public ResultDTO update(@ModelAttribute UserDTO user) throws Exception{
		return uService.update(user);
	}
	
	@PostMapping("/delete")
	public ResultDTO delete(@ModelAttribute UserDTO user) throws Exception{
		return uService.delete(user);
	}
	
}
