package com.crud.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {
	
	@RequestMapping("/login")
	public String getLoginForm() {
		return "view/loginForm.jsp";
	}
	
	@RequestMapping(value="/login_action",method=RequestMethod.POST)
	public void checkCreds(
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			HttpServletRequest req,
			HttpServletResponse res)
					throws IOException{
		
		if(username.equals("admin")&& password.equals("@dmin")) {
			req.getSession().setAttribute("username", username);
			res.sendRedirect("dashboard");
		} else {
			res.sendRedirect("login");
		}
		
	}
	
	@RequestMapping("/logout")
	public void logoutUser(HttpServletRequest req,HttpServletResponse res)throws IOException {
		req.getSession().invalidate();
		res.sendRedirect("login");
	}
}
