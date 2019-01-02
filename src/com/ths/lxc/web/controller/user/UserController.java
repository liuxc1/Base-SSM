package com.ths.lxc.web.controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ths.lxc.model.user.User;
import com.ths.lxc.service.user.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService service;

   @RequestMapping("/index")
   public String index(HttpServletRequest request){
	   request.setAttribute("All", service.getAll());
	   return "user";
   }
   @ResponseBody
   @RequestMapping("/index1")
   public List<User> test(){
	   
	return service.getAll();
   }
	
}
