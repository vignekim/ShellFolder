package com.folder.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.folder.app.dto.ResultDTO;
import com.folder.app.dto.UserDTO;
import com.folder.app.service.UserService;

@Controller
@RequestMapping("/user")
public class UserViewController {
	
	private String PATH = "/User";
	
	@Autowired
	UserService uService;
	
	@GetMapping("/list")
	public String list(Model model) throws Exception {
		model.addAttribute("result", uService.list());
		return PATH +"/List";
	}
	
	@GetMapping("/create")
	public String create() throws Exception {
		return PATH +"/Create";
	}
	
	@GetMapping("/select")
	public String select(@ModelAttribute UserDTO user, Model model) throws Exception {
		ResultDTO resultDTO = uService.select(user);
		if(resultDTO.isState()) {
			model.addAttribute("result", resultDTO);
			return PATH +"/Select";
		} else {
			return "redirect:/user/list";
		}
	}
	
	@GetMapping("/delete")
	public String delete(@ModelAttribute UserDTO user) throws Exception {
		uService.delete(user);
		return "redirect:/user/list";
	}
	
	@GetMapping("/update")
	public String update(@ModelAttribute UserDTO user, Model model) throws Exception {
		ResultDTO resultDTO = uService.select(user);
		if(resultDTO.isState()) {
			model.addAttribute("result", resultDTO);
			return PATH +"/Update";
		} else {
			return "redirect:/user/list";
		}
	}
	
	@PostMapping("/updateForm")
	public String updateForm(@ModelAttribute UserDTO user, Model model) throws Exception {
		if(user == null) {return "redirect:/user/list";}
		else {
			ResultDTO resultDTO = uService.update(user);
			if(resultDTO.isState()) {
				model.addAttribute("result", resultDTO);
			} 
			return "redirect:/user/select?no=" + user.getNo();
		}
	}
	
	@PostMapping("/createForm")
	public String createForm(@ModelAttribute UserDTO user) throws Exception {
		ResultDTO resultDTO = uService.insert(user);
		if(resultDTO.isState()) {
			UserDTO uDTO = (UserDTO) resultDTO.getRow();
			return "redirect:/user/select?no=" + uDTO.getNo();
		}
		return "redirect:/user/list";
	}

}
