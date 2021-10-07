package fpt.fa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fpt.fa.entities.User;
import fpt.fa.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService; 
	
	@RequestMapping(value = {"/createUser"}, method = RequestMethod.GET)
	public String showCreateUser(Model model) {
		model.addAttribute("user", new User());
		return "user/create";
	}
	
	@RequestMapping(value = {"/createUser"}, method = RequestMethod.POST)
	public String saveUser(@ModelAttribute User user) {
		userService.save(user);
		return "redirect:listUser";
	}
	
	@RequestMapping(value = {"/listUser"}, method = RequestMethod.GET)
	public String showListUser(Model model) {
		List<User> listUser =  userService.list();
		model.addAttribute("listUser", listUser);
		return "user/list";
	}
	
	@RequestMapping(value = {"/detailUser/{userName}"}, method = RequestMethod.GET)
	public String showListUser(@PathVariable String userName, Model model) {
		User user = userService.getUserByName(userName);
		model.addAttribute("user", user);
		return "user/detail";
	}
	
	@RequestMapping(value = {"/updateUser/{userName}"}, method = RequestMethod.GET)
	public String showUpdateUser(@PathVariable String userName, Model model) {
		User user = userService.getUserByName(userName);
		model.addAttribute("user", user);
		return "user/update";
	}
	
	@RequestMapping(value = {"/updateUser"}, method = RequestMethod.POST)
	public String updateUser(@ModelAttribute User user) {
		userService.update(user);
		return "redirect:listUser";
	}
}
